package com.fpl.draftPick.users.dao;

import com.fpl.draftPick.users.model.User;

public interface UserDao {
	
	User findByUserName(String username);

}
