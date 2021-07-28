package com.phoenix.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.phoenix.daos.LoginDao;
import com.phoenix.daos.LoginDaoImpl;
import com.phoenix.data.User;
import com.phoenix.exceptions.UserNotFoundException;

public class LoginServiceImpl implements LoginService {
	private LoginDao logindao;
	public LoginServiceImpl()
	{
		logindao= new LoginDaoImpl();
	}
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> users= new ArrayList<User>();
		users= logindao.getAll();
		return users;
	}
	@Override
	public User findUserById(String username) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user=new User();
		user =  logindao.getUserbyId(username);
		if(user!=null)
			return user;
		else
			throw new UserNotFoundException("soor user not found");
	}
	@Override
	public void add(User user) {
		logindao.insert(user);
		
	}
	@Override
	public void edit(User user) {
		logindao.update(user);
		
	}
	@Override
	public void remove(User user) {
		logindao.delete(user);
		
	}
	@Override
	public String changePassword() {
		// TODO Auto-generated method stub
		//logindao.update(null);
		return null;
	}
	

}
