package com.wqstore.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.wqstore.dao.SellOrderItemMapper;
import com.wqstore.dao.SellOrderMapper;
import com.wqstore.domain.SellOrder;
import com.wqstore.domain.SellOrderExample;
import com.wqstore.domain.SellOrderExample.Criteria;
import com.wqstore.domain.SellOrderItem;
import com.wqstore.domain.SellOrderItemExample;
import com.wqstore.result.PageParam;
import com.wqstore.result.RequestPageVo;
import com.wqstore.result.RequestResultVo;
import com.wqstore.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	public static final Integer WAIT_PAYMENT_ORDER_STATE = 1; 
	
	public static final Integer WAIT_DELIVERY_ORDER_STATE = 2;
	
	public static final Integer COMPLETE_DELIVERY_ORDER_STATE = 3; 
	
	public static final Integer COMPLETE_RECEIPT_ORDER_STATE = 4; 
	
	public static final Integer COMPLETE_ORDER_STATE = 5; 
	
	public static final Integer CLOSE_ORDER_STATE = 6; 
	
	public static final Integer CANCEL_ORDER_STATE = 7; 
	
	public static final Integer WAIT_PAYMENT_STATE = 0;
	
	public static final Integer COMPLETE_PAYMENT_STATE = 1;
	public  static  final  Integer  ISDElETED=0;
	
	

	@Resource
	private SellOrderMapper sellOrderMapper;
	
	@Resource
	private SellOrderItemMapper sellOrderItemMapper;
	
	@Override
	public RequestPageVo<SellOrder> findOrderPageList(PageParam param,
			SellOrder sellOrder, Date startTime, Date endTime) {
		RequestPageVo<SellOrder> page = new RequestPageVo<SellOrder>();
		
		SellOrderExample example = new SellOrderExample();
		example.setOrderByClause("create_time desc");
		Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		//条件查询
		if(sellOrder != null) {
			if(StringUtils.isNotBlank(sellOrder.getOrderCode())) {
				criteria.andOrderCodeEqualTo(sellOrder.getOrderCode());
			}
			if(StringUtils.isNotBlank(sellOrder.getGoodReceiverName())){
				criteria.andGoodReceiverNameLike(sellOrder.getGoodReceiverName());
			}
			if(sellOrder.getPaymentState() != null){
				criteria.andPaymentStateEqualTo(sellOrder.getPaymentState());
			}
			if(sellOrder.getPaymentType() != null){
				criteria.andPaymentTypeEqualTo(sellOrder.getPaymentType());
			}
			if(sellOrder.getOrderState() != null){
				criteria.andOrderStateEqualTo(sellOrder.getOrderState());
			}
			if(startTime != null) {
				criteria.andCreateTimeGreaterThanOrEqualTo(startTime);
			}
			if(endTime != null) {
				criteria.andCreateTimeLessThanOrEqualTo(endTime);
			}
		}
		
		try {
			int count = sellOrderMapper.countByExample(example);
			if(count >0) {
				example.setStartPage(param.getOffset());
				example.setPageSize(param.getLimit());
				List<SellOrder> list = sellOrderMapper.selectByExample(example);
				
				page.setLimit(param.getLimit());
				page.setOffset(param.getOffset());
				page.setRows(list);
				page.setTotal(count);
			}
		} catch (Exception e) {
			log.error("findOrderPageList",e);
		}
		
		return page;
	}

	@Override
	@Transactional
	public RequestResultVo<String> deleteOrderById(Long id) {
		
		
		return null;
	}

	@Override
	public SellOrder findOrderDetailById(Long id) {
		SellOrder sellOrder = null;
		try {
			sellOrder = sellOrderMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			log.error("deleteOrderById",e);
		}
		return sellOrder;
	}

	@Override
	public List<SellOrderItem> findOrderItemsByOrderId(Long id) {
		List<SellOrderItem> items = null;
		
		SellOrderItemExample example = new SellOrderItemExample();
		SellOrderItemExample.Criteria criteria = example.createCriteria();
		criteria.andSoIdEqualTo(id);
		try {
			items = sellOrderItemMapper.selectByExample(example);
		} catch (Exception e) {
			log.error("findOrderItemsByOrderId",e);
		}
		return items;
	}


	@Override
	@Transactional
	public RequestResultVo<SellOrder> updateOrderById(SellOrder sellOrder) {
		RequestResultVo<SellOrder> result = new RequestResultVo<SellOrder>();
		
//		Long lock = this.getOrderOptimisticLock(sellOrder.getId());
//		lock = lock == null?0:lock;
//		sellOrder.setVersionNo(lock +1);
//		Long originalLock = sellOrder.getVersionNo();
		
		int count = sellOrderMapper.updateByPrimaryKeySelective(sellOrder);
		
//		Long currentLock = getOrderOptimisticLock(sellOrder.getId());
//		
//		if(!originalLock.equals(currentLock)){
//			log.error("Order concurrent execution update error!");
//		}
//
//		Assert.isTrue(originalLock.equals(currentLock) , "order update fail!");
		
		
		Assert.isTrue(count >0 , "order update fail!");
		//分摊金额到各个单品上
		if(sellOrder.getOrderDealAmount() != null) {
			SellOrder order = sellOrderMapper.selectByPrimaryKey(sellOrder.getId());
			
			BigDecimal dealAmount = sellOrder.getOrderDealAmount().subtract(order.getOrderDeliveryFee());
			
			SellOrderItemExample example = new SellOrderItemExample();
			SellOrderItemExample.Criteria criteria = example.createCriteria();
			criteria.andSoIdEqualTo(order.getId());
			
			List<SellOrderItem> items = sellOrderItemMapper.selectByExample(example);
			
			BigDecimal totalAmount = new BigDecimal(0);
			
			//前n-1个订单商品根据商品总金额 与 产品总金额(各个订单明细的金额总和)占比进行分摊
			for (int i = 0; i < items.size() -1; i++) {
				SellOrderItem item = items.get(i);
				BigDecimal rate = item.getItemAmount().divide(order.getProductAmount(),4);
				BigDecimal itemDealAmount = rate.multiply(dealAmount);
				item.setItemDealAmount(itemDealAmount);
				totalAmount = totalAmount.add(itemDealAmount);
			}
			
			//将余下的金额划分到最后一个订单商品
			SellOrderItem lastItem = items.get(items.size()-1);
			lastItem.setItemDealAmount(dealAmount.subtract(totalAmount));
			
			//批更新
			//sellOrderItemMapper.batchUpdateOrderItem(items);
			
			
			result.setResult(order);
		}
		
		return result;
	}

	@Override
	public RequestResultVo<SellOrder> updateOrderItemByOrderId(SellOrder sellOrder) {
		
		return null;
	}

	

	@Override
	@Transactional
	public RequestResultVo<String> updateOrderPaymentType(SellOrder sellOrder) {
		RequestResultVo<String> result = new RequestResultVo<String>();
		
		sellOrder.setPaymentState(COMPLETE_PAYMENT_STATE);
		sellOrder.setPaymentConfirmDate(new Date());
		sellOrder.setOrderState(WAIT_DELIVERY_ORDER_STATE);
		
		SellOrder order = sellOrderMapper.selectByPrimaryKey(sellOrder.getId());
		if(WAIT_PAYMENT_STATE.equals(order.getPaymentState())) {
			
//			Long lock = order.getVersionNo();
//			
//			lock = lock == null?0:lock;
//			
//			sellOrder.setVersionNo(lock +1);
//			Long originalLock = sellOrder.getVersionNo();
			
			int count = sellOrderMapper.updateByPrimaryKeySelective(sellOrder);
			
//			Long currentLock = getOrderOptimisticLock(sellOrder.getId());
//			
//			if(!originalLock.equals(currentLock)){
//				log.error("Order concurrent execution update error!");
//			}
//
//			Assert.isTrue(originalLock.equals(currentLock) , "order update fail!");
			
			Assert.isTrue(count >0 , "order update fail!");
		}
		
		return result;
	}
	

	@Override
	public RequestPageVo<SellOrder> findWaiteDeliveryDetaileList(
			PageParam param, SellOrder sellOrder) {
        RequestPageVo<SellOrder> page = new RequestPageVo<SellOrder>();
		SellOrderExample example = new SellOrderExample();
		example.setOrderByClause("create_time desc");
		Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(ISDElETED);
		//条件查询
		if(sellOrder != null) {
			if(StringUtils.isNotBlank(sellOrder.getOrderCode())) {
				criteria.andOrderCodeEqualTo(sellOrder.getOrderCode());
			}
			if(StringUtils.isNotBlank(sellOrder.getGoodReceiverName())){
				criteria.andGoodReceiverNameLike(sellOrder.getGoodReceiverName());
			}
			
			if(sellOrder.getOrderState() != null){
				criteria.andOrderStateEqualTo(sellOrder.getOrderState());
			}else{
				//默认查询出待发货或者已经收货
				criteria.andOrderStateBetween(WAIT_DELIVERY_ORDER_STATE, COMPLETE_DELIVERY_ORDER_STATE);
			}
			
		}
		
		try {
			int count = sellOrderMapper.countByExample(example);
			if(count >0) {
				example.setStartPage(param.getOffset());
				example.setPageSize(param.getLimit());
				List<SellOrder> list = sellOrderMapper.selectByExample(example);
				page.setLimit(param.getLimit());
				page.setOffset(param.getOffset());
				page.setRows(list);
				page.setTotal(count);
			}
		} catch (Exception e) {
			log.error("findOrderPageList",e);
		}
		
		return page;
	}

	@Override
	public void changeOrderStateById(Long id) {
		SellOrder record=new SellOrder();
		record.setId(id);
		record.setOrderState(COMPLETE_DELIVERY_ORDER_STATE);
		sellOrderMapper.updateByPrimaryKeySelective(record);
	}
}
