package com.fpl.draftPick.dto;

import com.fpl.draftPick.users.model.User;

public class UserDTO {
	private int userId;
	private String username;
	private int draftOrder;
	
	public UserDTO(User user){
		this.userId = user.getUserId();
		this.username = user.getUsername();
		this.draftOrder = user.getDraftOrder();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getDraftOrder() {
		return draftOrder;
	}
	public void setDraftOrder(int draftOrder) {
		this.draftOrder = draftOrder;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
