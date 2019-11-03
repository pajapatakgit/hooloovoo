package model;

import enums.Actions;

public class ActionModel {
	private int id;
	private User user;
	private Actions actionType;
	private String createdAt;

	public Actions getAction() {
		return actionType;
	}

	public void setAction(Actions actionType) {
		this.actionType = actionType;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCreated() {
		return createdAt;
	}
	
	public void setCreated (String createdAt) {
		this.createdAt = createdAt;
	}
}
