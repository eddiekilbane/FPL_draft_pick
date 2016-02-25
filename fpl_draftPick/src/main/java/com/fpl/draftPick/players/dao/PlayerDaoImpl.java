package com.fpl.draftPick.players.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.fpl.draftPick.players.model.Player;

public class PlayerDaoImpl implements PlayerDao {

	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Player> getAllPlayers() {

		List<Player> allPlayers = new ArrayList<Player>();

		allPlayers = getSessionFactory().getCurrentSession()
				.createCriteria(Player.class).list();

		return allPlayers;
	}

	public Player getPlayerByUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
