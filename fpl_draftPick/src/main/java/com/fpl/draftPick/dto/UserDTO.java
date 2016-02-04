package com.fpl.draftPick.dto;

import com.fpl.draftPick.users.model.User;

public class UserDTO {

	private String username;
	private int draftOrder;
	
	public UserDTO(User user){
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
	
	

}
