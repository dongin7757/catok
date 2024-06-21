package com.chat.catok.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.catok.model.IFriendInfoDao;
import com.chat.catok.vo.FriendInfoVo;
@Service
public class FriendInfoServiceImpl implements IFriendInfoService {

	@Autowired
	private IFriendInfoDao dao;
	
	// 친구 리스트 조회
	@Override
	public List<FriendInfoVo> getFriendList(String user_id) {
		return dao.getFriendList(user_id);
	}

	// 친구 상세정보
	@Override
	public FriendInfoVo getOneFriendInfo(String user_id) {
		return dao.getOneFriendInfo(user_id);
	}

	// 친구 추가
	@Override
	public int insertFriend(Map<String, Object> map) {
		return dao.insertFriend(map);
	}
}
