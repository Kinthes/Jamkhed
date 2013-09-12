package com.ecs.Jamkhed;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.ecs.Jamkhed.screens.HallOfFameScreen;
import com.ecs.Jamkhed.screens.LevelScreen;
import com.ecs.Jamkhed.screens.LoadSavedGameScreen;
import com.ecs.Jamkhed.screens.MenuScreen;
import com.ecs.Jamkhed.screens.OptionsScreen;
import com.ecs.Jamkhed.screens.ProfileScreen;
import com.ecs.Jamkhed.screens.SplashScreen;
import com.ecs.Jamkhed.screens.StartGameScreen;
import com.ecs.Jamkhed.services.ProfileService;


public class Jamkhed extends Game// implements ApplicationListener (in Game)
{
	//define a constant useful for logging
	public static final String LOG = Jamkhed.class.getSimpleName();
	//a libgdx helper class that logs th current FPS each sec
	private FPSLogger fpsLogger;
	private final ProfileService profileService;
	private final JamkhedPreferences preferences;
	
	public Jamkhed(){
		profileService=new ProfileService();
		preferences=new JamkhedPreferences();
	}
	
	public JamkhedPreferences getPreferences() {
		return preferences;
	}

	public ProfileService getProfileService(){
		return profileService;
	}
	
	public SplashScreen getSplashScreen(){
		return new SplashScreen(this);
	}
	
	public HallOfFameScreen getHallOfFameScreen()
    {
        return new HallOfFameScreen( this );
    }

    public LevelScreen getLevelScreen()
    {
        return new LevelScreen( this );
    }

    public LoadSavedGameScreen getLoadSavedGameScreen()
    {
        return new LoadSavedGameScreen( this );
    }

    public MenuScreen getMenuScreen()
    {
        return new MenuScreen( this );
    }

    public OptionsScreen getOptionsScreen()
    {
        return new OptionsScreen( this );
    }

    public ProfileScreen getProfileScreen()
    {
        return new ProfileScreen( this );
    }

    public StartGameScreen getStartGameScreen()
    {
        return new StartGameScreen( this );
    }

	
	@Override
	public void create(){
		Gdx.app.log(Jamkhed.LOG, "Creating game on "+Gdx.app.getType());
		fpsLogger= new FPSLogger();
		profileService.retrieveProfile();
		setScreen(getMenuScreen()); 
		//setScreen(getSplashScreen());
	}
	

	@Override
	public void dispose() {
		Gdx.app.log(Jamkhed.LOG, "Disposing game");
	}

	@Override
	public void render() {		
		super.render();
		fpsLogger.log();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		Gdx.app.log(Jamkhed.LOG, "Resizing game to : "+width+" x "+height);
		
		if( getScreen() == null ) {
            setScreen( getSplashScreen() );
        }

	}

	@Override
	public void pause() {
		super.pause();
		Gdx.app.log(Jamkhed.LOG, "Pausing game.");
	}

	@Override
	public void resume() {
		super.resume();
		Gdx.app.log(Jamkhed.LOG, "Resuming game.");
	}
	
	@Override
	public void setScreen(Screen screen){
		super.setScreen(screen);
		Gdx.app.log( Jamkhed.LOG, "Setting screen: " + screen.getClass().getSimpleName());
	}
}
