package com.chat.catok.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.catok.model.IUserInfoDao;
import com.chat.catok.vo.UserInfoVo;


@Service
public class UserInfoServiceImpl implements IUserInfoService {

	@Autowired
	private IUserInfoDao dao;
	
	@Override
	public UserInfoVo login(String id) {
		return dao.login(id);
	}

	@Override
	public int insertUserInfo(UserInfoVo vo) {
		return dao.insertUserInfo(vo);
	}

	@Override
	public List<UserInfoVo> getUserInfoAllList() {
		return dao.getUserInfoAllList();
	}

}
