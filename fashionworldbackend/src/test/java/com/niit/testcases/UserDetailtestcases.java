package com.niit.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDetailDAO;
import com.niit.model.UserDetail;

public class UserDetailtestcases {

	static UserDetailDAO userdetailDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();	
		userdetailDAO=(UserDetailDAO)context.getBean("userdetailDAO");
	}
	
	@Test
	public void registerUserTest()
	{
		UserDetail user=new UserDetail();
		
		user.setUsername("shruthi");
		user.setPassword("shru123");
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		user.setCustomerName("Shruthi BV");
		user.setCustomerAddr("Hyderabad");
		
		assertTrue("Problem in adding User:",userdetailDAO.registerUser(user));
	}

}
