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
public class UserInfoVo {
	private String user_id;
	private String user_password;
	private String user_name;
	private String user_email;
	private String user_prmsg;
	private String regdate;
}
