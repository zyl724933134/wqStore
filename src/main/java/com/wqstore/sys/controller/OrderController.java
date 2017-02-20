package com.wqstore.sys.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wqstore.domain.EndUser;
import com.wqstore.domain.SellOrder;
import com.wqstore.domain.SellOrderItem;
import com.wqstore.result.PageParam;
import com.wqstore.result.RequestPageVo;
import com.wqstore.result.RequestResultVo;
import com.wqstore.service.EndUserService;
import com.wqstore.service.OrderService;

@Controller
@RequestMapping("/admin/order")
public class OrderController {
	
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@Resource
	private OrderService orderService;
	
	@Resource
	private EndUserService endUserService;

	@RequestMapping("/orderPage.do")
	public String orderPage(Model model,@RequestParam(value = "title", required = false) String title) {
		model.addAttribute("title", title);
		return "/order/orderPage";
	}
	
	@RequestMapping("/queryOrder.do")
	public @ResponseBody RequestPageVo<SellOrder> queryOrder(
			@ModelAttribute(value = "param") PageParam param,
			@ModelAttribute SellOrder sellOrder,
			@RequestParam("startTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
			@RequestParam("endTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
		return orderService.findOrderPageList(param,sellOrder,startTime, endTime);
	}
	
	@RequestMapping("/deleteOrderById.do")
	public @ResponseBody RequestResultVo<String> deleteOrderById(Long id) {
		RequestResultVo<String> result = new RequestResultVo<String>();
		try {
			orderService.deleteOrderById(id);
		} catch (Exception e) {
			log.error("deleteOrderById",e);
			result.setSuccess(false);
			result.setErrorMessage("删除订单异常！");
		}
		return result;
	}
	
	@RequestMapping("/orderDetailPage.do")
	public String orderDetailPage(Model model, @RequestParam(value = "title", required = false) String title, Long id) {
		
		SellOrder order = orderService.findOrderDetailById(id);
		//List<SellOrderItem> items = orderService.findOrderItemsByOrderId(id);
//		SellOrderInvoice invoice = orderService.findOrderInvoiceByOrderId(id);
		EndUser endUser = endUserService.findEndUserById(id);
		
		model.addAttribute("endUser",endUser);
		//model.addAttribute("items",items);
		model.addAttribute("order", order);
//		model.addAttribute("invoice", invoice);
		model.addAttribute("title", title);
		return "/order/orderDetailPage";
	}
	
	
	@RequestMapping("/getOrderDetail.do")
	public @ResponseBody RequestPageVo<SellOrder> getOrderDetail(Long id) {
		RequestPageVo<SellOrder> page = new RequestPageVo<SellOrder>();
		List<SellOrder> list = new ArrayList<SellOrder>();
		SellOrder order = orderService.findOrderDetailById(id);
		list.add(order);
		page.setRows(list);
		return page;
	}
	
	@RequestMapping("/getOrderItems.do")
	public @ResponseBody RequestPageVo<SellOrderItem> getOrderItems(Long id) {
		RequestPageVo<SellOrderItem> page = new RequestPageVo<SellOrderItem>();
		List<SellOrderItem> list = orderService.findOrderItemsByOrderId(id);
		page.setRows(list);
		return page;
	}
	
	@RequestMapping("/getOrderInvoice.do")
	public @ResponseBody RequestPageVo<SellOrder> getOrderInvoice(Long id) {
		RequestPageVo<SellOrder> page = new RequestPageVo<SellOrder>();
		List<SellOrder> list = new ArrayList<SellOrder>();
		SellOrder order = orderService.findOrderDetailById(id);
		
		list.add(order);
		page.setRows(list);
		return page;
	}
	
	@RequestMapping("/updateOrderById.do")
	public @ResponseBody RequestResultVo<SellOrder> updateOrderById(@ModelAttribute SellOrder sellOrder) {
		RequestResultVo<SellOrder> result = new RequestResultVo<SellOrder>();
		try {
			result = orderService.updateOrderById(sellOrder);
		} catch (Exception e) {
			log.error("updateOrderById" ,e);
			result.setSuccess(false);
			result.setErrorMessage("订单更新异常！");
		}
		return result;
	}
	
	@RequestMapping("/updateItemByOrderId.do")
	public @ResponseBody RequestResultVo<SellOrder> updateItemByOrderId(@ModelAttribute SellOrder sellOrder) {
		RequestResultVo<SellOrder> result = new RequestResultVo<SellOrder>();
		try {
			result = orderService.updateOrderItemByOrderId(sellOrder);
		} catch (Exception e) {
			log.error("updateOrderById" ,e);
			result.setSuccess(false);
			result.setErrorMessage("订单更新异常！");
		}
		return result;
	}
	
	@RequestMapping("/updateOrderPaymentType.do")
	public @ResponseBody RequestResultVo<String> updateOrderPaymentType(@ModelAttribute SellOrder order) {
		RequestResultVo<String> result = new RequestResultVo<String>();
		
		try {
			result = orderService.updateOrderPaymentType(order);
		} catch (Exception e) {
			log.error("updateOrderPaymentType",e);
			result.setSuccess(false);
			result.setErrorMessage("确认订单收款异常！");
		}
		return result;
	}
	 //跳转到待发货页面
    @RequestMapping("/WaiteDeliveryPage.do")
	public String WaiteDeliveryPage(Model model,@RequestParam(value = "title", required = false) String title) {
		model.addAttribute("title", title);
		return "/order/WaiteDeliveryPage";
	}
    
  //查找待发货详情
    @RequestMapping("/WaiteDeliveryDetaile.do")
	public @ResponseBody RequestPageVo<SellOrder> WaiteDeliveryDetaile(
			@ModelAttribute(value = "param") PageParam param,
			@ModelAttribute SellOrder sellOrder) {
		return orderService.findWaiteDeliveryDetaileList(param,sellOrder);
	}
    //更新订单状态
    @RequestMapping("/changeOrderState.do")
	public @ResponseBody RequestResultVo<String>  changeOrderStateById(Long id ) {
    	RequestResultVo<String> result = new RequestResultVo<String>();
		try {
			orderService.changeOrderStateById(id);
		} catch (Exception e) {
			log.error("deleteOrderById",e);
			result.setSuccess(false);
			result.setErrorMessage("修改发货订单状态异常！");
		}
		return result;
	}
}
