package com.fpl.draftPick.players.model;

public class Player {
	
	private int id;
	private String firstName;
	private String secondName;
	private Integer totalPoints;
	private Integer averagePoints;
	private Integer club;
	private Integer playerType;
	
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
	public Integer getClub() {
		return club;
	}
	public void setClub(Integer club) {
		this.club = club;
	}
	public Integer getPlayerType() {
		return playerType;
	}
	public void setPlayerType(Integer playerType) {
		this.playerType = playerType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
