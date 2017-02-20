package com.wqstore.sys.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wqstore.domain.AdminRole;
import com.wqstore.domain.AdminUser;
import com.wqstore.result.PageParam;
import com.wqstore.result.RequestPageVo;
import com.wqstore.result.RequestResultVo;
import com.wqstore.service.AdminRoleService;
import com.wqstore.service.AdminUserService;


@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminUserController.class);

	@Resource
	private AdminUserService userService;
	
	@Resource
	private AdminRoleService roleService;
	
	@RequestMapping("/userPage")
	public String userPage(Model model,@RequestParam(value = "title", required = false) String title) {
		model.addAttribute("title", title);
		return "auth/user";
	}

	@RequestMapping("/queryUser")
	public @ResponseBody
	RequestPageVo<AdminUser> queryUser(
		@ModelAttribute(value = "param") PageParam param,
		@ModelAttribute(value = "user") AdminUser user){
		RequestPageVo<AdminUser> pageVo = userService.findUserPageList(user,param);
		return pageVo;
	}
	
	@RequestMapping("/saveOrUpdate")
	public @ResponseBody RequestResultVo<AdminUser> saveOrUpdate(@ModelAttribute("user") AdminUser user,
			HttpServletRequest request) {
		RequestResultVo<AdminUser> result = new RequestResultVo<AdminUser>();
		try {
			if(user != null) {
				if(user.getId() != null) {
					return userService.updateUser(user);
				}else {
					return userService.insertUser(user);
				}
			}else {
				result.setSuccess(false);
				result.setErrorMessage("用户信息不能为空！");
			}
		}catch(Exception e) {
			log.error("",e);
		}
		return result;
	}
	
	@RequestMapping("/deleteUser")
	public @ResponseBody RequestResultVo<AdminUser> deleteUser(@RequestParam("id") Long id) {
		return userService.deleteUser(id);
	}
	
	@RequestMapping("/userRolePage")
	public String userRolePage(@RequestParam("id") Long id, Model model) {
		model.addAttribute("id", id);
		List<AdminRole> rList = roleService.findRoleByUserId(id);
		List<AdminRole> nList = roleService.findRoleByNonUserId(id);
		model.addAttribute("rList",rList);
		model.addAttribute("nList", nList);
		return "auth/userRole";
	}
	
	@RequestMapping("/queryUserRole")
	public @ResponseBody RequestResultVo<Map<String, List<AdminRole>>> queryUserRole(@RequestParam("id") Long id) {
		RequestResultVo<Map<String, List<AdminRole>>> reuslt = new RequestResultVo<Map<String, List<AdminRole>>>();
		List<AdminRole> rList = roleService.findRoleByUserId(id);
		List<AdminRole> nList = roleService.findRoleByNonUserId(id);
		Map<String, List<AdminRole>> map = new HashMap<String, List<AdminRole>>();
		map.put("userRole", rList);
		map.put("nonUserRole", nList);
		reuslt.setResult(map);
		return reuslt;
	}
	
	@RequestMapping("/deleteUserRole")
	public @ResponseBody RequestResultVo<AdminRole> deleteUserRole(@RequestParam("roleIds[]") List<Long> roleIds, @RequestParam("userId") Long userId) {
		return userService.deleteUserRole(roleIds, userId);
	}
	
	@RequestMapping("/addUserRole")
	public @ResponseBody RequestResultVo<AdminRole> addUserRole(@RequestParam("roleIds[]") List<Long> roleIds, @RequestParam("userId") Long userId) {
		return userService.addUserRole(roleIds, userId);
	}
	
	@RequestMapping("/resetPassword")
	public @ResponseBody RequestResultVo<AdminUser> resetPassword(@RequestParam("id") Long id) {
		return userService.resetUserPassword(id);
	}
	
	@RequestMapping("/profile")
	public String profile(Model model,HttpServletRequest request) {
		String name = (String) request.getSession().getAttribute("username");
		AdminUser user = userService.findUserByLoginName(name);
		model.addAttribute("user", user);
		return "user/profile";
	}
	
	@RequestMapping("/updatePassword") 
	public @ResponseBody RequestResultVo<String> updatePassword(@RequestParam String oldPassword,
			@RequestParam String password,HttpServletRequest request) {
		String name = (String) request.getSession().getAttribute("username");
		return userService.updatePassword(name,oldPassword,password);
	}
	
}
