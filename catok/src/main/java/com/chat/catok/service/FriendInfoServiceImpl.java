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
	
	// 친구 삭제
	@Override
	public int deleteFriend(Map<String, Object> map) {
		return dao.deleteFriend(map);
	}
	
	//내가 친구를 승인하지 않은 친구신청을 한 유저들의 리스트
	@Override
	public List<FriendInfoVo> getFriendsReqList(String user_id) {
		return dao.getFriendsReqList(user_id);
	}

	//친구 차단!
	@Override
	public int blockFriend(Map<String, Object> map) {
		
//		dao.
		
		return 0;
	}
	
	
	
}
