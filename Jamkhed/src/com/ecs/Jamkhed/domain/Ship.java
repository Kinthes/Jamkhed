package com.ecs.Jamkhed.domain;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.OrderedMap;

public class Ship {
	private ShipModel shipModel;
	private FrontGun frontGun;
	private Shield shield;
	
	public Ship(){
		
	}

	public ShipModel getShipModel() {
		return shipModel;
	}

	public FrontGun getFrontGun() {
		return frontGun;
	}

	public Shield getShield() {
		return shield;
	}
	
	public boolean contains(Item item){
		if(item==null) return false;
		return (item.equals(shipModel) || item.equals(frontGun) || item.equals(shield));
	}
	
	public void install(Item item){
		if(item instanceof ShipModel){
			this.shipModel=(ShipModel)item;			
		}
		else if(item instanceof FrontGun){
			this.frontGun=(FrontGun)item;			
		}
		else if(item instanceof Shield){
			this.shield=(Shield)item;			
		}
		else {
			throw new IllegalArgumentException("unknown item : "+item);
		}
	}
	
    // Serializable implementation

    public void read(
        Json json,
        OrderedMap<String,Object> jsonData )
    {
        shipModel = ShipModel.valueOf( json.readValue( "shipModel", String.class, jsonData ) );
        frontGun = FrontGun.valueOf( json.readValue( "frontGun", String.class, jsonData ) );
        shield = Shield.valueOf( json.readValue( "shield", String.class, jsonData ) );
    }

    public void write(
        Json json )
    {
        json.writeValue( "shipModel", shipModel.name() );
        json.writeValue( "frontGun", frontGun.name() );
        json.writeValue( "shield", shield.name() );
    }

}
