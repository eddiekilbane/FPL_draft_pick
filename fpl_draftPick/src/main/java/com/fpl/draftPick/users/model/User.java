package com.fpl.draftPick.users.model;

import java.util.HashSet;
import java.util.Set;

public class User {

	private int userId;
	private String username;
	private String password;
	private boolean enabled;
	private int draftOrder;
	
	private Set<UserRole> userRole = new HashSet<UserRole>(0);
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Set<UserRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
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
