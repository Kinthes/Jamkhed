package com.ecs.Jamkhed.screens;


import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.ecs.Jamkhed.Jamkhed;

public class SplashScreen extends AbstractScreen{
	
	private Texture 		splashTexture;
	private Image splashImage;
	//private TextureRegion	splashTextureRegion;

	public SplashScreen(Jamkhed game) {
		super(game);
		// TODO Auto-generated constructor stub
	}
	
	@Override 
	public void show(){
		super.show();
		
		splashTexture = new Texture("splash.png");
		splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		//splashTextureRegion= new TextureRegion(splashTexture,0,0,512,301);
		
		stage.clear();
		TextureRegion splashRegion=new TextureRegion(splashTexture,0,0,512,301);
		splashImage=new Image(splashRegion);//, Scaling.stretch);//, Align.bottom | Align.left);
		
		
		splashImage.addAction(Actions.sequence(Actions.fadeIn(1),Actions.delay(1),Actions.fadeOut(2), 
								Actions.run(new Runnable() {
									public void run () {
											game.setScreen( game.getMenuScreen() );
											Gdx.app.log(Jamkhed.LOG, "Go to ze menu screen");
									}
								})));
		
		stage.addActor(splashImage);
	}
	
/*	@Override
	public void render(float delta){
		super.render(delta);
		
		batch.begin();
			batch.draw(splashTextureRegion, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
	}//*/
	
	@Override
	public void resize(
	int width,
	int height )
	{
	super.resize( width, height );
	
	// resize the splash image
	splashImage.setWidth(width);
	splashImage.setHeight(height);
	
	// we need a complete redraw
	splashImage.invalidateHierarchy();
	}
	
	@Override
	public void dispose(){
		super.dispose();
		splashTexture.dispose();
	}

}
