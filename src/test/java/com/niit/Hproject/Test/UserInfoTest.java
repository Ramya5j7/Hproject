package com.niit.Hproject.Test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Hproject.Dao.UserDao;
import com.niit.Hproject.Model.UserInfo;

public class UserInfoTest {
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static UserInfo user;

	@Autowired
	private static UserDao userDao;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Hpoject.*");
		context.refresh();
		user=(UserInfo)context.getBean("user");
		userDao = (UserDao) context.getBean("userDao");
		System.out.println("init");
	}

	@Test
	public void addUserTestCase()
	{
		user.setUserId(5);
		user.setUserName("iou");
		user.setUserEmail("iou@gmail.com");
		user.setUserMobileNo("909090");
		
		
		 boolean flag = userDao.addUser(user);
		 
		
		 
		 Assert.assertEquals( "addUserTestCase" ,true, flag);
		
		
	}


}
