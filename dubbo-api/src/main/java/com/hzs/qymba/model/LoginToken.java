package com.hzs.qymba.model;

import com.hzs.qymba.dto.UserDTO;
import org.apache.shiro.authc.UsernamePasswordToken;

/*import com.nqt.core.util.Mobile;
import com.nqt.generic.regular.OnlineType;*/

/**
 * 系统登录的数据验证
 * @author chenjianchao
 *
 */
public class LoginToken extends UsernamePasswordToken {

	private static final long serialVersionUID = 1L;
	
	// 验证码
	private String chkcode;
		
	// 在线方式
	//private OnlineType onlineType;
	
	private UserDTO user;
	
	public void setPassword(String password) {
		super.setPassword(password.toCharArray());
	}
	
	public String getChkcode() {
		return chkcode;
	}

	public void setChkcode(String chkcode) {
		this.chkcode = chkcode;
	}

	/*public OnlineType getOnlineType() {
		return onlineType;
	}

	public void setOnlineType(String onlineType) {
		this.onlineType = OnlineType.get(onlineType);
	}
	
	public void setOnlineType(OnlineType onlineType) {
		this.onlineType = onlineType;
	}

	public void setOnlineType(HttpServletRequest request) {
		setOnlineType(Mobile.is(request) ? OnlineType.MB : OnlineType.PC);
	}
	*/

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}