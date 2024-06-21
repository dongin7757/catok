package com.chat.catok.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.chat.catok.vo.FriendInfoVo;

@Repository
@Primary
public class FriendInfoDaoImpl implements IFriendInfoDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.chat.catok.model.FriendInfoDaoImpl.";
	
	// 친구 리스트 조회
	@Override
	public List<FriendInfoVo> getFriendList(String user_id) {
		return sqlSession.selectList(NS+"getFriendList",user_id);
	}

	// 친구 상세정보
	@Override
	public FriendInfoVo getOneFriendInfo(String user_id) {
		return sqlSession.selectOne(NS+"getOneFriendInfo",user_id);
	}
	
	// 친구 추가
	@Override
	public int insertFriend(Map<String, Object> map) {
		return sqlSession.insert(NS+"insertFriend",map);
	}
}
