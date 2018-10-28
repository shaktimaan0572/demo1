package com.vivek.model;

public class LeaderBoardColumnObj {
	
	private String userId;
	private String name;
	private int score;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public LeaderBoardColumnObj(String userId, String name, int score) {
		super();
		this.userId = userId;
		this.name = name;
		this.score = score;
	}
	
	

}
