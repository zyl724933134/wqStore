package com.wqstore.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wqstore.domain.Address;
import com.wqstore.domain.EndUser;
import com.wqstore.result.PageParam;
import com.wqstore.result.RequestPageVo;
import com.wqstore.result.RequestResultVo;
import com.wqstore.service.EndUserService;

@Controller
@RequestMapping("/admin/endUser")
public class EndUserController {

	
	@Autowired
	private EndUserService endUserService;
	
	/**
	 * 到用户列表页
	 */
	@RequestMapping("endUserPage")
	public String toEndUserPage(Model model,@RequestParam(value="title",required = false)String title){
		model.addAttribute("title", title);
		return "mall/endUser";
	}
	
	/**
	 * 分页查询商城用户列表
	 * @return
	 */
	@RequestMapping("/queryEndUserList")
	public @ResponseBody RequestPageVo<EndUser> queryEndUserList(@ModelAttribute(value = "param") PageParam param,
			@ModelAttribute(value = "endUser")EndUser endUser){
		RequestPageVo<EndUser> pageVo = endUserService.findEndUserList(endUser,param);
		return pageVo;
	}
	
	/**
	 * 获取用户的收货地址
	 * @param endUserAddressId
	 * @return
	 */
	@RequestMapping("/getEndUserAddress")
	public @ResponseBody RequestResultVo<List<Address>> getEndUserAddress(@RequestParam(value="endUserId")Long endUserId){
		return endUserService.getEndUserAddress(endUserId);
	}
}
