package com.chat.catok.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chat.catok.vo.ChatroomVo;

@Mapper
public interface IChatDao {
	
	//1:1채팅방 생성
	public int createNewChatRoom();
	
	//채팅방 인원 추가
	public int createChatRoomInfo(String user_id);
	
	//나의 채팅방 리스트 가져오기
	public List<ChatroomVo> getMyChatRoomList(String user_id);
	
}
