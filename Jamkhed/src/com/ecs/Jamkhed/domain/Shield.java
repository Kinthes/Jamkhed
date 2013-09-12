package com.ecs.Jamkhed.domain;

public enum Shield implements Item {
	
	SIF("Structural Integrity Shield", 100, 1),
	AIF("Advanced Integrity Shield", 250, 2),
	GLES("Gencore High Energy Shield",1000,4),
	MLXS("MicroCorp LXS Class A", 2000,5);
	
	private final String name;
	private final int price;
	private final int armor;
	
		private Shield(String name, int price, int armor){
		this.name=name;
		this.price=price;
		this.armor=armor;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	
	public int getArmor() {
		return armor;
	}

}
