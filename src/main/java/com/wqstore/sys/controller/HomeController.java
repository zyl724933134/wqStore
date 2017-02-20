package com.wqstore.sys.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wqstore.domain.AdminResource;
import com.wqstore.domain.AdminUser;
import com.wqstore.result.RequestResultVo;
import com.wqstore.service.AdminResourceService;
import com.wqstore.service.AdminUserService;

@Controller
@RequestMapping("/admin/home")
public class HomeController {
	
	@Resource
	public AdminResourceService adminResourceService;
	@Resource
	public AdminUserService adminUserService;
	@RequestMapping("")
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView m = new ModelAndView();
		m.setViewName("home");
		String name = (String) request.getSession().getAttribute("username");
		m.addObject("realName", name);
		return m;
	}
	
	@RequestMapping("/loadMenu")
	public @ResponseBody RequestResultVo<List<AdminResource>> loadMenu(@RequestParam("name") String name,HttpServletRequest request) {
		RequestResultVo<List<AdminResource>> result = new RequestResultVo<List<AdminResource>>();
		String username = (String) request.getSession().getAttribute("username");
		AdminUser user = adminUserService.findUserByLoginName(username);
		List<AdminResource> list = adminResourceService.getMenuTree(user.getId(), name, user.getIsAdmin());
		
		result.setResult(list);
		return result;
	}
	
}
