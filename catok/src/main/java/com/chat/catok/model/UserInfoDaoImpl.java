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
	
	@Override
	public UserInfoVo login(String id) {
		return sqlSession.selectOne(NS + "login", id);
	}

	@Override
	public int insertUserInfo(UserInfoVo vo) {
		return sqlSession.insert(NS + "insertUserInfo", vo);
	}

	@Override
	public List<UserInfoVo> getUserInfoAllList() {
		return null;
	}

}
