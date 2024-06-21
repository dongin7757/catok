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
	
	// 로그인
	@Override
	public UserInfoVo login(String id) {
		return dao.login(id);
	}

	// 회원가입
	@Override
	public int insertUserInfo(UserInfoVo vo) {
		return dao.insertUserInfo(vo);
	}

	// 전체 회원 조회
	@Override
	public List<UserInfoVo> getUserInfoAllList() {
		return dao.getUserInfoAllList();
	}
	
	// 회원목록 검색
	@Override
	public List<UserInfoVo> searchUserInfoList(Map<String, Object> map) {
		return dao.searchUserInfoList(map);
	}
}
