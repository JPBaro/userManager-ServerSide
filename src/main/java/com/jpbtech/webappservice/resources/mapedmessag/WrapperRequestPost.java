package com.jpbtech.webappservice.resources.mapedmessag;

import com.jpbtech.webappservice.model.PasswordKey;
import com.jpbtech.webappservice.model.UsuarioInfo;

/**
 * 
 * @implNote class which host: {@link UsuarioInfo} and {@link PasswordKey} to handle POST Body
 * 
 * @author Joaquin Pampin
 */
public class WrapperRequestPost{
	
	UsuarioInfo userInfo;
	PasswordKey password;
	
	public WrapperRequestPost(UsuarioInfo userInfo, PasswordKey password) {
		this.userInfo = userInfo;
		this.password = password;
	}

	public UsuarioInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UsuarioInfo userInfo) {
		this.userInfo = userInfo;
	}

	public void setPassword(PasswordKey password) {
		this.password = password;
	}

	public PasswordKey getPassword() {
		return password;
	}
	
	
	


}
