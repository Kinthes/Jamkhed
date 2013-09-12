package com.ecs.Jamkhed.domain;

public enum FrontGun implements Item{
	PULSE_CANNON("Pulse-Cannon",500, Shot.BULLET),
	WAVE_CANNON("Multi-Cannon",750, Shot.WAVE),
	VULCAN_CANNON("Vulcan Cannon",600, Shot.FIREBALL),
	PROTON_LAUNCHER("Proton",600,Shot.PROTON),
	MISSILE_LAUNCHER("Missile Launcher",850, Shot.MISSILE);
	
	private final String name;
	private final int price;
	private final Shot shot;
	
	private FrontGun(String name, int price, Shot shot){
		this.name=name;
		this.price=price;
		this.shot=shot;
	}
	
	public String getName(){
		return name;
	}
	
	public int getPrice(){
		return price;
	}
	
	public Shot getShot(){
		return shot;
	}

}
