package com.fpl.draftPick.service.players;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fpl.draftPick.model.PlayerType;
import com.fpl.draftPick.model.UserSelection;
import com.fpl.draftPick.players.dao.PlayerDao;
import com.fpl.draftPick.players.model.Player;
import com.fpl.draftPick.users.dao.UserDao;
import com.fpl.draftPick.users.model.User;

public class PlayerServiceImpl implements PlayersService {

	private PlayerDao playerDao;

	private UserDao userDao;

	private static int UNASSIGNED_ID = 0;

	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	public void setUserDao(UserDao userDao) {
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

		Player player = playerDao.getPlayer(playerID);

		if (player != null && player.getSelectedUserId() == UNASSIGNED_ID) {
			UserSelection userSelection = userDao.getUserSelection(userID);
			playerDao.assignPlayerToUser(userID, playerID);
			return assignToUser(userSelection, player);
		}
		return false;
	}

	private boolean assignToUser(UserSelection userSelection, Player player) {

		switch (player.getPlayerType().getId()) {
		case (PlayerType.GK):
			if (userSelection.getGk1() == UNASSIGNED_ID) {
				return userDao.updateUserSelection(userSelection.getUserId(), player.getId(), "gk_1");
			} else if (userSelection.getGk2() == UNASSIGNED_ID) {
				return userDao.updateUserSelection(userSelection.getUserId(), player.getId(), "gk_2");
			}
			return false;
		case (PlayerType.DEF):
			if (userSelection.getDef1() == UNASSIGNED_ID) {
				return userDao.updateUserSelection(userSelection.getUserId(), player.getId(), "def_1");
			} else if (userSelection.getDef2() == UNASSIGNED_ID) {
				return userDao.updateUserSelection(userSelection.getUserId(), player.getId(), "def_2");
			} else if (userSelection.getDef3() == UNASSIGNED_ID) {
				return userDao.updateUserSelection(userSelection.getUserId(), player.getId(), "def_3");
			} else if (userSelection.getDef4() == UNASSIGNED_ID) {
				return userDao.updateUserSelection(userSelection.getUserId(), player.getId(), "def_4");
			}
			return false;
		case (PlayerType.MID):
			if (userSelection.getMid1() == UNASSIGNED_ID) {
				return userDao.updateUserSelection(userSelection.getUserId(), player.getId(), "mid_1");
			} else if (userSelection.getMid2() == UNASSIGNED_ID) {
				return userDao.updateUserSelection(userSelection.getUserId(), player.getId(), "mid_2");
			} else if (userSelection.getMid3() == UNASSIGNED_ID) {
				return userDao.updateUserSelection(userSelection.getUserId(), player.getId(), "mid_3");
			} else if (userSelection.getMid4() == UNASSIGNED_ID) {
				return userDao.updateUserSelection(userSelection.getUserId(), player.getId(), "mid_4");
			} else if (userSelection.getMid5() == UNASSIGNED_ID) {
				return userDao.updateUserSelection(userSelection.getUserId(), player.getId(), "mid_5");
			}
			return false;
		case (PlayerType.FWD):
			if (userSelection.getStr1() == UNASSIGNED_ID) {
				return userDao.updateUserSelection(userSelection.getUserId(), player.getId(), "str_1");
			} else if (userSelection.getStr2() == UNASSIGNED_ID) {
				return userDao.updateUserSelection(userSelection.getUserId(), player.getId(), "str_2");
			} else if (userSelection.getStr3() == UNASSIGNED_ID) {
				return userDao.updateUserSelection(userSelection.getUserId(), player.getId(), "str_3");
			} else if (userSelection.getStr4() == UNASSIGNED_ID) {
				return userDao.updateUserSelection(userSelection.getUserId(), player.getId(), "str_4");
			}
			return false;
		}
		return false;
	}
}
