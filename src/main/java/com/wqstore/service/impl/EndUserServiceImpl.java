package com.wqstore.service.impl;

import java.util.List;

import javax.xml.transform.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wqstore.domain.Address;
import com.wqstore.domain.EndUser;
import com.wqstore.result.PageParam;
import com.wqstore.result.RequestPageVo;
import com.wqstore.result.RequestResultVo;
import com.wqstore.service.EndUserService;

@Service("endUserService")
public class EndUserServiceImpl implements EndUserService {
	
	private static final Logger logger = LoggerFactory.getLogger(EndUserServiceImpl.class);

	private static final int REDIS_INVALID_TIME_MINUTE_60 = 60*60;
	private static final int REDIS_INVALID_TIME_MINUTE_30 = 60*30;
	private static final int DIFF_TIME_MIN = 10;
	private static final int DIFF_TIME_DAY = 15;
	
	private static final String VERIFICATION_CODE_KEY = "verification_code_key_%s";

	@Override
	public Result loginUser(String phone, String password, String signature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result insertUser(String phone, String password, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result sendSms(String phone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updatePassword(EndUser endUser, String oldPassword,
			String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getPassword(String phone, String newPassword, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result smsVerify(String phone, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result sendBackSms(String phone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result smsFirstVerify(String phone, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result userTokenVerify(String userToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result autoUserTokenVerify(String autoUserToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result userLogout(String userToken, String signature, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestPageVo<EndUser> findEndUserList(EndUser endUser,
			PageParam param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestResultVo<List<Address>> getEndUserAddress(Long endUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EndUser findEndUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
