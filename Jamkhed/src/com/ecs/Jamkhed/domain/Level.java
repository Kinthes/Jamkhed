package com.ecs.Jamkhed.domain;

public class Level {
	private String name;
	private final int id;
	private boolean completed;
	private Level nextLevel;
	
	public Level(int id){
		this.id=id;
	}
	
	public int getId(){
		return id;
	}
	
	public String getLevel(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Level getNextLevel() {
		return nextLevel;
	}

	public void setNextLevel(Level nextLevel) {
		this.nextLevel = nextLevel;
	}

	public String getName() {
		return name;
	}
	
	public boolean hasNextLevel(){
		return (nextLevel!=null);
	}
	
	public static Level[] retrieve(){
		Level[] levels=new Level[3];
		
		//cretae level 2
		levels[2]=new Level(2);
		levels[2].setName("Episode 3");
		//cretae level 2
		levels[1]=new Level(1);
		levels[1].setName("Episode 2");
		levels[1].setNextLevel(levels[2]);
		//cretae level 2
		levels[0]=new Level(0);
		levels[0].setName("Episode 1");
		levels[0].setNextLevel(levels[1]);
		
		return levels;
	}
	
}
