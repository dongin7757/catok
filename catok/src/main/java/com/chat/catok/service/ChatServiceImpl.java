package com.chat.catok.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chat.catok.model.IChatDao;
import com.chat.catok.vo.ChatInfoVo;
import com.chat.catok.vo.ChatRoomListVo;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ChatServiceImpl implements IChatService {

	@Autowired
	private IChatDao dao;
	
	
	// 친구와의 1:1채팅방 조회
	@Override
	public String getChatRoomChatId(Map<String, Object> map) {
		log.info("#####친구와의 방 찾기 내 아디 : {}, 친구 아디 : {}", map.get("my_id"), map.get("friend_id"));
		
		String roomId = dao.getChatRoomChatId(map);
		return roomId;
	}

	// 방 조회 후 존재 시 채팅방 내역 가져오기
	@Override
	public List<ChatInfoVo> getChatInfo(String chat_id) {
		List<ChatInfoVo> chattings = dao.getChatInfo(chat_id);
		return chattings;
	}
	
	
	// 방 조회 후 없을 시 1:1채팅방 생성
	@Override
	@Transactional
	public int createNewChatRoomAndInfo(List<String> user_ids) {
		int roomOk = dao.createNewChatRoom(); // 방이 생성되었을 경우
		int peopleOk = dao.createChatRoomInfo(user_ids); // 이용자 정보를 채팅방번호에 다 넣었을 경우
		
		log.info("####방 생성 여부 : {}, 인원 추가 여부 : {}", roomOk, peopleOk);
		return roomOk + peopleOk;
	}
//	
//	// 채팅방 인원 추가
//	@Override
//	public int createChatRoomInfo(String user_id) {
//		log.info("새로운 채팅창 만들기 : {}", user_id);
//		
//		
//		return dao.createChatRoomInfo(user_id);
//	}
//	

	
	// 나의 채팅방 리스트 가져오기
	@Override
	public List<ChatRoomListVo> getMyChatRoomList(String user_id) {
		log.info("#### 나의 아이디가 속한 채팅방 조회~ : {}", user_id);
		return dao.getMyChatRoomList(user_id);
	}

	// 채팅내용 저장
	@Override
	public int insertChatMessage(Map<String, Object> map) {
		log.info("#### 채팅내용 저장 : ", map);
		return dao.insertChatMessage(map);
	}
	
	// 1:N채팅방 생성
	@Override
	@Transactional
	public int createNewGroupChatRoom(List<String> user_ids) {
		int roomOk = dao.createNewGroupChatRoom(); // 방이 생성되었을 경우
		int peopleOk = dao.createChatRoomInfo(user_ids); // 이용자 정보를 채팅방번호에 다 넣었을 경우
		
		log.info("####방 생성 여부 : {}, 인원 추가 여부 : {}", roomOk, peopleOk);
		return roomOk + peopleOk;
	}
	
}
