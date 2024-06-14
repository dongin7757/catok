package com.chat.catok.security;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.chat.catok.service.IUserInfoService;
import com.chat.catok.vo.UserInfoVo;

@Component
public class LoginService implements UserDetailsService {

	@Autowired
	private IUserInfoService service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfoVo userInfo = service.login(username);
//		String[] auth = {"ROLE_USER", "ROLE_ADMIN"};
		if(userInfo != null) {
			return User.builder()
					.username(userInfo.getUser_id())
					.password(userInfo.getUser_password()) 
					.roles(userInfo.getUser_auth())
//					.authorities(AuthorityUtils.createAuthorityList(Arrays.asList(auth))) 
					.build();
		}
		else throw new UsernameNotFoundException("조회된 회원이 없서요!");
	}

}
