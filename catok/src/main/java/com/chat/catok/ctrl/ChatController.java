package com.chat.catok.ctrl;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chat.catok.service.IChatService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class ChatController {

	private IChatService chatService;
	
	@PostMapping(value="/chatPopup.do")
	public String chatPopup(@RequestBody String friendId, Model model) {
		
		
		
		log.info("###넘어온 friendId : " + friendId);
		String subFriendId = friendId.substring(10);
		model.addAttribute("friendId",subFriendId);
		return "chatPopup";
	}
	
	
}
