package com.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.entities.Users;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
	
	@Autowired
	SessionFactory session;
	
	public List<Users> list(){
		return session.getCurrentSession().createQuery("from users").list();
		
	}
	
	public boolean delete(Users users) {
		try {
			session.getCurrentSession().delete(users);
		} catch(Exception ex){
			return false;
		}
		return true;
	}
	
	public boolean saveOrUpdate(Users users) {
		session.getCurrentSession().saveOrUpdate(users);
		return true;
	}

}
