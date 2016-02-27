package com.fpl.draftPick.service.players;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fpl.draftPick.model.UserSelection;
import com.fpl.draftPick.players.dao.PlayerDao;
import com.fpl.draftPick.players.model.Player;
import com.fpl.draftPick.users.dao.UserDao;
import com.fpl.draftPick.users.model.User;

public class PlayerServiceImpl implements PlayersService {
	
	private PlayerDao playerDao;
	
	private UserDao userDao;
	
	private static int UNASSIGNED_ID = 0;
	
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

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public boolean assignPlayerToUser(int userID, String playerID) {
		
		// Get player's object
		Player player = playerDao.getPlayer(playerID);
		
		// Check if player is not assigned
		if(player != null && player.getSelectedUserId() == UNASSIGNED_ID){
			// Get user's player selection
			UserSelection userSelection = userDao.getUserSelection(userID);
			// TODO Check player is not assigned to user already
			// Check type of player selected. 
			// 
			
		}
		return false;
	}
	
	

}
