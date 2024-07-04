package com.chat.catok.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chat.catok.service.IFriendInfoService;
import com.chat.catok.service.IUserInfoService;
import com.chat.catok.vo.FriendInfoVo;
import com.chat.catok.vo.UserInfoVo;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
public class FriendInfoController {
	
	@Autowired
	private IUserInfoService iUserInfoService;

	@Autowired
	private IFriendInfoService iFriendInfoService;

	@GetMapping("/myFriendsList.do")
	public String getFriendList(@AuthenticationPrincipal UserDetails userDetails, Model model) {

		if (userDetails != null) {
			String user_id = userDetails.getUsername();
			log.info("현재 사용자의 아이디: {}", user_id);
			List<FriendInfoVo> friends = iFriendInfoService.getFriendList(user_id);
			model.addAttribute("friends",friends);
		}
		return "myfriendsList";
	}
	
//	친구 리스트 아작스로 불러오기
	
	@GetMapping("/getMyFriList.do")
	@ResponseBody
	public List<FriendInfoVo> getMyFriList(@AuthenticationPrincipal UserDetails userDetails) {
		
		List<FriendInfoVo> friends = new ArrayList<>();
		
		if(userDetails != null) {
			String user_id = userDetails.getUsername();
			log.info("##영태의 아이디 : "  + user_id);
			friends = iFriendInfoService.getFriendList(user_id);
			log.info("##영태 friends : " + friends);
		}
		return friends;
	}
	
	// 친구추가 페이지 이동
	@GetMapping("/moveFriendPg.do")
	public String moveFriendPg(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		String myId = userDetails.getUsername();
		log.info("###myId : " + myId);
		Map<String, Object> map = new HashMap<>();
		map.put("myId", myId);
		log.info("###map : " + map);
		List<UserInfoVo> members = iUserInfoService.searchUserInfoList(map);
		model.addAttribute("members", members);
		return "user/addFriend";
	}
	
	
	// 회원 검색
	@PostMapping("/searchFriendsInfo.do")
	@ResponseBody
	public List<UserInfoVo> searchFriendsInfo(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Map<String,Object> map) {
	    String user_id = (String) map.get("user_id");
	    String user_name = (String) map.get("user_name");
	    log.info("##user_id : " + user_id);
	    log.info("##user_name : " + user_name);
	    String myId = userDetails.getUsername();
	    map.put("myId", myId);
	    
	    if(user_id != null && !user_id.isEmpty()) {
	        map.put("user_id", user_id);
	    }
	    if(user_name != null && !user_name.isEmpty()) {
	        map.put("user_name", user_name);
	    }
	    
	    List<UserInfoVo> searchFriendsList = new ArrayList<>();
	    try {
	        searchFriendsList = iUserInfoService.searchUserInfoList(map);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    for(UserInfoVo sch : searchFriendsList) {
	    	System.out.println("@@@@@@@ : " + sch);
	    }
	    return searchFriendsList;
	}
	
	// 친구추가
	@PostMapping("/addFriend.do")
	@ResponseBody
	public Map<String, String> addFriend(@RequestBody Map<String,Object> map, @AuthenticationPrincipal UserDetails userDetail) {
		String user_id = userDetail.getUsername();
	    String friend_id = (String) map.get("friend_id");
	    map.put("user_id", user_id);
	    map.put("friend_id", friend_id);
		log.info("###user_id : " + user_id);
		log.info("###friend_id : " + friend_id);
		int addFriend = iFriendInfoService.insertFriend(map);
		Map<String, String> response = new HashMap<>();
	    response.put("friend_id", friend_id);
	    return response;
	}
	
	// 친구삭제
	@PostMapping("/deleteFriend.do")
	@ResponseBody
	public Map<String, String> deleteFriend(@RequestBody Map<String,Object> map, @AuthenticationPrincipal UserDetails userDetail) {
		String user_id = userDetail.getUsername();
	    String friend_id = (String) map.get("friend_id");
	    map.put("user_id", user_id);
	    map.put("friend_id", friend_id);
		log.info("###user_id : " + user_id);
		log.info("###friend_id : " + friend_id);
		int deleteFriend = iFriendInfoService.deleteFriend(map);
		Map<String, String> response = new HashMap<>();
	    response.put("friend_id", friend_id);
	    return response;
	} 
	
	//내가 친구를 승인하지 않은 친구신청을 한 유저들의 리스트
	@GetMapping("/getFriendsReqList.do")
	public String getMethodName(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		String user_id = userDetails.getUsername();
		List<FriendInfoVo> reqList = iFriendInfoService.getFriendsReqList(user_id);
		model.addAttribute("reqList", reqList);
		return "user/friendReqList";
	}
	
}
