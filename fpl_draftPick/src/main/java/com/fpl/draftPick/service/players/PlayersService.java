package com.fpl.draftPick.service.players;

import java.util.List;

import com.fpl.draftPick.players.model.Player;
import com.fpl.draftPick.users.model.User;

public interface PlayersService {
	
	public List<Player> getAllPlayers();
	
	public List<User> getAllDraftPickUsers();
	
	boolean updateUser(User user);
	
	

}
