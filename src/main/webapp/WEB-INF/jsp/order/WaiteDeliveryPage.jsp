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
									<label class="col-sm-1 control-label"> 订单编号 </label>
									<div class="col-sm-2">
										<input id="search_orderCode" name="orderCode" type="text" placeholder="订单编号" class="form-control"/> 
									</div>
									
									<label class="control-label col-sm-1">订单状态 </label>
									<div class="col-sm-2">
										<select	name="orderState" id="search_orderState" class="form-control">
											<option value="">全部</option>
											<option value="2">待发货</option>
											<option value="3">已发货</option>
										</select>
									</div>
									
									<label class="col-sm-1 control-label"> 收货人 </label>
									<div class="col-sm-2">
										<input id="search_goodReceiverName" name="goodReceiverName" type="text" placeholder="收货人" class="form-control"/> 
									</div>
									
								</div>
															
								<div class="form-group">
									<label class="control-label col-sm-1"></label>
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
		url: '${ctx}/admin/order/WaiteDeliveryDetaile.do',
		paginationLoop: false,
		pagination: true,
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
			field: 'orderDealAmount',
			title: '订单成交总金额'
		},{
			field: 'deliveryType',
			title: '配送方式',
			formatter: function(value, row, index){ 
				if(value == 1) {
					return '大丰配送';
				}else {
					return '自提';
				}
			}
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
			field: '',
			title: '操作',
			align: 'center',
			width: 100,
			formatter: function(value, row, index){
				var  state=row.orderState;
				if(state==3){
					return '<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">'
					+'<button class="btn btn-xs btn-purple"  disabled="disabled">完成发货</button></div>';
				}else{
					return '<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">'
					+'<button class="btn btn-xs btn-success" id="deliveryOrder">一键发货</button></div>';
				}
			},
			events: {
				'click #deliveryOrder': deliveryOrder
			}
			
		}],
		queryParams: function(params){
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



//一键发货
function deliveryOrder(e, v, row) {
	$.ajax({
		 url: "${ctx}/admin/order/changeOrderState.do",
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