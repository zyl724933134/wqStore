<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tag.jsp"%>
<%@ include file="/WEB-INF/include/common.jsp"%>

<link rel="stylesheet" href="${ctx}/statics/css/custom_theme.css" />
<link href="${ctx}/statics/lib/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" >

<script src="${ctx}/statics/lib/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js" charset="UTF-8" type="text/javascript"></script>
<script src="${ctx}/statics/lib/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>


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

							<form class="form-horizontal" role="form" id="order_search_form">
								<div class="form-group">
									<label class="col-sm-2 control-label"> 订单编号 </label>
									<div class="col-sm-2">
										<input id="search_orderCode" name="orderCode" type="text" placeholder="订单编号" class="form-control"/> 
									</div>
									
									<label class="control-label col-sm-2">开始时间 </label>
									<div class="col-sm-2">
										<div class="input-group">
											<span class="input-group-addon">
												<i class="icon-calendar bigger-110"></i>
											</span>
											<input class="form-control" type="text" name="startTime" id="search_startTime" placeholder="下单开始时间"/>
										</div>
									</div>
									<label class="control-label col-sm-2">截止时间</label>
									<div class="col-sm-2">
										<div class="input-group">
											<span class="input-group-addon">
												<i class="icon-calendar bigger-110"></i>
											</span>
											<input class="form-control" type="text" name="endTime" id="search_endTime" placeholder="下单截止时间"/>
										</div>
									</div>
									
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label"> 收货人 </label>
									<div class="col-sm-2">
										<input id="search_goodReceiverName" name="goodReceiverName" type="text" placeholder="收货人" class="form-control"/> 
									</div>
									<label class="control-label col-sm-2">支付状态 </label>
									<div class="col-sm-2">
										<select	name="paymentState" id="search_paymentState" class="form-control">
											<option value="">全部</option>
											<option value="0">未支付</option>
											<option value="1">已支付</option>
										</select>
									</div>
									<label class="control-label col-sm-2">支付方式 </label>
									<div class="col-sm-2">
										<select	name="paymentType" id="search_paymentType" class="form-control">
											<option value="">全部</option>
											<option value="1">货到付款</option>
											<option value="2">银行转账</option>
											<option value="3">微信</option>
											<option value="4">支付宝</option>
										</select>
									</div>
									
								</div>								
								<div class="form-group">
									<label class="control-label col-sm-2">订单状态</label>
									<div class="col-sm-2">
										<select	name="orderState" id="search_orderState" class="form-control">
											<option value="">全部</option>
											<option value="1">待付款</option>
											<option value="2">待发货</option>
											<option value="3">已发货</option>
											<option value="4">已收货</option>
											<option value="5">已完成</option>
											<option value="6">已关闭</option>
											<option value="7">已取消</option>
										</select>
									</div>
									<label class="control-label col-sm-2"></label>
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
					<div id="order_table_tools">
						<div class="text-right">
<!-- 							<button type="button" class="btn btn-success btn-sm" onclick="addData()">开通账号</button> -->
						</div>
					</div>
					<table id="order_table" class="table table-bordered table-hover">
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
$(function(){
	$('#order_table').bootstrapTable({
		url: '${ctx}/admin/order/queryOrder.do',
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
			title: 'ID'
		},{
			field: 'orderCode',
			title: '订单编号'
		},{
			field: 'orderAmount',
			title: '订单总金额'
		},{
			field: 'goodReceiverName',
			title: '收货人',
			formatter: function(value, row, index){
				if(row.goodReceiverName && row.goodReceiverPhone) {
					return row.goodReceiverName + ':' +row.goodReceiverPhone;
				}
				return '';
			}
		},{
			field: 'paymentState',
			title: '支付状态',
			formatter: function(value, row, index){
				var html = '';
				switch(value) {
					case 0 : html = '<span class="label label-warning arrowed arrowed-right">未支付</span>';
							break;
					case 1 : html = '<span class="label label-success arrowed arrowed-right">已支付</span>';
							break;
				}
				
				return html;
			}
		},{
			field: 'paymentType',
			title: '支付方式',
			formatter: function(value, row, index){
				var html = '';
				switch(value) {
					case 1 : html = '<span class="label label-grey arrowed-in-right arrowed-in">货到付款</span>';
							break;
					case 2 : html = '<span class="label label-danger arrowed-in-right arrowed-in">银行转账</span>';
							break;
					case 3 : html = '<span class="label label-success arrowed-in-right arrowed-in">微信</span>';
							break;
					case 4 : html = '<span class="label label-info arrowed-in-right arrowed-in">支付宝</span>';
							break;
				
				}
				
				return html;
			}
		},{
			field: 'orderState',
			title: '订单状态',
			formatter: function(value, row, index){
				var html = '';
				switch(value) {
					case 1 : html = '<span class="label label-warning arrowed">待付款</span>';
							break;
					case 2 : html = '<span class="label label-purple arrowed">待发货</span>';
							break;
					case 3 : html = '<span class="label label-primary arrowed">已发货</span>';
							break;
					case 4 : html = '<span class="label label-info arrowed">已收货</span>';
							break;
					case 5 : html = '<span class="label label-success arrowed">已完成</span>';
							break;
					case 6 : html = '<span class="label arrowed">已关闭</span>';
							break;
					case 7 : html = '<span class="label label-danger arrowed">已取消</span>';
							break;
				
				}
				
				return html;
			}
		},{
			field: 'createTime',
			title: '创建时间'
		},{
			field: '',
			title: '操作',
			align: 'center',
			width: 200,
			formatter: function(value, row, index){
				var delIsDisabled = "disabled";
				if(row.orderState == 7) {
					delIsDisabled = "";
				}

				var confirmIsDisabled = "disabled";
				if(row.paymentState == 0) {
					confirmIsDisabled = "";
				}
				
				return '<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">'
						+'<button class="btn btn-xs btn-info" id="orderDetail" '
						+'data-code="o_'+row.orderCode+'" data-name="订单详情"  data-url="/admin/order/orderDetailPage.do?id='+row.id+'" >订单详情</button>'
						+'<button class="btn btn-xs btn-success" '+confirmIsDisabled+' id="confirmReceipt" >确认收款</button>'
						+'<button class="btn btn-xs btn-danger" '+delIsDisabled+' id="deleteData" >删除</button></div>';
						
			
			},
			events: {
				'click #orderDetail': orderDetail,
				'click #confirmReceipt': confirmReceipt,
				'click #deleteData': deleteData
			}
			
		}],
		queryParams: function(params){
			console.log(params);
			$.extend(params,$("#order_search_form").serializeJson())
			return params;
		}
		
		
	});

	//搜索订单
	$("#order_search_form").submit(function(e){
		e.preventDefault();
		$('#order_table').bootstrapTable('refresh');
	});
	
	//时间控件
	$('#search_startTime').datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',
        language:'zh-CN',
        weekStart:1,
        todayBtn: true,
    }).on('changeDate',function(ev){
    	var startTime = $('#search_startTime').val();
    	$('#search_endTime').datetimepicker('setStartDate',startTime);
    	$('#search_startTime').datetimepicker('hide');
    });
	
	$('#search_endTime').datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',
        language:'zh-CN',
        weekStart:1,
        todayBtn: true,
    }).on('changeDate',function(ev){
    	var endTime = $('#search_endTime').val();
    	$('#search_startTime').datetimepicker('setEndDate',endTime);
    	$('#search_endTime').datetimepicker('hide');
    });
	
});


//订单详情
function orderDetail(e, v, row) {
	addTab(this); 
	$(this).removeClass("active");
}

//删除用户
function deleteData(e, v, row) {
	debugger;
	var r = confirm("你确定删除订单“"+row.orderCode+"”吗？");
	if(r){
		$.ajax({
			 url: "${ctx}/admin/order/deleteOrderById.do",
			 type: "POST",
			 data: {"id": row.id}, 
			 success: function (data) {
			 	if(data.success){
			 		$('#order_table').bootstrapTable('refresh');
			 		alert("删除成功！");
			     }else {
			     	alert(data.errorMessage);
			     }
			}
   		});
	}
	
}

function confirmReceipt(e, v, row) {
	$.ajax({
		 url: "${ctx}/admin/order/updateOrderPaymentType.do",
		 type: "POST",
		 data: {"id": row.id}, 
		 success: function (data) {
		 	if(data.success){
		 		$('#order_table').bootstrapTable('refresh');
		     }else {
		     	alert(data.errorMessage);
		     }
		}
	});
}


</script>