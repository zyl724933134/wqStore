<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tag.jsp"%>
<%@ include file="/WEB-INF/include/common.jsp"%>

<link rel="stylesheet" href="${ctx}/statics/css/custom_theme.css" />

<div class="modal fade" id="userRoleModel" tabindex="-1" role="dialog" aria-labelledby="userRoleModelLabel" aria-hidden="true" data-backdrop="false">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                	<span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="userRoleModelLabel">${subTitle}</h4>
            </div>
            <div class="modal-body">
        		<div id="userRoleModel_modal_body"></div>
            </div>
        </div>
         
    </div>
</div>

<!-- 模态窗口 -->
<div class="modal fade" id="userModel" tabindex="-1" role="dialog" aria-labelledby="userModelLabel" aria-hidden="true" data-backdrop="false">
  <div class="modal-dialog" >
        <div class="modal-content">
            <div class="modal-header">
            	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
                	<span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" >添加账户</h4>
            </div>
            <div class="modal-body">
            	<form id="user_edit_form" class="form-horizontal">
			        <input type="hidden" id="user_id" name="id">
			        <div class="form-group">
			        	<label class="control-label col-sm-3">账号：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="login_name" name="loginName" >
			        	</div>
		        	</div>
		        	<div class="form-group">
			        	<label class="control-label col-sm-3">姓名：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="real_name" name="realName" >
			        	</div>
			        </div>
			        <div class="form-group" id="password_block">
			        	<label class="control-label col-sm-3"> 初始密码：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="password" name="password" readonly="readonly" value="123456">
			        	</div>
			        </div>
			        <div class="form-group">
			        	<label class="control-label col-sm-3"> 可用状态：</label>
			        	<div class="col-sm-8">
			        	<label class="radio-inline">
		            		<input type="radio" name="status"  value="1" checked="checked">可用
			            </label>
			            <label class="radio-inline">
			            	<input type="radio" name="status"  value="0" >不可用
			            </label>
			            </div>
			        </div>
			        <div class="form-group">
			        	<label class="control-label col-sm-3"> 系统管理员：</label>
			        	<div class="col-sm-8">
			        	<label class="radio-inline">
		            		<input type="radio" name="isAdmin"  value="true" >是
			            </label>
			            <label class="radio-inline">
			            	<input type="radio" name="isAdmin"  value="false" checked="checked">否
			            </label>
			            </div>
			        </div>
			    </form>
            </div>
            <div class="modal-footer">
            	<button type="button" class="btn btn-sm btn-primary" id="userModelBtn">确定</button>
                <button type="button" class="btn btn-sm btn-default" data-dismiss="modal" id="Close">关闭</button>
            </div>
        </div>
   </div>
</div>

<div id="main-content">

	<div class="row" >
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">${title}</div>
				<!-- /.panel-heading -->
				<div class="panel-body" >
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->

							<form class="form-horizontal" role="form" id="user_search_form">
								<div class="form-group">
									<label class="col-sm-1 control-label"> 姓名 </label>
									<div class="col-sm-2">
										<input id="search_realName" name="realName" type="text" laceholder="姓名"/> 
									</div>
									<label class="col-sm-1 control-label"> 账户 </label>
									<div class="col-sm-2">
										<input id="search_loginName" name="loginName" type="text" laceholder="账户"/> 
									</div>
									
									<label class="control-label col-sm-1">状态 </label>
									<div class="col-sm-2">
										<select	name="status" id="search_status">
											<option value="">全部</option>
											<option value="1">可用</option>
											<option value="0">不可用</option>
										</select>
									</div>
									<div class="col-sm-1">
										<button class="btn btn-sm btn-info" type="submit">
											<i class="icon-search nav-search-icon"></i>
											查询
										</button> 
									</div>
									<div class="col-sm-1">
										<button class="btn btn-sm btn-primary" type="reset"	>
											<i class="icon-undo bigger-110"></i>
											清除
										</button> 
									</div>
								</div>
							</form>
						</div>
					</div>
					<div id="user_table_tools">
						<div class="text-right">
							<button type="button" class="btn btn-success btn-sm" onclick="addData()">开通账号</button>
						</div>
					</div>
					<table id="user_table" class="table table-bordered table-hover">
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
$(function(){
	$('#user_table').bootstrapTable({
		url: '${ctx}/admin/user/queryUser.do',
		pagination: true,
		paginationLoop: false,
		smartDisplay: false,
		striped: true,
	    pageSize: 10,
	    pageList: [10, 20, 50, 100],
	    sidePagination: 'server',
	    showRefresh: false,
	    showColumns: false,
	    paginationNextText:'下一页',
	    paginationPreText:'上一页',
	    cache: false,
		columns: [{
			field: 'id',
			title: 'ID',
			width: 50
		},{
			field: 'loginName',
			title: '账户',
			width: 100
		},{
			field: 'realName',
			title: '姓名',
			width: 100
		},{
			field: 'roles',
			title: '角色',
			width: 180,
			formatter : function(val, row, index) {
				var roles = val.join("，");
			  	if(val.length > 3) {
			  		return "<a class='pannel_a_title' tabindex='0' role='button' data-toggle='popover' data-trigger='hover' data-placement='bottom' title='角色' data-content='"+roles+"'>"+val[0]+"，"+val[1]+"，"+val[2]+"...</a>";
			  	}
			  	return val;
			}
		},{
			field: 'isAdmin',
			title: '管理员',
			width: 50,
			formatter: function(val, row, index){
				return val == 1 ? '是' : '否';
			}
		},{
			field: 'createTime',
			title: '创建时间',
			width: 150
		},{
			field: 'creator',
			title: '创建者',
			width: 100,
		},{
			field: 'status',
			title: '状态',
			width: 50,
			formatter: function(val, row, index){
				return val == 1 ? '可用' : '不可用';
			}
		},{
			field: '',
			title: '操作',
			align: 'center',
			width: 150,
			formatter: function(value, row, index){
				return '<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">'
						+'<button class="btn btn-xs btn-success" id="setRoleLink" title="分配角色"><i class="icon-group bigger-130"></i></button>'
						+'<button class="btn btn-xs btn-info" id="editData" title="编辑"><i class="icon-edit bigger-130"></i></button>'
						+'<button class="btn btn-xs btn-danger" id="deleteData" title="删除"><i class="icon-trash bigger-130"></i></button>'
						+'<button class="btn btn-xs btn-warning " id="resetPassword" title="重置密码"><i class="icon-refresh bigger-130"></i></button></div>';
						
			
			},
			events: {
				'click #editData': editData,
				'click #deleteData': deleteData,
				'click #setRoleLink': setRoleLink,
				'click #resetPassword': resetPassword
			}
			
		}],
		queryParams: function(params){
			//console.log(params);
			//params.usreId
			$.extend(params,$("#user_search_form").serializeJson())
			return params;
		}
		
		
	});

	$('#user_table').on('mouseenter','.pannel_a_title',function () {
        $(this).popover('show');
	});
	
	//添加和编辑请求验证
	$("#user_edit_form").validate({
		rules: {
			loginName:{required:true,maxlength:30},
			realName:{required:true,maxlength:30},
		},
		messages : {
			loginName:{required:"必填",maxlength:"最大长度30"},
			realName:{required:"必填",maxlength:"最大长度30"},
		},
		submitHandler: function(form) {
			$("#userModel").prop("disabled",true);
    		$(form).ajaxSubmit({
    			type:"post",
    			dataType:"json",
    			url:"${ctx}/admin/user/saveOrUpdate.do",
    			success:function(data){
    				if(data.success==true){
    					$('#userModel').modal('hide') 
    					$('#user_table').bootstrapTable('refresh');
    				}else{
    					alert(data.errorMessage);
    				}
    				$("#userModel").prop("disabled",false);
                }  
            });
		}
	});
	
	//提交用户信息
	$("#userModel").on('click','#userModelBtn',function(){
		$("#user_edit_form").submit();
	});
	
	//搜索角色
	$("#user_search_form").submit(function(e){
		e.preventDefault();
		$('#user_table').bootstrapTable('refresh');
	});
	
});

function addData(e, v, row) {
	$("#user_edit_form").resetForm();
	$("#user_edit_form input[name=id]").val("");
	$("#user_edit_form input[name=loginName]").removeAttr("disabled");
	$("#password_block").show();
	$('#userModel').modal('show');
}

//编辑用户
function editData(e, v, row) {
	$("#userModel .modal-title").empty().html("修改用户");
	$("#user_edit_form").resetForm();
	$("#user_edit_form input[name=id]").val(row.id);
	$("#password_block").hide();
	$("#user_edit_form input[name=realName]").val(row.realName);
	$("#user_edit_form input[name=loginName]").val(row.loginName);
	$("#user_edit_form input[name=loginName]").attr("disabled","disabled");
	$("#user_edit_form input[name=isAdmin]").val([row.isAdmin]);
	$("#user_edit_form input[name=status]").val([row.status]);
	$('#userModel').modal('show');
}

//删除用户
function deleteData(e, v, row) {
	
	var r = confirm("你确定删除账户“"+row.loginName+"”吗？");
	if(r){
		$.ajax({
         url: "${ctx}/admin/user/deleteUser.do",
         type: "POST",
         data: {
             "id": row.id
         }, 
         success: function (data) {
         	if(data.success){
         		$('#user_table').bootstrapTable('refresh');
             }else {
             	alert(data.errorMessage);
             }
         }
   		});
	}
	
}

//授予用户角色
function setRoleLink(e, v, row) {
	if(row){
		var title = "给账户“"+row.loginName+"”授予角色";
		sysToModal("${ctx}/admin/user/userRolePage.do?id="+row.id,"userRoleModel",title);
	}
}

//重置密码
function resetPassword(e, v, row) {
	var r = confirm("确定重置“"+row.loginName+"”密码吗？");
	if(r) {
		$.ajax({
			url : "${ctx}/admin/user/resetPassword.do",
			type : "POST",
			data : {"id" : row.id},
			success: function (data) {
				if(data.success) {
					alert("密码初始化完成！");
				}else {
					alert(data.errorMessage);
				}				
			}
			
		});
	}
}

</script>