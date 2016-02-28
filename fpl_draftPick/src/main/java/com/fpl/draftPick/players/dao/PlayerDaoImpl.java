package com.fpl.draftPick.players.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.fpl.draftPick.players.model.Player;

public class PlayerDaoImpl implements PlayerDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Player> getAllPlayers() {

		List<Player> allPlayers = new ArrayList<Player>();

		allPlayers = getSessionFactory().getCurrentSession().createCriteria(Player.class).list();

		return allPlayers;
	}

	public Player getPlayerByUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getPlayer(String playerId) {

		String hql = "FROM Player" + " WHERE fpl_id='" + playerId + "'";

		Player player = (Player) getSessionFactory().getCurrentSession().createQuery(hql).uniqueResult();

		if (player == null) {
			System.out.println("ERROR: Couldn't find player with id: " + playerId);
			return null;
		}

		return player;
	}

	@Override
	public void assignPlayerToUser(int userID, String playerID) {

		String hql = "UPDATE Player SET selected_user_id=" + userID + " WHERE fpl_id='" + playerID + "'";
		getSessionFactory().getCurrentSession().createQuery(hql).executeUpdate();
	}
}
