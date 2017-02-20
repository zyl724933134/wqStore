<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tag.jsp"%>
<link href="${ctx}/statics/css/tree.css" rel="stylesheet" type="text/css">

<!-- 模态窗口 -->
<input type="hidden" id="roleId" value="${id}"/>
<div class="row">
	<label class="control-label col-sm-5"> 已拥有的权限</label>
	<div class="col-sm-2"></div>
	<label class="control-label col-sm-5"> 未授予的权限</label>
</div>
<div class="row">
	<div class="col-sm-5">
		<div class="tree well" id="roleResourceRoot" ></div>
	</div>
	<div class="col-sm-2" align="center">
			<div style="height: 120px"></div>
			<button type="button" class="btn btn-sm btn-primary" id="addSelectedData">
			  <span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span> 添加
			</button>
			<div style="height: 20px"></div>
			<button type="button" class="btn btn-sm btn-danger" id="deleteSelectData">
			  删除 <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
			</button>
	</div>
	<div class="col-sm-5" >
		<div class="tree well" id="nonRoleResourceRoot"></div>
	</div>
</div>
<script type="text/javascript">
$(function(){
	queryResource();
	
	//删除用户的资源
	$("#deleteSelectData").on('click', function(){
		var roleId = $("#roleId").val();
		var resource_ids = new Array();
		$("#roleResourceRoot input[name=code]:checked").each(function() {
			resource_ids.push(this.value);
		});
		
		if(resource_ids.length != 0){
			$.ajax({
				url: '${ctx}/admin/resource/deleteRoleResource.do',
				type: 'POST',
				dataType: 'JSON',
				data: {resourceIds: resource_ids,roleId: roleId},
				success: function(data) {
					if(data.success==true) {
						queryResource();
					}else {
						alert(data.errorMessage);
					}
				}
			});
		}else {
			alert("请选择操作数据！");
		}
	});
	
	//给用户添加资源
	$("#addSelectedData").on('click', function(){
		var roleId = $("#roleId").val();
		var resource_ids = new Array();
		
		$("#nonRoleResourceRoot input[name=code]:checked").each(function() {
			resource_ids.push(this.value);
		});
		if(resource_ids.length != 0){
			$.ajax({
				url: '${ctx}/admin/resource/addRoleResource.do',
				type: 'POST',
				dataType: 'JSON',
				data: {resourceIds: resource_ids,roleId: roleId},
				success: function(data) {
					if(data.success==true) {
						queryResource();
					}else {
						alert(data.errorMessage);
					}
				}
			});
		}else {
			alert("请选择操作数据！");
		}
		
	});
	
});

//查询角色拥有和非拥有的资源
function queryResource(){
	var id = $("#roleId").val();
	$.ajax({
		url: "${ctx}/admin/resource/queryRoleResource.do",
        type: "POST",
        data: {
            "id": id
        }, 
        success: function (data) {
        	if(data.success==true){
        		var treeHtml = loadTree(data.result.roleResource);
        		$("#roleResourceRoot").empty().append(treeHtml);
        		treeHtml = loadTree(data.result.nonRoleResource);
        		$("#nonRoleResourceRoot").empty().append(treeHtml);
            }else {
                alert(data.errorMessage);
            }
        }
	});
}


//加载tree
function loadTree(result) {
	var html="";
	if(result&&result.length>0){
		html+="<ul>";
		$.each(result, function (n, node) {  
		var nodeHtml="<li><input type='checkbox' name='code' value='"+node.id+"'><span>"+node.name+"</span>";
		    nodeHtml+=loadTree(node.children);
		    nodeHtml+="</li>";
		    html+=nodeHtml;
     		});  
     	html+="</ul>";
	}
	return html;
}
</script>