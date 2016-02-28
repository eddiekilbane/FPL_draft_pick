package com.fpl.draftPick.model;

public class PlayerType {
	
	public static final int GK = 1;
	public static final int DEF = 2;
	public static final int MID = 3;
	public static final int FWD = 4;
	
	private int id;
	private String playerType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlayerType() {
		return playerType;
	}
	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}

}
