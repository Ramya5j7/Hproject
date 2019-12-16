package com.niit.Hproject.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.Hproject.Model.UserInfo;

public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDaoImpl() {
		
	}
	 public UserDaoImpl(SessionFactory sessionFactory) {
	
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {

	        return sessionFactory.getCurrentSession();
	    }
	 

	

	/*@Override
	public boolean updateUser(int userId) {
		// TODO Auto-generated method stub
		return false;
	}
*/
	@Override
	public boolean addUser(UserInfo user) {
		try {
			getCurrentSession().save(user);
			System.out.println("successfully saved");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
}
