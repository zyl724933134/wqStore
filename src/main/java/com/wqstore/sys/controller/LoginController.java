package com.wqstore.sys.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wqstore.service.AdminUserService;



@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource
	private AdminUserService userService;
	
	@RequestMapping(value="/admin/login", method = RequestMethod.GET)
	public String login(@ModelAttribute("msg") String msg, Model model) {
		model.addAttribute("msg", msg);
		return "login";
	}
	
	@RequestMapping(value="/admin/login", method = RequestMethod.POST)
	public String login(@RequestParam("username")String username,@RequestParam("password")String password,
			Model model,HttpServletRequest request) {
		try {
			if(userService.checkUser(username, password)) {
				request.getSession().setAttribute("username", username);
				model.addAttribute("realName", username);
				return "redirect:/admin/home.do";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("login error!",e);
		}
		return "redirect:/admin/login.do";
	}
	
	@RequestMapping("/admin/logout")
	public String logout() {
		//SecurityUtil.logutToken();
		return "redirect:/admin/login.do";
	}
}
