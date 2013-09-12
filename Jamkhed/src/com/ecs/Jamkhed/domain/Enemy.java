package com.ecs.Jamkhed.domain;

public enum Enemy {
	MAGNET(null,25),
	PURPLE_TRAIN(null,50),
	WAR_TANK(null,75);
	
	private final Shot shot;
	private final int credits;
	
	private Enemy(Shot shot, int score)	{
		this.shot=shot;
		this.credits=score;
	}
	
	//Retrieve the shot fired by this enemy
	public Shot getShot(){
		return shot;
	}
	
	//retrieve the credits earn by killing ths enemy
	public int getCredits(){
		return credits;
	}
}
