package com.model;

public class Player {
	private String playerName;
	private int position;
	
	public Player(String playerName) {
		this.playerName = playerName;
		this.position = 0;
	}

	public String getPlayerName() {
		return playerName;
	}
	
	public int getPosition() {
		return position;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
}
