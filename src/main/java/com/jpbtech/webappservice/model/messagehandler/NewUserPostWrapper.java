package com.jpbtech.webappservice.model.messagehandler;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.jpbtech.webappservice.controller.UsuariosServiceController;
import com.jpbtech.webappservice.model.UsuarioInfo;

/**
 * Wraps:
 * 		[{@link UsuarioInfo} &  attribute 'password' as {@link String}
 * to recieve @PostMapping @RequesBody as a single json file at  {@link UsuariosServiceController}
 * It is unwrapped at {@link UserDetailsService} for further operations. 
 * Keeps {@link UsuarioInfo} as a separate entity for request/response retrieve User's general info without accessing passwords. 
 * @author Joaquin Pampin
 */
public class NewUserPostWrapper{
	
	UsuarioInfo userinfo;
	String password;
	
	public NewUserPostWrapper(UsuarioInfo userinfo, String password) {
		this.userinfo = userinfo;
		this.password = password;
	}

	public UsuarioInfo getUserInfo() {
		return userinfo;
	}

	public void setUserInfo(UsuarioInfo userInfo) {
		this.userinfo = userInfo;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	
	


}
