package com.ecs.Jamkhed.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.ecs.Jamkhed.Jamkhed;
import com.ecs.Jamkhed.domain.Profile;
import com.ecs.Jamkhed.domain.Ship;
import com.ecs.Jamkhed.domain.ShipModel;
import com.ecs.Jamkhed.domain.FrontGun;
import com.ecs.Jamkhed.domain.Shield;

public class StartGameScreen extends AbstractScreen{
	private Profile profile;
	private Ship ship;
	
	private TextButton episode1Button;
	private TextButton episode2Button;
	private TextButton episode3Button;
	private SelectBox shipModelSelectBox;
	private SelectBox frontGunSelectBox;
	private SelectBox shieldSelectBox;
	private Label creditsLabel;
	
	public StartGameScreen(Jamkhed game) {
		super(game);
	}

	@Override
	public void show(){
		super.show();
		
		Table table = super.getTable();		
		table.defaults().spaceBottom(20);
		table.columnDefaults(0).padRight(20);
		table.columnDefaults(4).padLeft(10);
		table.add("Start Game").colspan(5);
				
		profile= game.getProfileService().retrieveProfile();
		ship = profile.getShip();
		
		table.row();
		table.add("Episodes");
		episode1Button= new TextButton("Episode 1",getSkin());
		table.add(episode1Button).padRight(10);
		episode2Button= new TextButton("Episode 2",getSkin());
		table.add(episode2Button).fillX().padRight(10);
		episode3Button= new TextButton("Episode 3",getSkin());
		table.add(episode3Button).padRight(10);
		
		shipModelSelectBox = new SelectBox(ShipModel.values(),getSkin());
		table.row();
		table.add("Ship Model");
		table.add(shipModelSelectBox).fillX().colspan(3);
		shipModelSelectBox.addListener(new ChangeListener() {  
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				ship.install(ShipModel.values()[((SelectBox)actor).getSelectionIndex()]);
				Gdx.app.log(Jamkhed.LOG, "Allez HOP ACTION");
			}
		});
		
		frontGunSelectBox = new SelectBox(FrontGun.values(),getSkin());
		table.row();
		table.add("Front Gun");
		table.add(frontGunSelectBox).fillX().colspan(3);
		frontGunSelectBox.addListener(new ChangeListener() {  
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				ship.install(FrontGun.values()[((SelectBox)actor).getSelectionIndex()]);
				Gdx.app.log(Jamkhed.LOG, "Allez HOP ACTION");
			}
		});
		
		shieldSelectBox = new SelectBox(Shield.values(),getSkin());
		table.row();
		table.add("Shield");
		table.add(shieldSelectBox).fillX().colspan(3);
		shieldSelectBox.addListener(new ChangeListener() {  
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				ship.install(Shield.values()[((SelectBox)actor).getSelectionIndex()]);
				Gdx.app.log(Jamkhed.LOG, "Allez HOP ACTION");
			}
		});
		
		TextButton backButton = new TextButton("Back to main menu", getSkin());
		backButton.addListener(new ChangeListener() {  
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(new MenuScreen(game));
				Gdx.app.log(Jamkhed.LOG, "Retour dans la ecran de le menu");
				game.getProfileService().persist();
			}
		});
		table.row();
		table.addActor(backButton);
		
		shipModelSelectBox.setSelection(ship.getShipModel().ordinal());
		frontGunSelectBox.setSelection(ship.getFrontGun().ordinal());
		shieldSelectBox.setSelection(ship.getShield().ordinal());
		
		stage.addActor(table);
	}
}
