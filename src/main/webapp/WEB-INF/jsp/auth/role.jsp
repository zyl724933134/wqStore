<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tag.jsp"%>
<%@ include file="/WEB-INF/include/common.jsp"%>

<link rel="stylesheet" href="${ctx}/statics/css/custom_theme.css" />

<!-- 模态窗口 -->
<div class="modal fade" id="roleModel" tabindex="-1" role="dialog" aria-labelledby="roleModelLabel" aria-hidden="true" data-backdrop="false">
  <div class="modal-dialog" >
        <div class="modal-content">
            <div class="modal-header">
            	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
                	<span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" ></h4>
            </div>
            <div class="modal-body" >
            	<form id="role_edit_form" class="form-horizontal">
			        <input type="hidden" id="role_id" name="id">
			        <div class="form-group">
			        	<label class="control-label col-sm-3"> 角色名称：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="role_name" name="name" >
			        	</div>
			        </div>
			        <div class="form-group">
			        	<label class="control-label col-sm-3">角色编码：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="role_code" name="code" >
			        	</div>
			        </div>
			        <div class="form-group">
			        	<label class="control-label col-sm-3"> 角色描述：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="role_description" name="description" >
			        	</div>
			        </div>
			    </form>
            </div>
            <div class="modal-footer">
            	<button type="button" class="btn btn-sm btn-primary" id="roleModelBtn">确定</button>
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
				<div class="panel-body">
					<form class="form-horizontal" role="form" id="role_search_form">
						<div class="form-group">
							<label class="col-sm-1 control-label">名称：</label>
							<div class="col-sm-2">
								<input id="search_name" name="name" type="text" laceholder="姓名"/> 
							</div>
							<label class="col-sm-1 control-label">编码： </label>
							<div class="col-sm-2">
								<input id="search_code" name="code" type="text" laceholder="账户"/> 
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
					
					<div id="role_table_tools">
						<div class="text-right" >
							<button type="button" class="btn btn-success btn-sm" onclick="addData()">添加角色</button>
						</div>
					</div> <!-- /.role_table_tools -->
					<table id="role_table" class="table table-bordered table-hover">
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="roleResourceModel" tabindex="-1" role="dialog" aria-labelledby="roleResourceModelLabel" aria-hidden="true" data-backdrop="false">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                	<span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="roleResourceModelLabel">${subTitle}</h4>
            </div>
            <div class="modal-body">
        		<div id="roleResourceModel_modal_body"></div>
            </div>
        </div>
         
    </div>
</div>

<script type="text/javascript">
var role_table; 
$(function () {
	$('#role_table').bootstrapTable({
		url: '${ctx}/admin/role/queryRole.do',
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
			width: 80
		},{
			field: 'code',
			title: '编码',
			width: 100
		},{
			field: 'name',
			title: '角色名',
			width: 100
		},{
			field: 'creator',
			title: '创建人',
			width: 100
		},{
			field: 'createTime',
			title: '创建时间',
			width: 150
		},{
			field: 'modifier',
			title: '修改人',
			width: 100
		},{
			field: 'modifiedTime',
			title: '修改时间',
			width: 150,
		},{
			field: 'description',
			title: '描述',
			width: 200
		},{
			field: '',
			title: '操作',
			width: 150,
			formatter: function(value, row, index){
				return '<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">'
						+'<button class="btn btn-xs btn-success" id="setReourceLink" title="分配权限"><i class="icon-external-link bigger-130"></i></button>'
						+'<button class="btn btn-xs btn-info" id="editData" title="编辑"><i class="icon-edit bigger-130"></i></button>'
						+'<button class="btn btn-xs btn-danger" id="deleteData" title="删除"><i class="icon-trash bigger-130"></i></button></div>';
			
			},
			events: {
				'click #editData': editData,
				'click #deleteData': deleteData,
				'click #setReourceLink': setReourceLink
			}
			
		}],
		queryParams: function(params){
			$.extend(params,$("#user_search_form").serializeJson())
			return params;
		}
		
	});
	
	
	//提交用户信息
	$("#roleModel").on('click','#roleModelBtn',function(){
		$("#role_edit_form").submit();
	});
	
	//添加和编辑请求验证
	$("#role_edit_form").validate({
		rules: {
			code:{required:true},
			name:{required:true,maxlength:30},
		},
		messages : {
			code:{required:"必填"},
			name:{required:"必填",maxlength:"最大长度30"},
		},
		submitHandler: function(form) {
			$("#roleModel").prop("disabled",true);
    		$(form).ajaxSubmit({
    			type:"post",
    			dataType:"json",
    			url:"${ctx}/admin/role/saveOrUpdate.do",
    			success:function(data){
    				if(data.success==true){
    					$('#roleModel').modal('hide') 
    					$('#role_table').bootstrapTable('refresh');
    				}else{
    					alert(data.errorMessage);
    				}
    				$("#roleModel").prop("disabled",false);
                }  
            });
		}
	});
	
	
	//搜索角色
	$("#role_search_form").submit(function(e){
		e.preventDefault();
		$('#role_table').bootstrapTable('refresh');
	});
	
});


//添加角色
function addData() {
	$("#roleModel .modal-title").empty().html("添加角色");
	$("#role_edit_form").resetForm();
	$("#role_edit_form input[name=id]").val("");
	$("#role_edit_form input[name=code]").removeAttr("disabled");
	$("#roleModel").modal("show");
}

function editData(e, v, row) {
	if(row){ 
		$("#roleModel .modal-title").empty().html("修改角色");
		$("#role_edit_form").resetForm();
		$("#role_edit_form input[name=id]").val(row.id);
		$("#role_edit_form input[name=code]").val(row.code);
		$("#role_edit_form input[name=code]").attr("disabled","disabled");
		$("#role_edit_form input[name=name]").val([row.name]);
		$("#role_edit_form input[name=description]").val([row.description]);
		$('#roleModel').modal('show');
	}else {
		alert("请选择操作数据！");
	}
}

function deleteData(e, v, row) {
	var r = confirm("你确定删除角色“"+row.name+"”吗？");
	if(r){
		$.ajax({
            url: "${ctx}/admin/role/deleteRole.do",
            type: "POST",
            data: {
                "id": row.id
            }, 
            success: function (data) {
            	if(data.success==true){
            		$('#role_table').bootstrapTable('refresh');
                }else {
	                alert(data.errorMessage);
                }
            }
   		});
	}
}

//授予权限
function setReourceLink(e, v, row) {
	var title = "给角色“"+row.name+"”授予权限";
	sysToModal("${ctx}/admin/role/roleResourcePage.do?id="+row.id,"roleResourceModel",title);
}
</script>
