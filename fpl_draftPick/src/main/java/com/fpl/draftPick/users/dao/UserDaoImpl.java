package com.fpl.draftPick.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.fpl.draftPick.users.model.User;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = getSessionFactory().getCurrentSession()
				.createQuery("from User where username=?")
				.setParameter(0, username).list();

		if (users.size() > 0) {
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

		if (users.size() > 0) {
			return users;
		} else {
			return null;
		}
	}

	@Override
	public boolean updateUser(User user) {

		String hql = "UPDATE User set draft_order =" + user.getDraftOrder()
				+ " WHERE username ='" + user.getUsername()+"'";

		int result = getSessionFactory().getCurrentSession().createQuery(hql).executeUpdate();
		
		return true;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
