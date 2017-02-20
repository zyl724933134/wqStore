package com.wqstore.service;

import java.util.List;

import javax.xml.transform.Result;

import com.wqstore.domain.Address;
import com.wqstore.domain.EndUser;
import com.wqstore.result.PageParam;
import com.wqstore.result.RequestPageVo;
import com.wqstore.result.RequestResultVo;

public interface EndUserService {
	
	/**
	 * 登录用户
	 * @param user
	 * @return
	 */
	Result loginUser(String phone,String password,String signature);
	
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	Result insertUser(String phone,String password,String code);
	
	/**
	 * 发送短信验证码
	 * @return
	 */
	Result sendSms(String phone);
	
	/**
	 * 修改密码
	 * @return
	 */
	Result updatePassword(EndUser endUser,String oldPassword,String newPassword);
	
	/**
	 * 找回密码
	 * @return
	 */
	Result getPassword(String phone,String newPassword,String code);
	/**
	 * 注册校验
	 * @param code
	 * @return
	 */
	Result smsVerify(String phone, String code);
	
	/**
	 * 找回校验
	 * @param code
	 * @return
	 */
	Result sendBackSms(String phone);
	
	/**
	 * phone 找回首次校验
	 * @param code
	 * @return
	 */
	Result smsFirstVerify(String phone, String code);
	
	/**
	 * ut验证
	 */
	Result userTokenVerify(String userToken);
	/**
	 * aut验证
	 * @param aut
	 * @return
	 */
	Result autoUserTokenVerify(String autoUserToken);
	/**
	 * 注销用户
	 * @param ut
	 * @return
	 */
	Result userLogout(String userToken,String signature,Long userId);

	/**
	 * 分页查询商城用户列表
	 * @param endUser
	 * @param param
	 * @return
	 */
	RequestPageVo<EndUser> findEndUserList(EndUser endUser, PageParam param);

	/**
	 * 获取用户收获地址信息
	 * @param endUserAddressId
	 * @return
	 */ 
	RequestResultVo<List<Address>> getEndUserAddress(Long endUserId);
	

	/**
	 * 根据id获取用户
	 * @param id
	 * @return
	 */
	EndUser findEndUserById(Long id);
}
