package com.wqstore.service;

import java.util.Date;
import java.util.List;

import com.wqstore.domain.SellOrder;
import com.wqstore.domain.SellOrderItem;
import com.wqstore.result.PageParam;
import com.wqstore.result.RequestPageVo;
import com.wqstore.result.RequestResultVo;

public interface OrderService {

	/**
	 * 查询订单列表
	 * @param param
	 * @param sellOrder
	 * @param endTime 
	 * @param startTime 
	 * @return
	 */
	public RequestPageVo<SellOrder> findOrderPageList(PageParam param, SellOrder sellOrder, Date startTime, Date endTime);

	/**
	 * 根据id删除订单
	 * @param id
	 * @return
	 */
	public RequestResultVo<String> deleteOrderById(Long id);

	/**
	 * 根据id获取订单
	 * @param id
	 * @return
	 */
	public SellOrder findOrderDetailById(Long id);

	/**
	 * 根据订单id获取商品列表
	 * @param id
	 * @return
	 */
	public List<SellOrderItem> findOrderItemsByOrderId(Long id);


	/**
	 * 更新订单
	 * @param sellOrder
	 * @return
	 */
	public RequestResultVo<SellOrder> updateOrderById(SellOrder sellOrder);

	/**
	 * 更新订单和商品价格
	 * @param sellOrder
	 * @return
	 */
	public RequestResultVo<SellOrder> updateOrderItemByOrderId(SellOrder sellOrder);


	/**
	 * 确认订单收款
	 * @param order
	 * @return
	 */
	public RequestResultVo<String> updateOrderPaymentType(SellOrder order);
	/**
	 * 查找待发货订单
	 * @param order
	 * @return
	 */
	public RequestPageVo<SellOrder> findWaiteDeliveryDetaileList(
			PageParam param, SellOrder sellOrder);
	/**
	 * 更新发货状态为已发货
	 * @param id
	 * @return
	 */
	public void changeOrderStateById(Long id);
	 
}
