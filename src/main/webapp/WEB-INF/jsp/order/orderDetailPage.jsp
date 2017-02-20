<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tag.jsp"%>
<%@ include file="/WEB-INF/include/common.jsp"%>

<link rel="stylesheet" href="${ctx}/statics/css/custom_theme.css" />
<link href="${ctx}/statics/lib/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" >

<script src="${ctx}/statics/lib/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js" charset="UTF-8" type="text/javascript"></script>
<script src="${ctx}/statics/lib/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>


<!-- 模态窗口 -->
<div class="modal fade" id="invoiceModel" tabindex="-1" role="dialog" aria-labelledby="invoiceModelLabel" aria-hidden="true" data-backdrop="false">
  <div class="modal-dialog" >
        <div class="modal-content">
            <div class="modal-header">
            	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
                	<span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" >发票详情</h4>
            </div>
            <div class="modal-body">
            	<form id="invoice_edit_form" class="form-horizontal">
			        <input type="hidden" id="order_id" name="orderId" value="${order.id}">
			        <input type="hidden" name="id" value="">
			        <div class="form-group">
			        	<label class="control-label col-sm-3">发票抬头：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="title_name" name="titleName" >
			        	</div>
		        	</div>
		        	
		        	<div class="form-group">
			        	<label class="control-label col-sm-3">纳税人识别号：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="identify_num" name="identifyNum" >
			        	</div>
		        	</div>
		        	<div class="form-group">
			        	<label class="control-label col-sm-3">公司名称：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="receiver_company" name="receiverCompany" >
			        	</div>
			        </div>
			        
			         <div class="form-group">
			        	<label class="control-label col-sm-3">公司地址：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="company_address" name="companyAddress" >
			        	</div>
			        </div>
			         <div class="form-group">
			        	<label class="control-label col-sm-3">公司电话：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="company_tel" name="companyTel" >
			        	</div>
			        </div>
			        
			        <div class="form-group">
			        	<label class="control-label col-sm-3">开户银行名称：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="bank_name" name="bankName" >
			        	</div>
			        </div>
			        
			        <div class="form-group">
			        	<label class="control-label col-sm-3">开户银行账号：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="bank_account" name="bankAccount" >
			        	</div>
			        </div>
			        
			        <div class="form-group">
			        	<label class="control-label col-sm-3">收票人：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="receiver_name" name="receiverName" >
			        	</div>
			        </div>
			        <div class="form-group">
			        	<label class="control-label col-sm-3">收票人电话：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="receiver_tel" name="receiverTel" >
			        	</div>
			        </div>
			        <div class="form-group">
			        	<label class="control-label col-sm-3">收票人手机：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="receiver_phone" name="receiverPhone" >
			        	</div>
			        </div>
			        <div class="form-group">
			        	<label class="control-label col-sm-3">收票地址：</label>
			        	<div class="col-sm-8">
				            <input type="text" class="form-control" id="receiver_address" name="receiverAddress" disabled="disabled" >
			        	</div>
			        </div>
			        <div class="form-group" id="password_block">
			        	<label class="control-label col-sm-3"> 发票内容：</label>
			        	<div class="col-sm-8">
				            <textarea type="text" class="form-control" id="content" name="content" ></textarea>
			        	</div>
			        </div>
			        <div class="form-group" id="password_block">
			        	<label class="control-label col-sm-3"> 备注：</label>
			        	<div class="col-sm-8">
				            <textarea type="text" class="form-control" id="comments" name="comments" ></textarea>
			        	</div>
			        </div>
			        
			    </form>
            </div>
            <div class="modal-footer">
            	<button type="button" class="btn btn-sm btn-primary" id="invoiceModelBtn">确定</button>
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
							
						<!---------------------------- order_base_table ---------------------------->
						<div class="table-header" align="center">基本信息 </div>
						<table id="order_base_table" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th><div class="th-inner">订单ID</div></th>
									<th><div class="th-inner">订单编号</div></th>
									<th><div class="th-inner">用户</div></th>
									<th><div class="th-inner">手机</div></th>
									<th><div class="th-inner">应付</div></th>
									<th><div class="th-inner">订单状态</div></th>
									<th><div class="th-inner">下单时间</div></th>
									<th><div class="th-inner">确认收款时间</div></th>
									<th><div class="th-inner">支付方式</div></th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${!empty order}">
									<tr>
										<td>${order.id}</td>
										<td>${order.orderCode}</td>
										<td>${endUser.endUserName}</td>
										<td>${endUser.phoneNum}</td>
										<td id="base_order_deal_amount">${order.orderDealAmount}</td>
										<td>
											<c:if test="${order.orderState == 1}">待付款</c:if>
											<c:if test="${order.orderState == 2}">待发货</c:if>
											<c:if test="${order.orderState == 3}">已发货</c:if>
											<c:if test="${order.orderState == 4}">已收货</c:if>
											<c:if test="${order.orderState == 5}">已完成</c:if>
											<c:if test="${order.orderState == 6}">已关闭</c:if>
											<c:if test="${order.orderState == 7}">已取消</c:if>
										</td>
										<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${order.createTime}"/></td>
										<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${order.paymentConfirmDate}"/></td>
										<td>
											<c:if test="${order.paymentType == 1}">货到付款</c:if>
											<c:if test="${order.paymentType == 2}">银行转账</c:if>
											<c:if test="${order.paymentType == 3}">微信支付 </c:if>
											<c:if test="${order.paymentType == 3}">支付宝</c:if>
										</td>
									</tr>
								</c:if>
							</tbody>
						</table>
						
						<!---------------------------- order_receive_table ---------------------------->
						<div class="table-header" align="center">收货信息
							<span style="margin-left: 10px;">
								<button id="edit_receive_btn" class="btn btn-xs btn-info btn-app" ><i class="icon-edit bigger-140"></i></button>
							</span>
							<span style="margin-left: 10px;">
								<button id="save_receive_btn" class="btn btn-xs btn-info btn-app" style="display: none;"><i class="icon-save bigger-140"></i></button>
							</span>
							<span style="margin-left: 10px;">
								<button id="cancel_receive_btn" class="btn btn-xs btn-info btn-app" style="display: none;"><i class="glyphicon glyphicon-remove bigger-140"></i></button>
							</span>
						</div>
						<form id="receive_edit_form">
							<input name="id" type="hidden" value="${order.id}">
							<table id="order_receive_table" class="table table-bordered table-hover">
							</table>
						</form>
						
						<!---------------------------- order_product_table ---------------------------->
						<div class="table-header" align="center">商品信息
							<span style="margin-left: 10px;">
								<button id="edit_product_btn" class="btn btn-xs btn-info btn-app" >
									<i class="icon-edit bigger-140"></i>
								</button>
							</span>
							<span style="margin-left: 10px;">
								<button id="save_product_btn" class="btn btn-xs btn-info btn-app" style="display: none;"><i class="icon-save bigger-140"></i></button>
							</span>
							<span style="margin-left: 10px;">
								<button id="cancel_product_btn" class="btn btn-xs btn-info btn-app" style="display: none;"><i class="glyphicon glyphicon-remove bigger-140"></i></button>
							</span>
						</div>
						<form id="product_edit_form">
							<input name="id" type="hidden" value="${order.id}">
							<table id="order_product_table" class="table table-bordered table-hover">
							</table>
						</form>
						
						<!---------------------------- order_fee_table ---------------------------->
						<div class="table-header" align="center">费用信息
							<span style="margin-left: 10px;">
								<button id="edit_fee_btn" class="btn btn-xs btn-info btn-app" >
									<i class="icon-edit bigger-140"></i>
								</button>
							</span>
							
							<span style="margin-left: 10px;">
								<button id="save_fee_btn" class="btn btn-xs btn-info btn-app" style="display: none;"><i class="icon-save bigger-140"></i></button>
							</span>
							<span style="margin-left: 10px;">
								<button id="cancel_fee_btn" class="btn btn-xs btn-info btn-app" style="display: none;"><i class="glyphicon glyphicon-remove bigger-140"></i></button>
							</span>
						</div>
						
						<form id="fee_edit_form">
							<input name="id" type="hidden" value="${order.id}">
							<table id="order_fee_table" class="table table-bordered table-hover">
							</table>
						</form>
						
						
						<!---------------------------- order_invoice_table ---------------------------->
						<div class="table-header" align="center">发票信息
							<c:if test="${!empty order && order.orderNeedInvoice != 0}">
								<span style="margin-left: 10px;">
									<button id="view_invoice_btn" class="btn btn-xs btn-info btn-app" >
										<i class="icon-eye-open bigger-140"></i>
									</button>
								</span>
								<c:if test="${order.invoiceState == 0}">
									<span style="margin-left: 10px;">
										<button id="edit_invoice_btn" class="btn btn-xs btn-info btn-app" >
											<i class="icon-edit bigger-140"></i>
										</button>
									</span>
								</c:if>
							</c:if>
						</div>
						<table id="order_invoice_table" class="table table-bordered table-hover">
						</table>
						
						
						<div class="table-header" align="center">其他信息
							<span style="margin-left: 10px;">
								<button id="edit_other_btn" class="btn btn-xs btn-info btn-app" >
									<i class="icon-edit bigger-140"></i>
								</button>
							</span>
							
							<span style="margin-left: 10px;">
								<button id="save_other_btn" class="btn btn-xs btn-info btn-app" style="display: none;"><i class="icon-save bigger-140"></i></button>
							</span>
							<span style="margin-left: 10px;">
								<button id="cancel_other_btn" class="btn btn-xs btn-info btn-app" style="display: none;"><i class="glyphicon glyphicon-remove bigger-140"></i></button>
							</span>
						</div>
						
						<form id="other_edit_form">
							<input name="id" type="hidden" value="${order.id}">
							<table id="order_other_table" class="table table-bordered table-hover">
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</div>

<script type="text/javascript">
	$(function(){
		
		$('#order_receive_table').bootstrapTable({
			url: '${ctx}/admin/order/getOrderDetail.do',
			pagination: false,
			smartDisplay: false,
			striped: true,
		    sidePagination: 'server',
		    showRefresh: false,
		    showColumns: false,
		    cache: false,
			columns: [{
				field: 'goodReceiverName',
				title: '收货人',
				width: 100
			},{
				field: 'goodReceiverPhone',
				title: '联系方式',
				width: 100
			},{
				field: 'goodReceiverProvince',
				title: '收货地址',
				width: 300,
				formatter : function(val, row, index) {
					return row.goodReceiverProvince + ',' + row.goodReceiverCity +',' + row.goodReceiverCounty + ',' +row.goodReceiverAddress;
				}
			},{
				field: 'goodReceiverPostCode',
				title: '邮编',
				width: 100
			},{
				field: 'deliveryType',
				title: '配送方式',
				width: 100,
				formatter: function(val, row, index){
					if(val == 1) {
						return '大丰配送';
					}else {
						return '自提';
					}
				}
			}],
			queryParams: function(params){
				params.id = "${order.id}";
				return params;
			}
		});
		
		$('#order_product_table').bootstrapTable({
			url: '${ctx}/admin/order/getOrderItems.do',
			pagination: false,
			smartDisplay: false,
			striped: true,
		    sidePagination: 'server',
		    showRefresh: false,
		    showColumns: false,
		    cache: false,
			columns: [{
				field: 'productId',
				title: '商品ID'
			},{
				field: 'productCname',
				title: '商品名称'
			},{
				field: 'itemNum',
				title: '数量'
			},{
				field: 'itemAmount',
				title: '单品总价'
			},{
				field: 'itemDealAmount',
				title: '单品成交总价'
			}],
			queryParams: function(params){
				params.id = "${order.id}";
				return params;
			}
		});
		
		$('#order_fee_table').bootstrapTable({
			url: '${ctx}/admin/order/getOrderDetail.do',
			pagination: false,
			smartDisplay: false,
			striped: true,
		    sidePagination: 'server',
		    showRefresh: false,
		    showColumns: false,
		    cache: false,
			columns: [{
				field: 'productAmount',
				title: '商品总价'
			},{
				field: 'orderDeliveryFee',
				title: '运费'
			},{
				field: 'orderAmount',
				title: '订单总金额'
			},{
				field: 'orderDealAmount',
				title: '实际应付'
			}],
			queryParams: function(params){
				params.id = "${order.id}";
				return params;
			}
		});
		
		
		$('#order_invoice_table').bootstrapTable({
			url: '${ctx}/admin/order/getOrderInvoice.do',
			pagination: false,
			smartDisplay: false,
			striped: true,
		    sidePagination: 'server',
		    showRefresh: false,
		    showColumns: false,
		    cache: false,
			columns: [{
				field: 'orderNeedInvoice',
				title: '发票类型',
				formatter: function(val, row, index){
					if(val == 0) {
						return '不需要';
					}else if(val == 1) {
						return '普通发票';
					}else{
						return '增值税发票';
					}
				}
			},{
				field: 'invoiceState',
				title: '发票状态',
				formatter: function(val, row, index){
					if(val == 0) {
						return '未开';
					}else {
						return '已开';
					}
				}
			},{
				field: 'sellOrderInvoice.receiverName',
				title: '收票人',
				formatter: function(val, row, index){
					return row.sellOrderInvoice.receiverName;
				}
			},{
				field: 'sellOrderInvoice.receiverPhone',
				title: '收票人手机',
				formatter: function(val, row, index){
					return row.sellOrderInvoice.receiverPhone;
				}
			},{
				field: 'receiverProvince',
				title: '收票地址',
				formatter: function(val, row, index){
					var province = row.sellOrderInvoice.receiverProvince;
					var city = row.sellOrderInvoice.receiverCity;
					var county = row.sellOrderInvoice.receiverCounty;
					var addr = row.sellOrderInvoice.receiverAddress;
					
					var html = '';
					if(province && city && county && addr) {
						
						html += province+','+city+','+county+','+addr;
					}
					
					return html;
				}
			},{
				field: '',
				title: '操作',
				align: 'center',
				formatter: function(value, row, index){
					var isDisabled = "disabled";
					if(row.invoiceState == 0 && row.orderNeedInvoice != 0) {
						isDisabled = "";
					}
					
					return '<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">'
							+'<button class="btn btn-xs btn-success" '+isDisabled+' id="completeInvoice" >完成开票</button></div>';
							
				
				},
				events: {
					'click #completeInvoice': completeInvoice
				}
			}],
			queryParams: function(params){
				params.id = "${order.id}";
				return params;
			}
		});
		
		$('#order_other_table').bootstrapTable({
			url: '${ctx}/admin/order/getOrderDetail.do',
			pagination: false,
			smartDisplay: false,
			striped: true,
		    sidePagination: 'server',
		    showRefresh: false,
		    showColumns: false,
		    cache: false,
			columns: [{
				field: 'orderRemark',
				title: '备注',
				width: 200
			},{
				field: 'orderWeight',
				title: '重量',
				width: 50
			}],
			queryParams: function(params){
				params.id = "${order.id}";
				return params;
			}
		});
		
		
		//==============================================================编辑订单收货信息
		var order_receive_tbody = "";
		$('#edit_receive_btn').on('click',function(){
			
			order_receive_tbody = $('#order_receive_table tbody').html();

			var table = $('#order_receive_table').bootstrapTable('getData');
			$('#order_receive_table tbody').empty();
			var html = '<tr>'
						+'<td><input name="goodReceiverName" value="'+table[0].goodReceiverName+'" class="form-control"></td>'
						+'<td><input name="goodReceiverPhone" value="'+table[0].goodReceiverPhone+'" class="form-control"></td>'
						+'<td>'+table[0].goodReceiverProvince+','+table[0].goodReceiverCity+','+table[0].goodReceiverCounty+','+table[0].goodReceiverAddress+'</td>'
						+'<td><input name="goodReceiverPostCode" value="'+table[0].goodReceiverPostCode+'" class="form-control"></td>'
						+'<td>'
						+'<select name="deliveryType" class="form-control">';
						if(table[0].deliveryType == 1) {
							
							html +='<option value="1" selected>大丰配送</option>'
									+'<option value="2">自提</option>';
						}else {
							html +='<option value="1" >大丰配送</option>'
								+'<option value="2" selected>自提</option>';
						}
				html+='</select>'
						+'</td>'
						+'</tr>';
			$('#order_receive_table tbody').append(html);
			
			$('#save_receive_btn').show();
			$('#cancel_receive_btn').show();
			
		});
			
		//验证收货信息
		$("#receive_edit_form").validate({
			rules: {
				goodReceiverName:{required:true},
				goodReceiverPhone:{required:true},
				goodReceiverPostCode:{required:true},
			},
			messages : {
				goodReceiverName:{required:"请填写收货人姓名"},
				goodReceiverPhone:{required:"请填写收货人联系方式"},
				goodReceiverPostCode:{required:"请填写邮编"},
			},
			errorPlacement: function(error, element){
				var $element = $(element);
				$(error).addClass('text-danger').css('width', '250px');
				$element.popover({
					html: true,
					placement:'bottom',
					content: error
				}).popover('show');
				
				$element.parent().addClass('has-error');
			},
			submitHandler: function(form) {
				$("#save_receive_btn").prop("disabled",true);
	    		$(form).ajaxSubmit({
	    			type:"post",
	    			dataType:"json",
	    			url:"${ctx}/admin/order/updateOrderById.do",
	    			success:function(data){
	    				if(data.success){
	    					$('#order_receive_table').bootstrapTable('refresh');
							$("#save_receive_btn").hide();
							$('#cancel_receive_btn').hide();
	    				}else{
	    					alert(data.errorMessage);
	    				}
						$("#save_receive_btn").prop("disabled",false);
	                }  
	            });
			}
		});
		
		//提交订单收货信息
		$('#save_receive_btn').on('click',function(){
			
			$('#receive_edit_form').submit();
		});
		
		//取消编辑收货信息
		$('#cancel_receive_btn').on('click',function(){
			$('#order_receive_table tbody').html(order_receive_tbody);
			$("#save_receive_btn").hide();
			$('#cancel_receive_btn').hide();
		});
		
		//==============================================================编辑订单商品信息
		var order_product_tbody = "";
		$('#edit_product_btn').on('click',function(){
			order_product_tbody = $('#order_product_table tbody').html();

			var table = $('#order_product_table').bootstrapTable('getData');
			$('#order_product_table tbody').empty();
			var html = '';
			$.each(table,function(i,n){
				html += '<tr>'
					+'<td><input name="sellOrderItemList['+i+'].productId" type="hidden" value="'+this.productId+'">'+this.productId+'</td>'
					+'<td>'+this.productCname+'</td>'
					+'<td>'+this.itemNum+'</td>'
					+'<td>'+this.itemAmount+'</td>'
					+'<td><input name="sellOrderItemList['+i+'].itemDealAmount" value="'+this.itemDealAmount+'" class="form-control"></td>'
					+'</tr>';
			});
			
			$('#order_product_table tbody').append(html);
			
			$('#save_product_btn').show();
			$('#cancel_product_btn').show();
			
		});
		
		//商品信息验证
		$("#product_edit_form").validate({
			rules: {
				itemDealAmount:{required:true,number:true},
			},
			messages : {
				itemDealAmount:{required:"请填写单品成交总价",number:"请填写数字"},
			},
			errorPlacement: function(error, element){
				var $element = $(element);
				$(error).addClass('text-danger').css('width', '250px');
				$element.popover({
					html: true,
					placement:'bottom',
					content: error
				}).popover('show');
				
				$element.parent().addClass('has-error');
			},
			submitHandler: function(form) {
				$("#save_product_btn").prop("disabled",true);
	    		$(form).ajaxSubmit({
	    			type:"post",
	    			dataType:"json",
	    			url:"${ctx}/admin/order/updateItemByOrderId.do",
	    			success:function(data){
	    				if(data.success){
	    					$('#order_product_table').bootstrapTable('refresh');
	    					$('#order_fee_table').bootstrapTable('refresh');
	    					refreshAmount(data.result.orderDealAmount);
	    					
							$("#save_product_btn").hide();
							$('#cancel_product_btn').hide();
	    				}else{
	    					alert(data.errorMessage);
	    				}
						$("#save_product_btn").prop("disabled",false);
	                }  
	            });
			}
		});
		
		//提交商品信息
		$('#save_product_btn').on('click',function(){
			
			$('#product_edit_form').submit();
		});
		
		//取消编辑商品信息
		$('#cancel_product_btn').on('click',function(){
			$('#order_product_table tbody').html(order_product_tbody);
			$("#save_product_btn").hide();
			$('#cancel_product_btn').hide();
		});
		
		
		//==============================================================编辑订单费用信息
		var order_fee_tbody = "";
		$('#edit_fee_btn').on('click',function(){
			order_fee_tbody = $('#order_fee_table tbody').html();
			
			var table = $('#order_fee_table').bootstrapTable('getData');
			$('#order_fee_table tbody').empty();
			var html = '<tr>'
					+'<td>'+table[0].productAmount+'</td>'
					+'<td>'+table[0].orderDeliveryFee+'</td>'
					+'<td>'+table[0].orderAmount+'</td>'
					+'<td><input name="orderDealAmount" value="'+table[0].orderDealAmount+'" class="form-control"></td>'
					+'</tr>';
			
			$('#order_fee_table tbody').append(html);
			
			$('#save_fee_btn').show();
			$('#cancel_fee_btn').show();
			
		});
		
		//订单费用信息验证
		$("#fee_edit_form").validate({
			rules: {
				orderDealAmount:{required:true,number:true},
			},
			messages : {
				itemDealAmount:{required:"请填写实际支付金额",number:"请填写数字"},
			},
			errorPlacement: function(error, element){
				var $element = $(element);
				$(error).addClass('text-danger').css('width', '250px');
				$element.popover({
					html: true,
					placement:'bottom',
					content: error
				}).popover('show');
				
				$element.parent().addClass('has-error');
			},
			submitHandler: function(form) {
				$("#save_fee_btn").prop("disabled",true);
	    		$(form).ajaxSubmit({
	    			type:"post",
	    			dataType:"json",
	    			url:"${ctx}/admin/order/updateOrderById.do",
	    			success:function(data){
	    				if(data.success){
							$('#save_fee_btn').hide();
	    					$('#order_product_table').bootstrapTable('refresh');
	    					refreshAmount(data.result.orderDealAmount);

	    					$('#cancel_fee_btn').hide();
	    					$('#order_fee_table').bootstrapTable('refresh');
	    					
	    				}else{
	    					alert(data.errorMessage);
	    				}
	    				$("#save_fee_btn").prop("disabled",false);
	                }  
	            });
			}
		});
		
		//提交商品信息
		$('#save_fee_btn').on('click',function(){
			
			$('#fee_edit_form').submit();
		});
		
		//取消编辑商品信息
		$('#cancel_fee_btn').on('click',function(){
			$('#order_fee_table tbody').html(order_fee_tbody);
			$("#save_fee_btn").hide();
			$('#cancel_fee_btn').hide();
		});
		
		//==============================================================查看发票信息
		$('#view_invoice_btn').on('click',function(){
			$("#invoice_edit_form").resetForm();
			var id = $("#order_id").val();
			$.ajax({
				type : 'post',
				dataType : 'json',
				url : '${ctx}/admin/order/getInvoiceByOrderId.do',
				data : {"id" : id},
				success : function(data) {
					if(data.success) {
						var invoice = data.result;
						$("#invoice_edit_form input[name=id]").val(invoice.id);
						$("#invoice_edit_form input[name=titleName]").val(invoice.titleName).attr("disabled","disabled");
						$("#invoice_edit_form input[name=receiverCompany]").val(invoice.receiverCompany).attr("disabled","disabled");
						$("#invoice_edit_form input[name=receiverName]").val(invoice.receiverName).attr("disabled","disabled");
						$("#invoice_edit_form input[name=receiverTel]").val(invoice.receiverTel).attr("disabled","disabled");
						$("#invoice_edit_form input[name=receiverPhone]").val(invoice.receiverPhone).attr("disabled","disabled");
						$("#invoice_edit_form input[name=receiverAddress]").val(invoice.receiverProvince +','+invoice.receiverCity +','+invoice.receiverCounty+','+invoice.receiverAddress);
						$("#invoice_edit_form textarea[name=content]").val(invoice.content).attr("disabled","disabled");
						$("#invoice_edit_form textarea[name=comments]").val(invoice.comments).attr("disabled","disabled");
						
						$("#invoice_edit_form input[name=identifyNum]").val(invoice.identifyNum).attr("disabled","disabled");
						$("#invoice_edit_form input[name=companyAddress]").val(invoice.companyAddress).attr("disabled","disabled");
						$("#invoice_edit_form input[name=companyTel]").val(invoice.companyTel).attr("disabled","disabled");
						$("#invoice_edit_form input[name=bankName]").val(invoice.bankName).attr("disabled","disabled");
						$("#invoice_edit_form input[name=bankAccount]").val(invoice.bankAccount).attr("disabled","disabled");
						$("#invoiceModelBtn").hide();
						$('#invoiceModel').modal('show');
					}else {
						alert(data.errorMessage);
					}
				}
			});
			
		});
		
		//编辑发票信息
		$('#edit_invoice_btn').on('click',function(){
			$("#invoice_edit_form").resetForm();
			var id = $("#order_id").val();
			$.ajax({
				type : 'post',
				dataType : 'json',
				url : '${ctx}/admin/order/getInvoiceByOrderId.do',
				data : {"id" : id},
				success : function(data) {
					if(data.success) {
						var invoice = data.result;
						$("#invoice_edit_form input[name=id]").val(invoice.id);
						$("#invoice_edit_form input[name=titleName]").val(invoice.titleName).removeAttr("disabled");
						$("#invoice_edit_form input[name=receiverCompany]").val(invoice.receiverCompany).removeAttr("disabled");
						$("#invoice_edit_form input[name=receiverName]").val(invoice.receiverName).removeAttr("disabled");
						$("#invoice_edit_form input[name=receiverTel]").val(invoice.receiverTel).removeAttr("disabled");
						$("#invoice_edit_form input[name=receiverPhone]").val(invoice.receiverPhone).removeAttr("disabled");
						$("#invoice_edit_form input[name=receiverAddress]").val(invoice.receiverProvince +','+invoice.receiverCity +','+invoice.receiverCounty+','+invoice.receiverAddress);
						$("#invoice_edit_form textarea[name=content]").val(invoice.content).removeAttr("disabled");
						$("#invoice_edit_form textarea[name=comments]").val(invoice.comments).removeAttr("disabled");
						
						$("#invoice_edit_form input[name=identifyNum]").val(invoice.identifyNum).attr("disabled","disabled");
						$("#invoice_edit_form input[name=companyAddress]").val(invoice.companyAddress).removeAttr("disabled");
						$("#invoice_edit_form input[name=companyTel]").val(invoice.companyTel).removeAttr("disabled");
						$("#invoice_edit_form input[name=bankName]").val(invoice.bankName).attr("disabled","disabled");
						$("#invoice_edit_form input[name=bankAccount]").val(invoice.bankAccount).attr("disabled","disabled");
						$("#invoiceModelBtn").show();
						$('#invoiceModel').modal('show');
					}else {
						alert(data.errorMessage);
					}
				}
			});
			
			
			$("#invoice_edit_form").validate({
				rules: {
					titleName:{required:true},
					receiverCompany:{required:true},
					receiverName:{required:true},
					receiverPhone:{required:true}
				},
				messages : {
					itemDealAmount:{required:"请填写发票抬头"},
					receiverCompany:{required:"请填写收票公司"},
					receiverName:{required:"请填写收票人"},
					receiverPhone:{required:"请填写收票人手机号"}
				},
				
				submitHandler: function(form) {
					$("#invoiceModel").prop("disabled",true);
		    		$(form).ajaxSubmit({
		    			type:"post",
		    			dataType:"json",
		    			url:"${ctx}/admin/order/updateOrderInvoice.do",
		    			success:function(data){
		    				if(data.success==true){
		    					$('#order_invoice_table').bootstrapTable('refresh');
		    					$('#invoiceModel').modal('hide');
		    				}else{
		    					alert(data.errorMessage);
		    				}
							$("#invoiceModel").prop("disabled",false);
							
		                }  
		            });
				}
			});
			
			//提交发票信息
			$("#invoiceModel").on('click','#invoiceModelBtn',function(){
				$("#invoice_edit_form").submit();
			});
			
		});
		
		//==============================================================编辑其他信息
		var order_receive_tbody = "";
		$('#edit_other_btn').on('click',function(){
			
			order_other_tbody = $('#order_other_table tbody').html();

			var table = $('#order_other_table').bootstrapTable('getData');
			console.log(table);
			var orderWeight = table[0].orderWeight == null ? '':table[0].orderWeight;
			$('#order_other_table tbody').empty();
			var html = '<tr>'
						+'<td><textarea name="orderRemark" class="form-control">'+table[0].orderRemark+'</textarea></td>'
						+'<td>'+orderWeight+'</td>'
						+'</tr>';
			$('#order_other_table tbody').append(html);
			
			$('#save_other_btn').show();
			$('#cancel_other_btn').show();
			
		});
			
		
		//提交订单其他信息
		$('#save_other_btn').on('click',function(){
			$("#save_other_btn").prop("disabled",true);
			$('#other_edit_form').ajaxSubmit({
	   			type:"post",
	   			dataType:"json",
	   			url:"${ctx}/admin/order/updateOrderById.do",
	   			success:function(data){
	   				if(data.success){
	   					$('#order_other_table').bootstrapTable('refresh');
						$("#save_other_btn").hide();
						$('#cancel_other_btn').hide();
	   				}else{
	   					alert(data.errorMessage);
	   				}
					$("#save_other_btn").prop("disabled",false);
	             }  
	         });
		});
		
		//取消编辑其他信息
		$('#cancel_other_btn').on('click',function(){
			$('#order_other_table tbody').html(order_other_tbody);
			$("#save_other_btn").hide();
			$('#cancel_other_btn').hide();
		});
		
		
		
	});
	
	//更新表格金额
	function refreshAmount(amount) {
		$('#base_order_deal_amount').text(amount);
	}
	
	function completeInvoice(e, v, row){
		var id = "${order.id}";
		$.ajax({
			 url: "${ctx}/admin/order/updateOrderById.do",
			 type: "POST",
			 data: {"id": id,"invoiceState":1}, 
			 success: function (data) {
			 	if(data.success){
			 		$('#order_invoice_table').bootstrapTable('refresh');
			 		$("#edit_invoice_btn").hide();
			     }else {
			     	alert(data.errorMessage);
			     }
			}
		});
	}
	
</script>