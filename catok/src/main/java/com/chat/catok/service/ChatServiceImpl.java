package com.chat.catok.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chat.catok.model.IChatDao;
import com.chat.catok.vo.ChatroomVo;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ChatServiceImpl implements IChatService {

	private IChatDao dao;
	
	//1:1채팅방 생성
	@Override
	public int createNewChatRoom() {
		log.info("새로운 채팅창 만들기 ");
		return dao.createNewChatRoom();
	}
	
	//채팅방 인원 추가
	@Override
	public int createChatRoomInfo(String user_id) {
		log.info("새로운 채팅창 만들기 : {}", user_id);
		
		
		return dao.createChatRoomInfo(user_id);
	}
	
	//나의 채팅방 리스트 가져오기
	@Override
	public List<ChatroomVo> getMyChatRoomList(String user_id) {
		log.info("내가 포함된 채팅방 가져오기 : {}", user_id);
		return dao.getMyChatRoomList(user_id);
	}
	
}
