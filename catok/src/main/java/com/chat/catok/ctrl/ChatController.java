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

import com.chat.catok.service.IChatService;
import com.chat.catok.vo.ChatInfoVo;
import com.chat.catok.vo.ChatRoomListVo;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class ChatController {

	@Autowired
	private IChatService chatService;
	
//	친구와 1:1 채팅 방생성 또는 불러오기
	@PostMapping("/chatPopup.do")
	public String chatPopup(@RequestBody String friendId, Model model, @AuthenticationPrincipal UserDetails userDetails) {
		
		log.info("###넘어온 friendId : " + friendId);
		String subFriendId = friendId.substring(10);
		model.addAttribute("friendId",subFriendId);
		
		Map<String, Object> map = new HashMap<>(); 	
		
		String my_id = userDetails.getUsername();
		map.put("my_id", my_id);
		map.put("friend_id", subFriendId);
		
		List<String> users = new ArrayList<String>();
		users.add(my_id);
		users.add(subFriendId);
		
		String chat_id = chatService.getChatRoomChatId(map);
		log.info("####조회된 채팅방 번호 : {}", chat_id);
		if(chat_id != null) {
			List<ChatInfoVo> chattings = chatService.getChatInfo(chat_id);
			model.addAttribute("chattings",chattings);
			model.addAttribute("myId",my_id);
			model.addAttribute("chatId",chat_id);
		}else {
			chatService.createNewChatRoomAndInfo(users);
		}
		return "chatPopup";
	}
	
	@GetMapping("/myChatRoomList.do")
	public String myChatRoomList(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		List<ChatRoomListVo> rooms = chatService.getMyChatRoomList(userDetails.getUsername());
		log.info("####쿼리 실행 후 가져온 리스트 : {}", rooms.toString());
		model.addAttribute("rooms",rooms);
		return "user/myChatRoomList";
	}
	
	@PostMapping("/insertChatMessage.do")
	@ResponseBody
	public int insertChatMessage(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Map<String,Object> map) {
		String chat_id = (String) map.get("chat_id");
		String user_id = (String) map.get("user_id");
		String chat_message = (String) map.get("chat_message");
		
		log.info("####chat_id : " + chat_id);
		log.info("####user_id : " + user_id);
		log.info("####chat_message : " + chat_message);
		int insertChatMsg = 0;
		try {
			insertChatMsg = chatService.insertChatMessage(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (insertChatMsg > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	@GetMapping("/catok")
	public String chatGET() {
		log.info("##챗팅Get");
		return "chater";
	}
	
	
	

	
	
}
