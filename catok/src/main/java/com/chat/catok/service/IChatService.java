package com.chat.catok.service;

import java.util.List;
import java.util.Map;

import com.chat.catok.vo.ChatInfoVo;
import com.chat.catok.vo.ChatRoomListVo;
import com.chat.catok.vo.ChatroomVo;

public interface IChatService {

	//친구와의 1:1채팅방 조회
	public String getChatRoomChatId(Map<String, Object> map);
	
	//방 조회 후 존재 시 채팅방 내역 가져오기
	public List<ChatInfoVo> getChatInfo(String chat_id);
	
	//1:1채팅방 생성후, 방에 인원 추가
	public int createNewChatRoomAndInfo(List<String> user_ids);
		
//	//채팅방 인원 추가
//	public int createChatRoomInfo(String user_id);
	
	//나의 채팅방 리스트 가져오기
	public List<ChatRoomListVo> getMyChatRoomList(String user_id);
	
		
}
