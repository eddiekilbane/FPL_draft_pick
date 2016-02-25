package com.fpl.draftPick.users.dao;

import java.util.List;

import com.fpl.draftPick.users.model.User;

public interface UserDao {
	
	User findByUserName(String username);
	
	List<User> getDraftpickUsers();
	
	boolean updateUser(User user);

}
