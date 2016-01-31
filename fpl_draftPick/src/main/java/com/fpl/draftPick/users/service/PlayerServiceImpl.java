package com.fpl.draftPick.users.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fpl.draftPick.players.dao.PlayerDao;
import com.fpl.draftPick.players.model.Player;

public class PlayerServiceImpl implements PlayersService {
	
	private PlayerDao playerDao;
	
	public void setPlayerDao(PlayerDao playerDao){
		this.playerDao = playerDao;
	}

	@Override
	@Transactional
	public List<Player> getAllPlayers() {
		return playerDao.getAllPlayers();
	}

}
