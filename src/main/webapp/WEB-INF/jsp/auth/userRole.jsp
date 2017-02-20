<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tag.jsp"%>


<!-- 模态窗口 -->
<input type="hidden" id="userId" value="${id}"/>
<div class="row">
	<label class="control-label col-sm-5"> 已拥有的角色</label>
	<div class="col-sm-2"></div>
	<label class="control-label col-sm-5"> 未授予的角色</label>
</div>
<div class="row">
	<div class="col-sm-5" style="height: 400px">
		<select class="form-control list-group-item-info" id="userRoleList" multiple="multiple" style="height: 400px">
			<c:forEach items="${rList}" var="role">
				<option value="${role.id}">${role.name}</option>
			</c:forEach>
		</select>
	</div>
	<div class="col-sm-2" style="height: 400px" align="center">
			<div style="height: 120px"></div>
			<button type="button" class="btn btn-sm btn-primary" id="addSelectedData">
			  <span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span> 添加
			</button>
			<div style="height: 20px"></div>
			<button type="button" class="btn btn-sm btn-danger" id="deleteSelectedData">
			  删除 <span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
			</button>
	</div>
	<div class="col-sm-5" style="height: 400px">
		<select class="form-control list-group-item-info" id="nonUserRoleList" multiple="multiple" style="height: 400px">	
			<c:forEach items="${nList}" var="role">
				<option value="${role.id}">${role.name}</option>
			</c:forEach>
		</select>
	</div>
</div>
<script type="text/javascript">
$(function(){
	//queryRole();
	
	//给用户添加角色
	$("#addSelectedData").on('click', function(){
		var user_id = $("#userId").val();
		var role_ids = new Array();
		$("#nonUserRoleList option:selected").each(function(i, value){
			role_ids[i] = $(value).val();
		});
		if(role_ids.length != 0){
			$.ajax({
				url: "${ctx}/admin/user/addUserRole.do",
				type: "POST",
		        data: {
		            "roleIds": role_ids,
		            "userId": user_id
		        }, 
		        success: function (data){
		        	if(data.success==true){
		        		queryRole();
		        	}else {
		        		alert(data.errorMessage);
		        	}
		        }
			});
		}else {
			alert("请选择操作数据！");
		}
	});
	
	//删除用户的角色
	$("#deleteSelectedData").on('click', function(){
		var user_id = $("#userId").val();
		var role_ids = new Array();
		$("#userRoleList option:selected").each(function(i, value){
			role_ids[i] = $(value).val();
		});
		if(role_ids.length != 0){
			$.ajax({
				url: "${ctx}/admin/user/deleteUserRole.do",
				type: "POST",
		        data: {
		            "roleIds": role_ids,
		            "userId": user_id
		        }, 
		        success: function (data){
		        	if(data.success==true){
		        		queryRole();
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

//查询用户拥有和非拥有的角色
function queryRole(){
	var id = $("#userId").val();
	$.ajax({
		url: "${ctx}/admin/user/queryUserRole.do",
        type: "POST",
        data: {
            "id": id
        }, 
        success: function (data) {
        	if(data.success==true){
       			$("#userRoleList").empty();
        		$.each(data.result.userRole,function(i,role){
        			$("<option value='"+role.id+"'>"+role.name+"</option>").appendTo("#userRoleList");
        		});
       			$("#nonUserRoleList").empty();
        		$.each(data.result.nonUserRole,function(i,role){
        			$("<option value='"+role.id+"'>"+role.name+"</option>").appendTo("#nonUserRoleList");
        		});
            }else {
                alert(data.errorMessage);
            }
        }
	});
}

</script>