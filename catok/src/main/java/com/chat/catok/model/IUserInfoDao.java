package com.chat.catok.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.chat.catok.vo.UserInfoVo;

@Mapper
public interface IUserInfoDao {
	
	// 로그인
	public UserInfoVo login(String id);
	
	// 회원가입
	public int insertUserInfo(UserInfoVo vo);
	
	// 전체 회원 조회
	public List<UserInfoVo> getUserInfoAllList();
	
}
