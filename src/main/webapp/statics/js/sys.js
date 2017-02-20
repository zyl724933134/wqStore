
//打开菜单页面
function addTab(ele) {
	//菜单选中样式
	var liNodes = $("#sidebar-menu li");
	$.each(liNodes,function(){
		$(this).removeClass("active");
	});
	$(ele).addClass("active");
	$(ele).parents(".open").addClass("active");
	
	
	var name = $(ele).attr("data-name");
	
	var code = $(ele).attr("data-code");
	var url = $(ele).attr("data-url"); 
	if(url){
		if(url.indexOf("?") > 0) {
			url = ctx + url + '&title='+name;
		}else {
			url = ctx + url + '?title='+name;
		}
		var param = $(ele).attr("data-param");
		if(param) {
			url += '&'+param;
		}
	}
	
	
	//清除活动样式
	var tNodes = $("#tab-title",parent.document).children("li");
	$.each(tNodes,function(){
		$(this).removeClass("active");
	});
	
	var cNodes = $("#tab-content",parent.document).children('div');
	$.each(cNodes,function(){
		$(this).removeClass("in active");
	});
	
	//判断tab是否存在
	var tabTile = $("#title_"+code,parent.document);
	var tabContent = $("#"+code,parent.document);
	if(tabTile.length > 0 && tabContent.length > 0) {
		//选中目标tab
		$("#title_"+code,parent.document).addClass("active");
		$("#"+code,parent.document).addClass("in active");
	}else {
		//新增tab标题
		var tHtml = "<li id='title_"+code+"' class='active' onclick='selectMenu(\""+code+"\")'><a data-toggle='tab' href='#"+code+"'>"+name+"<i onclick='removeTab(this,\""+code+"\",event)' class='icon-remove'></i></a></li>";
		$("#tab-title",parent.document).append(tHtml);
		
		//新增tab内容
		var cHtml = "<div id='"+code+"' class='tab-pane in active'>"
					+"<iframe id='iframe_"+code+"' frameborder='0' marginheight='0' style='height:100%; width:100%' marginwidth='0' src='"+url+"'></iframe>"
					+"</div>";
		$("#tab-content",parent.document).append(cHtml);
	}
}

//删除菜单页面
function removeTab(ele, code, event) {
	var aNodes = $(ele).parent().parent(".active");
	
	//判断当前是否为活动tab
	if(aNodes.length > 0){
		//自动锁定前一个tab
		$(ele).parent().parent("li").prev().addClass("active");
		$("#"+code).prev().addClass("in active");
		
		//去掉菜单活动样式
		var liNodes = $("#sidebar-menu li",parent.document);
		$.each(liNodes,function(){
			$(this).removeClass("active");
		});
	}
	
	//删除title
	$(ele).parent().parent("li").remove();
	//删除content
	$("#"+code,parent.document).remove();
	
	//阻止冒泡事件
	if(event.stopPropagation)event.stopPropagation();
	else event.cancelBubble=true;
}

function selectMenu(code) {
	var liNodes = $("#sidebar-menu li",parent.document);
	$.each(liNodes,function(){
		if(code == $(this).attr("data-code")) {
			$(this).addClass("active");
			$(this).parents(".open").addClass("active");
		}else {
			$(this).removeClass("active");
		}
	});
}

function sysToModal(url, modeId, subTitle) {
	$.ajax({
		url : url,
		type : 'POST',
		dataType : 'html',
		success : function(html) {
			var doms = $.parseHTML(html, true);
			$('#' + modeId + "Label").empty().append(subTitle);
			$('#' + modeId + "_modal_body").empty().append(doms);
			$('#' + modeId).modal('show');
		}
	});
}


/**
 * 序列化 表单数据
 */
$.fn.serializeJson = function() {
	var serializeObj = {}; // 转换目标对象
	var array = this.serializeArray(); // 先获取数组
	$(array).each(function() {
		if (serializeObj[this.name]) {
			if ($.isArray(serializeObj[this.name])) {
				serializeObj[this.name].push(this.value);
			} else {
				serializeObj[this.name] = [ serializeObj[this.name],this.value ];
			}
		} else {
			serializeObj[this.name] = this.value;
		}
	});
	return serializeObj;
};

/**
 * 日历图标触发事件
 * @param jq
 */
function dateclick(jq) {
	jq.datetimepicker('show');
}

/**
 * 多选择下来菜单查询
 */
var multiselect = {
		
	/**
	 * @param id 目标select的id
	 */
	selected : function(id) {
		$('#'+id).attr("multiple",true).multiselect({
			enableFiltering: true,
			maxHeight: 300,
			onChange: function(option, checked) {
				var selectedOptions = $('#'+id+' option:selected');
				if (selectedOptions.length >= 4) {
					var nonSelectedOptions = $('#'+id+' option').filter(function() {
						return !$(this).is(':selected');
					});

					var dropdown = $('#'+id).siblings('.multiselect-container');
					nonSelectedOptions.each(function() {
						var input = $('input[value="' + $(this).val() + '"]');
						input.prop('disabled', true);
						input.parent('li').addClass('disabled');
					});
				}
				else {
					var dropdown = $('#'+id).siblings('.multiselect-container');
					$('#'+id+' option').each(function() {
						var input = $('input[value="' + $(this).val() + '"]');
						input.prop('disabled', false);
						input.parent('li').addClass('disabled');
					});
				}
			},
			buttonText :function (options, selected) {
				if (options.length == 0) {
	                return '-- 请选择 --';
	            }else {
                    var labels = [];
                    options.each(function() {
                    	labels.push($(this).text());
                    });
                    return labels.join(', ') + '';
                }
			}
		});
	}
}

/**
 * 单选下来菜单
 */
var singleselect = {
	selected : function(id) {
		$("#"+id).multiselect({
			enableFiltering: true,
			maxHeight: 300
		});
	}
}

/**
 * 数组元素唯一，去重
 */
Array.prototype.unique = function() {
	this.sort();
	res = [this[0]];
	for(var i=1; i<this.length; i++) {
		if(this[i] != res[res.length-1]) {
			res.push(this[i]);
		}
	}
	return res;
}