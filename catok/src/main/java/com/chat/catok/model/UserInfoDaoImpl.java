package com.chat.catok.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.chat.catok.vo.UserInfoVo;

@Repository
@Primary
public class UserInfoDaoImpl implements IUserInfoDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.chat.catok.model.UserInfoDaoImpl.";
	
	// 로그인
	@Override
	public UserInfoVo login(String id) {
		return sqlSession.selectOne(NS + "login", id);
	}

	// 회원가입
	@Override
	public int insertUserInfo(UserInfoVo vo) {
		return sqlSession.insert(NS + "insertUserInfo", vo);
	}

	// 전체 회원 조회
	@Override
	public List<UserInfoVo> getUserInfoAllList() {
		return sqlSession.selectList(NS + "getUserInfoAllList");
	}
	
	// 회원목록 검색
	@Override
	public List<UserInfoVo> searchUserInfoList(Map<String, Object> map) {
		return sqlSession.selectList(NS + "searchUserInfoList", map);
	}
}
