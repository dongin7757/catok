package com.chat.catok.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChatroomVo {

	private String chat_id;
	private String chatroom_regdate;
	private String room_type;
	private String chat_title;
}
