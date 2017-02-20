package com.wqstore.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wqstore.domain.AdminResource;
import com.wqstore.result.RequestResultVo;
import com.wqstore.service.AdminResourceService;

@Controller
@RequestMapping("/admin/resource")
public class AdminResourceController {
	
	@Resource
	private AdminResourceService resourceService;
	
	@RequestMapping("/resourcePage")
	public String resourcePage(Model model, @RequestParam("title") String title) {
		model.addAttribute("title", title);
		return "auth/resource";
	}
	
	@RequestMapping("/queryResource")
	public @ResponseBody RequestResultVo<List<AdminResource>> queryResource() {
		RequestResultVo<List<AdminResource>> result = new RequestResultVo<List<AdminResource>>();
		List<AdminResource> list = resourceService.getResourceTree();
		result.setResult(list);
		return result;
	}
	
	@RequestMapping("/saveOrUpdate")
	public @ResponseBody RequestResultVo<AdminResource> saveOrUpdate(@ModelAttribute("resource") AdminResource resource) {
		RequestResultVo<AdminResource> result = new RequestResultVo<AdminResource>();
		if(resource != null) {
			if(resource.getId() != null) {
				result = resourceService.updateResource(resource);
			}else {
				result = resourceService.insertResource(resource);
			}
		}else {
			result.setSuccess(false);
			result.setErrorMessage("资源信息不能为空！");
		}
		return result;
	}
	
	@RequestMapping("/deleteResource")
	public @ResponseBody RequestResultVo<AdminResource> deleteResource(@RequestParam("id") Long id) {
		return resourceService.deleteResource(id);
	}
	
	@RequestMapping("/queryResourceById")
	public @ResponseBody RequestResultVo<AdminResource> queryResourceById(@RequestParam("id") Long id) {
		RequestResultVo<AdminResource> result = new RequestResultVo<AdminResource>();
		AdminResource resource = resourceService.findResourceById(id);
		result.setResult(resource);
		return result;
	}
	
	@RequestMapping("/queryRoleResource")
	public @ResponseBody RequestResultVo<Map<String, List<AdminResource>>> queryRoleResource(@RequestParam("id") Long id){
		RequestResultVo<Map<String, List<AdminResource>>> reuslt = new RequestResultVo<Map<String, List<AdminResource>>>();
		List<AdminResource> rList = resourceService.getResourceTreeByRoleId(id);
		List<AdminResource> nList = resourceService.getResourceTreeByNonRoleId(id);
		Map<String, List<AdminResource>> map = new HashMap<String, List<AdminResource>>();
		map.put("roleResource", rList);
		map.put("nonRoleResource", nList);
		reuslt.setResult(map);
		return reuslt;
	}
	
	@RequestMapping("/addRoleResource")
	public @ResponseBody RequestResultVo<AdminResource> addRoleResource(@RequestParam("resourceIds[]")List<Long> resourceIds, @RequestParam("roleId") Long roleId) {
		return resourceService.addRoleResource(resourceIds, roleId);
	}
	
	@RequestMapping("/deleteRoleResource")
	public @ResponseBody RequestResultVo<AdminResource> deleteRoleResource(@RequestParam("resourceIds[]")List<Long> resourceIds, @RequestParam("roleId") Long roleId) {
		return resourceService.deleteRoleResource(resourceIds,roleId);
	}
	
}