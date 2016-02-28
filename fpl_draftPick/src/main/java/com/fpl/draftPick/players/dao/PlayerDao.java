package com.fpl.draftPick.players.dao;

import java.util.List;

import com.fpl.draftPick.players.model.Player;

public interface PlayerDao {
	
	
	List<Player> getAllPlayers();
	
	Player getPlayer(String playerId);
	
	Player getPlayerByUserName();
	
	void assignPlayerToUser(int userID, String playerID);
	

}
