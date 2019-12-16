package com.niit.Hproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Hproject.Dao.UserDao;
import com.niit.Hproject.Model.UserInfo;
public class App 
{
private static AnnotationConfigApplicationContext context;
	
	private static UserInfo user;

	@Autowired
	private static UserDao userDao;

    public static void main( String[] args )
    {
    	context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Hpoject.*");
		context.refresh();
		user=(UserInfo)context.getBean("user");
		userDao = (UserDao) context.getBean("userDao");
		System.out.println("init");
    }
}
