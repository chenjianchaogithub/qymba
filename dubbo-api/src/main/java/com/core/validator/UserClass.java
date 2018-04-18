package com.core.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Constraint(validatedBy = { UserClassValidator.class })
public @interface UserClass {
	
	Class<?>[] groups() default {};
	
	String message(); 
	
	Class<? extends Payload>[] payload() default {};
	
}
