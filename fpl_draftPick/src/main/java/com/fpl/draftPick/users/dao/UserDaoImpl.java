package com.fpl.draftPick.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.fpl.draftPick.model.UserSelection;
import com.fpl.draftPick.users.model.User;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = getSessionFactory().getCurrentSession().createQuery("from User where username=?")
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

		users = getSessionFactory().getCurrentSession().createCriteria(User.class).list();

		if (users.size() > 0) {
			return users;
		} else {
			return null;
		}
	}

	@Override
	public boolean updateUser(User user) {

		String hql = "UPDATE User set draft_order =" + user.getDraftOrder() + " WHERE username ='" + user.getUsername()
				+ "'";

		getSessionFactory().getCurrentSession().createQuery(hql).executeUpdate();

		return true;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public UserSelection getUserSelection(int userId) {
		String hql = "FROM UserSelection WHERE user_id=" + userId;
		UserSelection selection = (UserSelection) getSessionFactory().getCurrentSession().createQuery(hql)
				.uniqueResult();
		if (selection != null) {
			return selection;
		}
		return null;
	}

	@Override
	public boolean updateUserSelection(int userId, int playerId, String playerCol) {
		String hql = "UPDATE UserSelection" + " SET " + playerCol + "_id = " + playerId 
				+ " WHERE user_id=" + userId;
		getSessionFactory().getCurrentSession().createQuery(hql).executeUpdate();

		return true;
	}

}
