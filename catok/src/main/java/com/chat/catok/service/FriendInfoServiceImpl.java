package com.chat.catok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.catok.model.IFriendInfoDao;
import com.chat.catok.vo.FriendInfoVo;
@Service
public class FriendInfoServiceImpl implements IFriendInfoService {

	@Autowired
	private IFriendInfoDao dao;
	
	@Override
	public List<FriendInfoVo> getFriendList(String user_id) {
		return dao.getFriendList(user_id);
	}

	@Override
	public FriendInfoVo getOneFriendInfo(String user_id) {
		return dao.getOneFriendInfo(user_id);
	}

}
