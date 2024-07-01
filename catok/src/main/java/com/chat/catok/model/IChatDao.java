package com.chat.catok.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.chat.catok.vo.ChatInfoVo;
import com.chat.catok.vo.ChatRoomListVo;
import com.chat.catok.vo.ChatroomVo;

@Mapper
public interface IChatDao {
	
	//친구와의 1:1채팅방 조회
	public String getChatRoomChatId(Map<String, Object> map);
	
	//조회후 채팅방 정보 가져오기
	public List<ChatInfoVo> getChatInfo(String chat_id);
	
	//1:1채팅방 생성
	public int createNewChatRoom();
	
	//채팅방 생성 후 인원 추가
	public int createChatRoomInfo(List<String> user_ids);
	
	//나의 채팅방 리스트 가져오기
	public List<ChatRoomListVo> getMyChatRoomList(String user_id);
	
	// 채팅내용 저장
	public int insertChatMessage(Map<String, Object> map);
	
}
