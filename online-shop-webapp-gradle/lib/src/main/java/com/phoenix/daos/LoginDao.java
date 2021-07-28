package com.phoenix.daos;

import java.util.List;

import com.phoenix.data.User;

public interface LoginDao {
	
	User getUserbyId(String username) ;
	List<User> getAll();
	void insert(User user);
	void update(User user);
	void delete(User user);
	
	

}
