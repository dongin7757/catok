package com.chat.catok.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.chat.catok.vo.ChatInfoVo;
import com.chat.catok.vo.ChatRoomListVo;
import com.chat.catok.vo.ChatroomParticipateVo;
import com.chat.catok.vo.ChatroomVo;

@Repository
@Primary
public class ChatDaoImpl implements IChatDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.chat.catok.model.ChatDaoImpl.";
	
	//친구와의 1:1채팅방 조회
	@Override
	public String getChatRoomChatId(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"getChatRoomChatId", map);
	}
	
	//조회후 채팅방 정보 가져오기
	@Override
	public List<ChatInfoVo> getChatInfo(String chat_id) {
		return sqlSession.selectList(NS+"getChatInfo", chat_id);
	}
	
	// 1:1채팅방 생성
	@Override
	public int createNewChatRoom() {
		return sqlSession.insert(NS+"createNewChatRoom");
	}
	
	// 채팅방 인원 추가
	@Override
	public int createChatRoomInfo(List<String> user_ids) {
		return sqlSession.insert(NS+"createChatRoomInfo",user_ids);
	}

	//나의 채팅방 리스트 가져오기
	@Override
	public List<ChatRoomListVo> getMyChatRoomList(String user_id) {
		return sqlSession.selectList(NS+"getMyChatRoomList", user_id);
	}

	// 채팅내용 저장
	@Override
	public int insertChatMessage(Map<String, Object> map) {
		return sqlSession.insert(NS+"insertChatMessage", map);
	}
	
	// 1:N채팅방 생성
	@Override
	public int createNewGroupChatRoom(String chat_title) {
		return sqlSession.insert(NS+"createNewGroupChatRoom",chat_title);
	}

	// 생성된 그룹 채팅방 아이디 조회
	@Override
	public String selectGroupChatId() {
		return sqlSession.selectOne(NS+"selectGroupChatId");
	}

	//	그룹 채팅방에 속해있는지 확인용
	@Override
	public ChatroomParticipateVo checkMyGroupRoom(ChatroomParticipateVo vo) {
		return sqlSession.selectOne(NS+"checkMyGroupRoom", vo);
	}
	
	
	
}
