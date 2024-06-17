package com.chat.catok.service;

import java.util.List;

import com.chat.catok.vo.FriendInfoVo;

public interface IFriendInfoService {

	//친구 리스트 조회
		public List<FriendInfoVo> getFriendList(String user_id);
		
		//친구 상세정보
		public FriendInfoVo getOneFriendInfo(String user_id);
		
}
