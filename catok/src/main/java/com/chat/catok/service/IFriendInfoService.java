package com.chat.catok.service;

import java.util.List;
import java.util.Map;

import com.chat.catok.vo.FriendInfoVo;

public interface IFriendInfoService {
	
	//친구 리스트 조회
	public List<FriendInfoVo> getFriendList(String user_id);
	
	//친구 상세정보
	public FriendInfoVo getOneFriendInfo(String user_id);
	
	// 친구 추가
	public int insertFriend(Map<String, Object> map);
		
	// 친구 삭제
	public int deleteFriend(Map<String, Object> map);
	
	//내가 친구를 승인하지 않은 친구신청을 한 유저들의 리스트
	public List<FriendInfoVo> getFriendsReqList(String user_id);
	
	//친구 차단!
	public int blockFriend(Map<String, Object> map);
}
