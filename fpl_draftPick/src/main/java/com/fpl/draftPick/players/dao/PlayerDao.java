package com.fpl.draftPick.players.dao;

import java.util.List;

import com.fpl.draftPick.players.model.Player;

public interface PlayerDao {
	
	
	List<Player> getAllPlayers();
	
	Player getPlayerByUserName();
	

}
