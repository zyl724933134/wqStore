<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tag.jsp"%>
<%@ include file="/WEB-INF/include/common.jsp"%>

<link rel="stylesheet" href="${ctx}/statics/css/custom_theme.css" />
<link href="${ctx}/statics/css/tree.css" rel="stylesheet" type="text/css">
<script src="${ctx}/statics/js/icons.js"></script>


<!-- 模态窗口 -->
<div class="modal fade" id="resourceModel" tabindex="-1" resource="dialog" aria-labelledby="resourceModelLabel" aria-hidden="true" data-backdrop="false">
  <div class="modal-dialog" >
        <div class="modal-content">
            <div class="modal-header">
            	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
                	<span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" ></h4>
            </div>
            <div class="modal-body">
            	<form id="resource_edit_form" class="form-horizontal">
			        <input type="hidden" id="resource_id" name="id">
			        <div class="form-group">
			        	<label class="control-label col-sm-3"> 名称：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="resource_name" name="name" >
			        	</div>
			        </div>
			        <div class="form-group">
			        	<label class="control-label col-sm-3"> 请求地址：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="resource_url" name="url" >
			        	</div>
			        </div>
			        <div class="form-group">
			        	<label class="control-label col-sm-3"> 生成菜单：</label>
			        	<div class="col-sm-8">
				        	<label class="radio-inline">
			            		<input type="radio" name="isMenu"  value="true" checked="checked">是
				            </label>
				            <label class="radio-inline">
				            	<input type="radio" name="isMenu"  value="false">否
				            </label>
				        </div>
			        </div>
			        <div class="form-group">
			        	<label class="control-label col-sm-3"> 编码：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="resource_code" name="code" >
			        	</div>
			        </div>
			        <div class="form-group">
			        	<label class="control-label col-sm-3"> 优先级：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="resource_weight" name="weight" >
			        	</div>
			        </div>
			        <div class="form-group">
			        	<label class="control-label col-sm-3"> 父编码：</label>
			        	<div class="col-sm-8">
				            <select class="form-control" id="resource_parentCode" name="parentCode"></select>
			        	</div>
			        </div>
			        <div class="form-group">
			        	<label class="control-label col-sm-3"> 选择图标：</label>
			        	<div class="col-sm-8" id="resource_icons" style="height:200px; overflow:auto; border:0px solid #000000;">
			        		
			        	</div>
			        </div>
			    </form>
            </div>
            <div class="modal-footer">
            	<button type="button" class="btn btn-sm btn-primary" id="resourceModelBtn">确定</button>
                <button type="button" class="btn btn-sm btn-default" data-dismiss="modal" id="Close">关闭</button>
            </div>
        </div>
   </div>
</div>

<div id="main-content">
	<div class="row" >
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading"><i class="fa fa-th-large"></i>${title}</div>
					<div class="panel-body">
						<div id="resource_tree_tools">
							<div class="text-right" >
								<button type="button" class="btn btn-success btn-sm" id="addNewData">添加</button>
								<button type="button" class="btn btn-primary btn-sm" id="updateSelectedData">编辑</button>
						        <button type="button" class="btn btn-danger btn-sm" id="deleteSelectedData">删除</button>
							</div>
						</div>
						<div class="tree well" id="root">
							
						</div>
					</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(function() {
		
		queryTree();
		
		//删除资源
		$("#deleteSelectedData").on('click', function() {
			
			var node = $("#root input[name=code]:checked");
			if(node) {
				var name = node.next().text();
				var r = confirm("你确定删除菜单“"+name+"”吗？");
				if(r) {
					var arr = node.val().split('_');
					$.ajax({
						url: '${ctx}/admin/resource/deleteResource.do',
						type: 'POST',
						dataType: 'JSON',
						data: {id:arr[1]},
						success: function(data) {
							if(data.success==true){
		    					queryTree();
		    				}else{
		    					alert(data.errorMessage);
		    				}
						}
					});
				}
			}else {
				alert("请选择目标节点！");
			}
		});
		
		//添加资源
		$("#addNewData").on('click',function(){
			$("#resourceModel .modal-title").empty().html("新增");
			$("#resource_edit_form").resetForm();
			$("#resource_edit_form input[name=code]").removeAttr("readonly");
			$("#resource_parentCode").html("<option value='0'>0</option>");
			$("#resource_icons").html("");
			$("#resource_edit_form input[name=id]").val("");
			var value = $("#root input[name=code]:checked").val();
			if(value !=null && value != '') {
				var arr = value.split('_');
				$("<option value='"+arr[0]+"' selected='selected'>"+arr[0]+"</option>").appendTo("#resource_parentCode");
			}
			$("#resource_icons").append(iconsHtml());
			$("#resourceModel").modal("show");
		});
		
		//编辑资源
		$("#updateSelectedData").on('click',function() {
			$("#resourceModel .modal-title").empty().html("编辑");
			$("#resource_edit_form").resetForm();
			$("#resource_parentCode").html("");
			$("#resource_icons").html("");
			var value = $("#root input[name=code]:checked").val();
			if(value !=null && value != '') {
				var arr = value.split('_');
				$.ajax({
					url: '${ctx}/admin/resource/queryResourceById.do',
					type: 'POST',
					dataType: 'JSON',
					data: {id: arr[1]},
					success: function(data){
						if(data.success==true) {
							$("#resource_edit_form input[name=id]").val(data.result.id);
							$("#resource_edit_form input[name=name]").val(data.result.name);
							$("#resource_edit_form input[name=url]").val(data.result.url);
							$("#resource_edit_form input[name=isMenu]").val([data.result.isMenu]);
							$("#resource_edit_form input[name=code]").val(data.result.code);
							$("#resource_edit_form input[name=code]").attr("readonly",true);
							$("#resource_edit_form input[name=weight]").val(data.result.weight);
							var result = data.result.parentCode.split(',');
							var flag = true;
							$.each(result, function(i,n) {
								$("#resource_parentCode").append("<option value='"+n+"'>"+n+"</option>");
								if(n == '') {
									flag = false;
								}
							});
							if(flag == true) {
								$("#resource_parentCode").append("<option value=''></option>");
							}
							$("#resource_icons").append(iconsHtml());
							$("#resource_edit_form input[name=icons]").val([data.result.icons]);
							$("#resourceModel").modal("show");
						}
					}
				});
				
			}else {
				alert("请选择节点！");
			}
		});
		
		//提交资源信息
		$("#resourceModel").on('click','#resourceModelBtn',function(){
			$("#resource_edit_form").submit();
		});
		
		//添加和编辑请求验证
		$("#resource_edit_form").validate({
			rules: {
				name:{required:true,maxlength:30},
				code:{required:true,maxlength:30},
			},
			messages : {
				name:{required:"必填",maxlength:"最大长度30"},
				code:{required:"必填",maxlength:"最大长度30"},
			},
			submitHandler: function(form) {
				if(form.code.value.indexOf("_") < 0) {
					$("#resourceModel").prop("disabled",true);
		    		$(form).ajaxSubmit({
		    			type:"post",
		    			dataType:"json",
		    			url:"${ctx}/admin/resource/saveOrUpdate.do",
		    			success:function(data){
		    				if(data.success==true){
		    					$('#resourceModel').modal('hide') 
		    					queryTree();
		    				}else{
		    					alert(data.errorMessage);
		    				}
		    				$("#resourceModel").prop("disabled",false);
		                }  
		            });
				}else {
					alert("编码不能包含“_”字符");
				}
				
			}
		});
		
		
	});
	
	//添加tree样式
	function addTreeStyle() {
		$('.tree li:has(ul)').addClass('parent_li').find(' > span').attr(
				'title', 'Collapse this branch');
		$('.tree li.parent_li > span').on('click', function(e) {
			var children = $(this).parent('li.parent_li').find(' > ul > li');
			if (children.is(":visible")) {
				children.hide('fast');
			} else {
				children.show('fast');
			}
			e.stopPropagation();
		});
	}
	
	function queryTree() {
		$.ajax({
			url: '${ctx}/admin/resource/queryResource.do',
			type: 'POST',
			dataType: 'JSON',
			success: function(data) {
				var treeHtml = loadTree(data.result);
				$("#root").empty().append(treeHtml);
				addTreeStyle();
				
			}
		});
	}
	
	//加载tree
	function loadTree(result) {
		var html="";
   		if(result&&result.length>0){
   			html+="<ul>";
   			$.each(result, function (n, node) {  
				var nodeHtml="<li><input type='radio' name='code' value='"+node.code+"_"+node.id+"'><span>"+node.name+" ("+node.code+")</span>";
			    nodeHtml+=loadTree(node.children);
			    nodeHtml+="</li>";
			    html+=nodeHtml;
          	});  
          	html+="</ul>";
   		}
   		return html;
	}
	
	
</script>

