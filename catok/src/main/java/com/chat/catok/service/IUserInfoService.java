package com.chat.catok.service;

import java.util.List;
import java.util.Map;

import com.chat.catok.vo.UserInfoVo;

public interface IUserInfoService {

	// 로그인
	public UserInfoVo login(String id);
	
	// 회원가입
	public int insertUserInfo(UserInfoVo vo);
	
	// 전체 회원 조회
	public List<UserInfoVo> getUserInfoAllList();
	
	// 회원목록 검색
	public List<UserInfoVo> searchUserInfoList(Map<String, Object> map);
}
