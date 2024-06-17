package com.chat.catok.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chat.catok.service.IFriendInfoService;
import com.chat.catok.vo.FriendInfoVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FriendInfoController {

	@Autowired
	private IFriendInfoService service;

	@GetMapping(value = "/myFriendsList.do")
	public String getFriendList(@AuthenticationPrincipal UserDetails userDetails, Model model) {

		if (userDetails != null) {
			String user_id = userDetails.getUsername();
			log.info("현재 사용자의 아이디: {}", user_id);
			List<FriendInfoVo> friends = service.getFriendList(user_id);

			model.addAttribute("friends", friends);
		}
		
		return "myfriendsList";

	}

}
