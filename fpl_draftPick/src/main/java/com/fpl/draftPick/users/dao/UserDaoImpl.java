package com.fpl.draftPick.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.fpl.draftPick.players.model.Player;
import com.fpl.draftPick.users.model.User;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = getSessionFactory().getCurrentSession()
				.createQuery("from User where username=?")
				.setParameter(0, username).list();
		
		if ( users.size() > 0 ) {
			return users.get(0);
		} else { 
			return null;
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<User> getDraftpickUsers() {
		
		List<User> users = new ArrayList<User>();

		users = getSessionFactory().getCurrentSession()
				.createCriteria(User.class).list();
		
		if ( users.size() > 0 ) {
			return users;
		} else { 
			return null;
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

}
