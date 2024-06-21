package com.chat.catok.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.chat.catok.vo.FriendInfoVo;

@Mapper
public interface IFriendInfoDao {

	// 친구 리스트 조회
	public List<FriendInfoVo> getFriendList(String user_id);
	
	// 친구 상세정보
	public FriendInfoVo getOneFriendInfo(String user_id);
	
	// 친구 추가
	public int insertFriend(Map<String, Object> map);
}
