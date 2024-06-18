package com.chat.catok.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.chat.catok.vo.ChatroomVo;

@Repository
@Primary
public class ChatDaoImpl implements IChatDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.chat.catok.model.ChatDaoImpl.";
	
	// 1:1채팅방 생성
	@Override
	public int createNewChatRoom() {
		return sqlSession.insert(NS+"createNewChatRoom");
	}
	
	// 채팅방 인원 추가
	@Override
	public int createChatRoomInfo(String user_id) {
		return sqlSession.insert(NS+"createChatRoomInfo",user_id);
	}

	//나의 채팅방 리스트 가져오기
	@Override
	public List<ChatroomVo> getMyChatRoomList(String user_id) {
		return sqlSession.selectList(NS+"getMyChatRoomList",user_id);
	}



}
