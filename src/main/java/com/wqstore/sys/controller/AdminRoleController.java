package com.wqstore.sys.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wqstore.domain.AdminRole;
import com.wqstore.result.PageParam;
import com.wqstore.result.RequestPageVo;
import com.wqstore.result.RequestResultVo;
import com.wqstore.service.AdminRoleService;

@Controller
@RequestMapping("/admin/role")
public class AdminRoleController {

	@Resource
	private AdminRoleService roleService;
	
	/**
	 * @param model
	 * @param title
	 * @return
	 */
	@RequestMapping("/rolePage")
	public String rolePage(Model model,@RequestParam("title") String title) {
		model.addAttribute("title", title);
		return "auth/role";
	}
	
	@RequestMapping("/queryRole")
	public @ResponseBody RequestPageVo<AdminRole> queryRole(
			@ModelAttribute("param") PageParam param,
			@ModelAttribute("role") AdminRole role) {
		return roleService.findRolePageList(role,param);
	}
	
	@RequestMapping("/saveOrUpdate")
	public @ResponseBody RequestResultVo<AdminRole> saveOrUpdate(@ModelAttribute("role") AdminRole role) {
		RequestResultVo<AdminRole> result = new RequestResultVo<AdminRole>();
		if(role != null) {
			if(role.getId() != null) {
				result = roleService.updateRole(role);
			}else{
				result = roleService.insertRole(role);
			}
		}else {
			result.setSuccess(false);
			result.setErrorMessage("角色信息不能为空！");
		}
		return result;
	}
	
	@RequestMapping("/deleteRole")
	public @ResponseBody RequestResultVo<AdminRole> deleteRole(@RequestParam("id") Long id){
		return roleService.deleteRole(id);
	}
	
	@RequestMapping("/roleResourcePage")
	public String roleResourcePage(@RequestParam("id") Long id, Model model) {
		model.addAttribute("id", id);
		return "auth/roleResource";
	}
}
