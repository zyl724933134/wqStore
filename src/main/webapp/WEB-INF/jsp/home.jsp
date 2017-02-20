<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/include/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>商家后台管理系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<%@ include file="/WEB-INF/include/common.jsp"%>
	</head>

	<body>
		<div class="navbar navbar-default" id="navbar">

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							移动后台管理系统
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="grey">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-tasks"></i>
								<span class="badge badge-grey">0</span>
							</a>

						</li>

						<li class="purple">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-bell-alt icon-animated-bell"></i>
								<span class="badge badge-important">0</span>
							</a>

						</li>

						<li class="green">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-envelope icon-animated-vertical"></i>
								<span class="badge badge-success">0</span>
							</a>

						</li>

						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="${ctx}/statics/assets/avatars/avatar2.png" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎光临,</small>
									${realName}
								</span>

								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="icon-cog"></i>
										设置
									</a>
								</li>

								<li>
									<a href="#" onclick="addTab(this)"  data-name='个人资料' data-code='user_profile' data-url='/admin/user/profile.do'>
										<i class="icon-user"></i>
										个人资料
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="${ctx}/admin/logout.do">
										<i class="icon-off"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		<div class="main-container" id="main-container">
			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<div class="sidebar-shortcuts" id="sidebar-shortcuts" hidden>
						<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
							<span class="input-icon">
								<input type="text" placeholder="Search ..." class="nav-search-input" id="search-input" />
								<i class="icon-search nav-search-icon"></i>
							</span>
 							<!--#nav-search -->
						</div>
						
						<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
							<i class="icon-search"></i>
						</div>
					</div><!-- #sidebar-shortcuts -->

					<ul class="nav nav-list" id="sidebar-menu">
						
					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

				</div>

				<div class="main-content">
					<div class="tabbable">
						<ul class="nav nav-tabs padding-12 background-blue" id="tab-title" >
							<li class="active" onclick="selectMenu('home')">
								<a data-toggle="tab" href="#home4">首页</a>
								
							</li>
						</ul>

						<div class="tab-content no-border" id="tab-content">
							<div id="home4" class="tab-pane in active">
								<div class="col-md-12">
									<p>Welcome ACE businessmen management system.</p>
									</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
									</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
								</div>
							</div>
						</div>
					
					</div>
					<div class="page-content">
						
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->

			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

</body>
</html>

<script type="text/javascript">
	$(function(){
		getMenu();
	});
	
	function getMenu() {
		var name = $("#search-input").val();
		$.ajax({
			url: "${ctx}/admin/home/loadMenu.do",
			type: "POST",
			dataType: "JSON",
			data:{"name":name},
			async:false,
			success: function(data) {
				//console.log(data);
				var menuHtml = loadMenu(data.result,false);
				//console.log(menuHtml);
				$("#sidebar-menu").empty().append(menuHtml);
			}
		});
		
	}
	
	function loadMenu(result,isChild) {
		var html = "";
		if(result&&result.length>0){
		
			$.each(result, function (n, node) {
				var menuHtml="";
				if(node.children.length>0) {
					if(isChild) {
						icon = "icon-double-angle-right";
					}else {
						icon = node.icons;
					}
					
					menuHtml +="<li><a href='#' class='dropdown-toggle'><i class='"+icon+"'></i><span class='menu-text'> "+node.name+" </span><b class='arrow icon-angle-down'></b></a>"
					
					menuHtml += "<ul class='submenu' style='display: none;'>"
					$.each(node.children,function(n,node){
						if(node.children!=null &&node.children.length>0) {
							menuHtml+=loadMenu(new Array(node),true);
						}else {
							menuHtml += "<li onclick='addTab(this)' data-url='"+node.url+"' data-code='"+node.code+"' data-name='"+node.name+"'>"
										+"<a href='#'><i class='icon-double-angle-right'></i><span class='menu-text'> "+node.name+"</span></a></li>"
						}
					});
					menuHtml += "</ul>"
					
					menuHtml += "</li>"
				}else {
					menuHtml += "<li onclick='addTab(this)' data-url='"+node.url+"' data-code='"+node.code+"' data-name='"+node.name+"'>"
								+"<a href='#'><i class='icon-dashboard'></i><span class='menu-text'> "+node.name+"</span></a></li>"
				}
				html +=menuHtml;
				
			});
		}
		return html;
	}
	
	
</script>

