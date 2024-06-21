package com.chat.catok.ctrl;

import java.util.ArrayList;
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
	
	// 친구추가 페이지 이동
	@GetMapping("/addFriend.do")
	public String addFriend(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		return "user/addFriend";
	}
	
	// 회원 검색
	@PostMapping("/searchFriendsInfo.do")
	@ResponseBody
	public List<UserInfoVo> searchFriendsInfo(@RequestBody Map<String,Object> map) {
	    String user_id = (String) map.get("user_id");
	    String user_name = (String) map.get("user_name");
	    log.info("##user_id : " + user_id);
	    log.info("##user_name : " + user_name);
	    
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
}
