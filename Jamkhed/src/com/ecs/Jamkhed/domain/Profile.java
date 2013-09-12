package com.ecs.Jamkhed.domain;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.OrderedMap;

//THe player's profile
public class Profile implements Serializable {
	private Ship ship;
	private int currentLevelId;
	private int credits;
	private Map<Integer, Integer> highScores;
	
	public Profile(){
		highScores = new HashMap<Integer, Integer>();
		credits=1000;
		ship=new Ship();
		ship.install(ShipModel.USP_TALON );
        ship.install( FrontGun.PULSE_CANNON );
        ship.install( Shield.SIF );
	}
	
	public Ship getShip(){
		return ship;
	}

	public int getCurrentLevelId() {
		return currentLevelId;
	}
	
	public Map<Integer, Integer> getHighScores(){
		return highScores;
	}
	
	public int getHighScore(int levelId){
		if(highScores==null) return 0;
		Integer highScore=highScores.get(levelId);
		return (highScore==null ? 0 : highScore);
	}
	
	public boolean notifyScore(int levelId, int score){
		if(score > getHighScore(levelId)){
			highScores.put(levelId,score);
			return true;
		}
		return false;
	}

	public int getCredits() {
		return credits;
	}

	public boolean canBuy(Item item){
		if(ship.contains(item)){
			return false;
		}
		if(item.getPrice() > credits){
			return false;
		}
		return true;
	}
	
	public void buy(Item item){
		if(canBuy(item)){
			credits-=item.getPrice();
			ship.install(item);
		}
		
	}

	@Override
	public void write(Json json) {
		json.writeValue("currentLevelId",currentLevelId);
		json.writeValue("credits",credits);
		json.writeValue("highScores",highScores);	
		json.writeValue("ship", ship);
	}

	@Override
	public void read(Json json, OrderedMap<String, Object> jsonData) {
		currentLevelId=json.readValue("currentLevelId", Integer.class,jsonData);
		credits=json.readValue("credits",Integer.class,jsonData);
		//libGdx handles the keys of Json formatted hashMaps as Strings
		//but we whant it to be an int instead (levlId)
		Map<String,Integer>highScores=json.readValue("highScores", HashMap.class, Integer.class, jsonData);
		for( String levelIdAsString : highScores.keySet() ) {
            int levelId = Integer.valueOf( levelIdAsString );
            Integer highScore = highScores.get( levelIdAsString );
            this.highScores.put( levelId, highScore );
		}
		ship=json.readValue("ship", Ship.class,jsonData);
	}
}
