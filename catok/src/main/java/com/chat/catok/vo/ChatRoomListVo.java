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
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomListVo {

	private String chat_id;
	private String user_id;
	private String chat_message;
	private String chat_regdate;
}
