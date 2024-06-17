package com.chat.catok.service;

import java.util.List;

import com.chat.catok.vo.ChatroomVo;

public interface IChatService {

	//1:1채팅방 생성
	public int createNewChatRoom();
		
	//나의 채팅방 리스트 가져오기
	public List<ChatroomVo> getMyChatRoomList(String user_id);
		
}
