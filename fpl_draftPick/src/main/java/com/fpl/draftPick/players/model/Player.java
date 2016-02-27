package com.fpl.draftPick.players.model;

import com.fpl.draftPick.model.Club;
import com.fpl.draftPick.model.PlayerType;

public class Player {
	
	private int id;
	private String firstName;
	private String secondName;
	private Integer totalPoints;
	private Integer averagePoints;
	private Club club;
	private PlayerType playerType;
	private int selectedUserId;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public Integer getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(Integer totalPoints) {
		this.totalPoints = totalPoints;
	}
	public Integer getAveragePoints() {
		return averagePoints;
	}
	public void setAveragePoints(Integer averagePoints) {
		this.averagePoints = averagePoints;
	}
	public Club getClub() {
		return club;
	}
	public void setClub(Club club) {
		this.club = club;
	}
	public PlayerType getPlayerType() {
		return playerType;
	}
	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSelectedUserId() {
		return selectedUserId;
	}
	public void setSelectedUserId(int selectedUserId) {
		this.selectedUserId = selectedUserId;
	}

}
