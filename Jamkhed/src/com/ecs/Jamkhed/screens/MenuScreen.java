package com.ecs.Jamkhed.screens;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;




import com.ecs.Jamkhed.Jamkhed;

public class MenuScreen extends AbstractScreen{
	
	//private Skin skin;
	//private TextureAtlas atlas;
	
	public MenuScreen(Jamkhed game) {
		super(game);
		// TODO Auto-generated constructor stub
	}
	
		@Override
	public void show(){
		super.show();
			
		//retrieve the default table actor
		Table table = super.getTable();		
		stage.clear();
			
		//atlas = new TextureAtlas(Gdx.files.internal("assets/data/uiskin.atlas"));
		//skin = new Skin(Gdx.files.internal("assets/data/uiskin.json"));
		
		Label label=new Label("Jamkhed",getSkin());
		Button bouton1=new Button(getSkin());
		bouton1.add("Start Game");		
		bouton1.addListener(new ChangeListener() {  
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen( game.getStartGameScreen());
				Gdx.app.log(Jamkhed.LOG, "Allez HOP ACTION");				
			}
		});
		
		TextButton bouton2=new TextButton("Options",getSkin());
		
		bouton2.addListener(new ChangeListener() {
			
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen( new OptionsScreen(game));
				Gdx.app.log(Jamkhed.LOG, "Allez HOP Options");				
			}
				});
		
		Button bouton3=new Button(getSkin());
		bouton3.add("Hall Of Fame");
		bouton3.addListener(new ChangeListener() {  
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				
				Gdx.app.log(Jamkhed.LOG, "Allez HOP Classement");				
			}
		});
		
		table.add(label).spaceBottom(20);
		table.row();
		table.add(bouton1).width(150).spaceBottom(10);
		table.row();
		table.add(bouton2).width(150).spaceBottom(10);
		table.row();
		table.add(bouton3).width(150);
		table.row();
		
		
		stage.addActor(table);
		}
		
	
	

}
