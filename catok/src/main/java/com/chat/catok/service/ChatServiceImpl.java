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
	
	@Override
	public int createNewChatRoom() {
		log.info("새로운 채팅창 만들기 ");
		return dao.createNewChatRoom();
	}

	@Override
	public List<ChatroomVo> getMyChatRoomList(String user_id) {
		log.info("내가 포함된 채팅방 가져오기 : {}", user_id);
		return dao.getMyChatRoomList(user_id);
	}

}
