package com.ecs.Jamkhed.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.ecs.Jamkhed.Jamkhed;

public abstract class AbstractScreen implements Screen {
	
	protected final Jamkhed 	game;
	protected final Stage		stage;
	
	private BitmapFont 	font;
	private SpriteBatch	batch;
	private Skin skin;
	private TextureAtlas atlas;
	private Table table;
	
	public AbstractScreen(Jamkhed game){
		this.game=game;
		this.font=new BitmapFont();
		this.batch=new SpriteBatch();
		this.stage = new Stage();
		Gdx.input.setInputProcessor(stage);
	}
	
	protected String getName(){
		return getClass().getSimpleName();
	}
	
	public BitmapFont getFont()
    {
        if( font == null ) {
            font = new BitmapFont();
        }
        return font;
    }

    public SpriteBatch getBatch()
    {
        if( batch == null ) {
            batch = new SpriteBatch();
        }
        return batch;
    }

    protected Skin getSkin()
    {
        if( skin == null ) {
        	atlas = new TextureAtlas(Gdx.files.internal("data/uiskin.atlas"));
            FileHandle skinFile = Gdx.files.internal("data/uiskin.json");
            skin=new Skin(skinFile, atlas);
        }
        return skin;
    }
    
    protected Table getTable(){
    	if(table==null){
    		table=new Table(getSkin());
    		table.setFillParent(true);
    		
    		stage.addActor(table);
    	}
    	return table;
    }

	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//update and draw the stage actors
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log(Jamkhed.LOG, "Resizing screen : "+getName()+" to "+width+"x"+height);
		stage.setViewport(width, height, true);
	}

	@Override
	public void show() {
		Gdx.app.log(Jamkhed.LOG, "Showing screen : "+getName());
		
	}

	@Override
	public void hide() {
		Gdx.app.log(Jamkhed.LOG, "Hiding screen : "+getName());		
	}

	@Override
	public void pause() {
		Gdx.app.log(Jamkhed.LOG, "Pausing screen : "+getName());		
	}

	@Override
	public void resume() {
		Gdx.app.log(Jamkhed.LOG, "Resuming screen : "+getName());		
	}

	@Override
	public void dispose() {
		Gdx.app.log(Jamkhed.LOG, "Disposing screen : "+getName());
		
		stage.dispose();
		if(batch!=null)batch.dispose();
		if(font!=null)font.dispose();
		if(skin!=null)skin.dispose();
	}

}
