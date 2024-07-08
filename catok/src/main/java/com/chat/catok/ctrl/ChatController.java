package com.chat.catok.ctrl;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestParam;
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
		
		
		//친구와 나의 방이 존재하는데 조회하는데 사용될 매개변수들
		Map<String, Object> map = new HashMap<>(); 	
		
		String my_id = userDetails.getUsername();
		map.put("my_id", my_id);
		map.put("friend_id", subFriendId);

		
		//방이 없을 시 새로 생성하는데 쓰일 매개변수들 
		List<String> users = new ArrayList<String>();
		users.add(my_id);
		users.add(subFriendId);
		
		//나와 친구의 아이디로 방 존재 조회
		String chat_id = chatService.getChatRoomChatId(map);
		log.info("####조회된 채팅방 번호 : {}", chat_id);
		
		//방이 존재할 시 실행 기존 채팅방의 내역들을 가져옴.
		if(chat_id != null) {
			List<ChatInfoVo> chattings = chatService.getChatInfo(chat_id);
			log.info("######가져온 채팅 내역 : {}",chattings);
			model.addAttribute("chattings",chattings);
			model.addAttribute("myId",my_id);
			model.addAttribute("chatId",chat_id);
			
		//방이 존재하지 않을 시 실행 새로 채팅방을 생성함
		}else {
			chatService.createNewChatRoomAndInfo(users);
			//생성 후 생성한 방의 번호 가져오기
			chat_id = chatService.getChatRoomChatId(map);
			log.info("####새로 생성후, 가져온 채팅방 번호 : {}", chat_id);
			model.addAttribute("myId",my_id);
			model.addAttribute("chatId",chat_id);
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
	
	@PostMapping("/inviteFriendsToChatroom.do")
	@ResponseBody
	public String inviteFriendsToChatroom(@AuthenticationPrincipal UserDetails userDetail, @RequestBody List<String> friendList, Model model) {
		log.info("#### friendList : " + friendList);
		
		String GroupChatroomId = chatService.createNewGroupChatRoom(friendList);
		
		if(GroupChatroomId.equals(null) || GroupChatroomId.equals("")) {
			return "errorPg";
		} else {
			return "./groupChatPopup.do?groupChatroomId=" + GroupChatroomId;
		}
	}
	
	@GetMapping("/groupChatPopup.do") 
	public String groupChatPopup(@AuthenticationPrincipal UserDetails userDetail, @RequestParam("groupChatroomId") String groupChatroomId,  Model model) {
		String myId = userDetail.getUsername();
		model.addAttribute("myId", myId);
		model.addAttribute("groupChatroomId", groupChatroomId);
		if(groupChatroomId != null) {
			List<ChatInfoVo> chattings = chatService.getChatInfo(groupChatroomId);
			log.info("######가져온 채팅 내역 : {}",chattings);
			model.addAttribute("chattings",chattings);
		}
		return "user/groupChatPopup";
	}
		
	
	
}
