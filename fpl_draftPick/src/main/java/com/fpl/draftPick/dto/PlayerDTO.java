package com.fpl.draftPick.dto;

import com.fpl.draftPick.model.Club;
import com.fpl.draftPick.model.PlayerType;
import com.fpl.draftPick.players.model.Player;

public class PlayerDTO {
	
	private String firstName;
	private String secondName;
	private String totalPoints;
	private String averagePoints;
	private String club;
	private String playerType;
	
	
	public PlayerDTO(Player player){
		
		this.firstName = player.getFirstName();
		this.secondName = player.getSecondName();
		this.totalPoints = player.getTotalPoints().toString();
		this.averagePoints = player.getAveragePoints().toString();
		
		Club clubDetails = player.getClub();
		this.club = clubDetails.getClubName();
		
		PlayerType playerType = player.getPlayerType();
		this.playerType = playerType.getPlayerType();
		
	}


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


	public String getTotalPoints() {
		return totalPoints;
	}


	public void setTotalPoints(String totalPoints) {
		this.totalPoints = totalPoints;
	}


	public String getAveragePoints() {
		return averagePoints;
	}


	public void setAveragePoints(String averagePoints) {
		this.averagePoints = averagePoints;
	}


	public String getClub() {
		return club;
	}


	public void setClub(String club) {
		this.club = club;
	}


	public String getPlayerType() {
		return playerType;
	}


	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}
	

}
