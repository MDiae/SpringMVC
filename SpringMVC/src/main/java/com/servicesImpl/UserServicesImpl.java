package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.UserDao;
import com.entities.Users;
import com.services.UserServices;

public class UserServicesImpl implements UserServices{

	@Autowired
	UserDao userDao;
	
	@Override
	public List<Users> list() {
		// TODO Auto-generated method stub
		return userDao.list();
	}

	@Override
	public boolean delete(Users users) {
		// TODO Auto-generated method stub
		return userDao.delete(users);
	}

	@Override
	public boolean saveOrUpdate(Users users) {
		// TODO Auto-generated method stub
		return userDao.saveOrUpdate(users);
	}

}
