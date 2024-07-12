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
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyChatRoomListVo {
	private String chat_id;
	private String room_type;
	private String chat_title;
	private String user_id;
	private String chat_message;
	private String chat_regdate;
}
