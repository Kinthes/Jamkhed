package com.ecs.Jamkhed.domain;

public enum ShipModel implements Item {
	
	USP_TALON("USP Talon", 6000, 1),
	USP_FANG("USP Fang", 8000,2),
	GENCORE_PHOENIX("Gencore Phoenix",12000,3),
	GENCORE_MAELSTROM("Gencore Maelstrom",18000,4),
	MICROSOL_STALKER("Microsol Stalker",25000,5);
	
	private final String name;
	private final int price;
	private final int firingCapacity;
	
	private ShipModel(String name, int price, int firing){
		this.name=name;
		this.price=price;
		this.firingCapacity=firing;		
	}

	public int getFiringCapacity() {
		return firingCapacity;
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

}
