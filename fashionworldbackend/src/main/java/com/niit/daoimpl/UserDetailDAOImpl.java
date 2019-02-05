package com.niit.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDetailDAO;
import com.niit.model.UserDetail;
@Repository("userdetailDAO")
@Transactional
public class UserDetailDAOImpl implements UserDetailDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean registerUser(UserDetail user) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateAddress(UserDetail user) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserDetail getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
