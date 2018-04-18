package com.core.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UserClassValidator implements ConstraintValidator<UserClass, Object> {

	@Override
	public void initialize(UserClass classinit) {
		
	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		//User user = (User)object;
		
		//手机号码和帐号，邮箱，必须有一个绑定
		/*boolean ok = (user.getMob()!=null ||
				user.getUsername()!=null ||
				user.getEmail()!=null);*/
		
		// 要求修改密码时新密码不能为空
		/*if (user.getChangepw())
			ok = ok && !Str.isEmpty(user.getPassword());*/
		
		return true;
	}
	
}
