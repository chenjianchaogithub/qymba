package com.hzs.generic.security;

import javax.annotation.Resource;

import com.hzs.qymba.api.UserApi;
import com.hzs.qymba.dto.UserDTO;
import com.hzs.qymba.model.LoginToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/*import com.nqt.core.security.OnlineManager;
import com.nqt.generic.model.LoginToken;
import com.nqt.generic.model.Permission;
import com.nqt.generic.model.Role;
import com.nqt.generic.service.RoleService;
import com.nqt.generic.service.UserService;*/


/**
 * 用户身份验证,授权 Realm 组件
 * 
 * @author chenjianchao
 * @since v1.0.0
 **/
public class SecurityRealm extends AuthorizingRealm {
	
	/*@Resource
	private UserService userService;
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private OnlineManager onlineManager;*/

	@Resource
	UserApi userApi;

	/*public UserApi getUserApi() {
		return userApi;
	}

	public void setUserApi(UserApi userApi) {
		this.userApi = userApi;
	}*/

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) 
			throws AuthenticationException {
		LoginToken uToken = (LoginToken) token;
		// 通过数据库进行验证
		// 把成功验证的用户信息保存到当前会话中
		uToken.setUser(userApi.authentication(uToken));
		// 在登录控制器中登记
		//onlineManager.login(uToken);
		
		return new SimpleAuthenticationInfo(uToken, token.getCredentials(), getName());
	}

	/**
	 * 权限检查
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		/*LoginToken token = (LoginToken) principals.getPrimaryPrincipal();

		// 角色名的集合
		List<Role> roleInfos = roleService.selectRolesByUserId(token.getUser().getId());
		// 权限名的集合
		List<Permission> permissions;
		*/
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		/*for (Role role : roleInfos) {
			// 添加角色
			authorizationInfo.addRole(role.getSign());
			permissions = role.getPermissions();
			for (Permission permission : permissions) {	// 添加权限
				authorizationInfo.addStringPermission(permission.getSign());
			}
		}*/
		return authorizationInfo;		
	}
}
