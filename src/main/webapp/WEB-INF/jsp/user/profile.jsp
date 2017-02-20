<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tag.jsp"%>
<%@ include file="/WEB-INF/include/common.jsp"%>

<link rel="stylesheet" href="${ctx}/statics/css/custom_theme.css" />

	<div class="row">
		<div id="user-profile-2" class="user-profile">
			<div class="tabbable">
				<ul class="nav nav-tabs padding-18">
					<li class="active">
						<a data-toggle="tab" href="#home">
							<i class="purple icon-user bigger-125"></i>
							个人简介
						</a>
					</li>

					<li>
						<a data-toggle="tab" href="#edit-basic">
							<i class="green icon-edit bigger-125"></i>
							修改信息
						</a>
						
					</li>
					<li>
						<a data-toggle="tab" href="#edit-password">
							<i class="blue icon-key bigger-125"></i>
							修改密码
						</a>
					</li>
				</ul>

				<div class="tab-content no-border padding-24">
					<div id="home" class="tab-pane in active">
						<div class="row">
							<div class="col-md-2 center">
								<span class="profile-picture">
									<img class="editable img-responsive" width="100" alt="头像" src="${user.avatar}" />
								</span>

								<div class="space space-4"></div>
							</div><!-- /span -->

							<div class="col-md-9">
								<h4 class="blue">
									<span class="middle">${user.realName}</span>

									<span class="label label-purple arrowed-in-right">
										<i class="icon-circle smaller-80 align-middle"></i>
										<c:if test="${user.isAdmin == false}">
											普通用户
										</c:if>
										<c:if test="${user.isAdmin == true}">
											管理员
										</c:if>
									</span>
								</h4>

								<div class="profile-user-info">
									<div class="profile-info-row">
										<div class="profile-info-name">用户名 </div>

										<div class="profile-info-value">
											<span>${user.loginName} </span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name"> 邮箱地址 </div>
										<div class="profile-info-value">
											<span>${user.email} &nbsp;</span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name"> 联系方式 </div>

										<div class="profile-info-value">
											<span>${user.phoneNum} &nbsp;</span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name"> 姓名 </div>

										<div class="profile-info-value">
											<span>${user.realName} &nbsp;</span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name"> 最近更新</div>

										<div class="profile-info-value">
											<span>${user.modifiedTime} &nbsp;</span>
										</div>
									</div>
								</div>

								<div class="hr hr-8 dotted"></div>
							</div><!-- /span -->
						</div><!-- /row-fluid -->

						<div class="space-20"></div>
					</div><!-- #home -->
					
					<!-- edit-basic -->
					<div id="edit-basic" class="tab-pane">
						<h4 class="header blue bolder smaller">基本信息</h4>
						<form class="form-horizontal" id="edit_user_form">
							<input type="hidden" name="id" value="${user.id}"/>
							<div class="form-group">
								<label class="col-md-3 control-label no-padding-right" >姓名</label>
								<div class="col-md-9">
									<input type="text" name="realName" value="${user.realName}"/>
								</div>
							</div>
							
							<div class="space-4"></div>
							
							<div class="form-group">
								<label class="col-md-3 control-label no-padding-right" >头像</label>
								<div class="col-md-9">
									<input type="file" name="avatarFile"/>
								</div>
							</div>
							
							<div class="space-4"></div>
							
							<div class="form-group">
								<label class="col-md-3 control-label no-padding-right" >邮箱</label>
	
								<div class="col-md-9">
									<span class="input-icon input-icon-right">
										<input type="email" name="email" value="${user.email}"/>
										<i class="icon-envelope"></i>
									</span>
								</div>
							</div>
	
							<div class="space-4"></div>
	
							<div class="form-group">
								<label class="col-md-3 control-label no-padding-right" for="form-field-phone">手机号</label>
	
								<div class="col-md-9">
									<span class="input-icon input-icon-right">
										<input type="text" name="phoneNum" value="${user.phoneNum}"/>
										<i class="icon-phone icon-flip-horizontal"></i>
									</span>
								</div>
							</div>
	
							<div class="space"></div>
	
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<button class="btn btn-sm btn-info" type="button" id="saveUserBtn">
										<i class="icon-ok bigger-110"></i>
										保存
									</button>
		
									&nbsp; &nbsp;
									<button class="btn btn-sm" type="reset">
										<i class="icon-undo bigger-110"></i>
										重置
									</button>
								</div>
							</div>
						</form>
					</div>
					
					<!-- edit-password  -->
					<div id="edit-password" class="tab-pane">
						<h4 class="header blue bolder smaller">修改密码</h4>
						<form class="form-horizontal" id="reset_password_form">
							<div class="form-group">
								<label class="col-md-3 control-label no-padding-right" >旧密码</label>
								<div class="col-md-9">
									<input type="password" name="oldPassword" id="oldPassword" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label no-padding-right" >密码</label>
								<div class="col-md-9">
									<input type="password" name="password" id="password" />
								</div>
							</div>
							
							<div class="space-4"></div>
							
							<div class="form-group">
								<label class="col-md-3 control-label no-padding-right" >确认密码</label>
								<div class="col-md-9">
									<input type="password" name="rePassword" id="rePassword"/>
								</div>
							</div>
							
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<button class="btn btn-sm btn-info" type="button" id="savePsdBtn">
										<i class="icon-ok bigger-110"></i>
										保存
									</button>
									&nbsp; &nbsp;
									<button class="btn btn-sm" type="reset">
										<i class="icon-undo bigger-110"></i>
										重置
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
	
	
	
	//修改用户信息
	$("#edit_user_form").validate({
		rules: {
			realName:{required:true},
			email:{required:true, email: true},
			phoneNum:{required:true, minlength : 11,isMobile:true}
		},
		messages : {
			realName:{required:"请输入真实姓名"},
			email:{required:"请输入邮箱地址",email:"邮箱格式不正确"},
			phoneNum:{required:"请输入手机号", minlength : "手机号不能小于11位",}
		},
		errorPlacement: function(error, element) {
			if($(element).next().length > 0) {
				error.appendTo(element.parent().parent());
			}else {
				error.appendTo(element.parent());
			}
		},
		submitHandler: function(form) {
			$("#saveUserBtn").prop("disabled",true);
			$(form).ajaxSubmit({
				type:"post",
				dataType:"json",
				url:"${ctx}/admin/user/saveOrUpdate.do",
				success:function(data){
					if(data.success){
						alert("修改成功！");
						$("#edit_user_form")[0].reset();
					}else{
						alert(data.errorMessage);
					}
					$("#saveUserBtn").prop("disabled",false);
	            }  
	        });
		}
	});
	
	
	//提交用户信息
	$("#saveUserBtn").on('click',function(){
		$("#edit_user_form").submit();
	});
	
	
	
	//修改密码
	$("#reset_password_form").validate({
		rules: {
			password:{required:true,maxlength:16},
			rePassword:{required:true, equalTo: "#password"}
		},
		messages : {
			password:{required:"输入新密码",maxlength:"最大长度16"},
			rePassword:{required:"确认新密码",equalTo:"两次密码不一致"},
		},
		submitHandler: function(form) {
			$("#savePsdBtn").prop("disabled",true);
			$(form).ajaxSubmit({
				type:"post",
				dataType:"json",
				url:"${ctx}/admin/user/updatePassword.do",
				success:function(data){
					if(data.success){
						alert("密码修改成功！");
						$("#reset_password_form")[0].reset();
					}else{
						alert(data.errorMessage);
					}
					$("#savePsdBtn").prop("disabled",false);
	            }  
	        });
		}
	});
	
	//提交用户密码
	$("#savePsdBtn").on('click',function(){
		$("#reset_password_form").submit();
	});
	
	
	// 手机号码验证
	jQuery.validator.addMethod("isMobile", function(value, element) {
	    var length = value.length;
	    var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
	    return this.optional(element) || (length == 11 && mobile.test(value));
	}, "请输入正确的手机号码");
	

</script>

