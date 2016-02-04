package com.fpl.draftPick.users.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fpl.draftPick.players.dao.PlayerDao;
import com.fpl.draftPick.players.model.Player;
import com.fpl.draftPick.users.dao.UserDao;
import com.fpl.draftPick.users.model.User;

public class PlayerServiceImpl implements PlayersService {
	
	private PlayerDao playerDao;
	
	private UserDao userDao;
	
	public void setPlayerDao(PlayerDao playerDao){
		this.playerDao = playerDao;
	}
	
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public List<Player> getAllPlayers() {
		return playerDao.getAllPlayers();
	}
	
	@Override
	@Transactional
	public List<User> getAllDraftPickUsers() {
		return userDao.getDraftpickUsers();
	}
	
	

}
