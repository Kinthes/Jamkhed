package com.ecs.Jamkhed.screens;

import java.awt.event.ActionEvent;
import java.util.Locale;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.ecs.Jamkhed.Jamkhed;

public class OptionsScreen extends AbstractScreen{
	private Table table;
	private Label volumeValue;

	public OptionsScreen(Jamkhed game) {
		super(game);		
	}
	
	@Override
	public void show(){
		super.show();
		
		        // create the table actor and add it to the stage
        table = super.getTable();
        table.defaults().spaceBottom( 30 );
        table.columnDefaults( 0 ).padRight( 20 );
        table.add( "Options" ).colspan( 3 );
        
        // create the labels widgets
        final CheckBox soundEffectsCheckbox = new CheckBox("",getSkin());
        soundEffectsCheckbox.setChecked( game.getPreferences().isSoundEnabled() );
        soundEffectsCheckbox.addListener( new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor)
            {
                boolean enabled = soundEffectsCheckbox.isChecked();
                game.getPreferences().setSoundEffectsEnabled( enabled );
            }
        } );
        table.row();
        table.add( "Sound Effects" );
        table.add( soundEffectsCheckbox ).colspan( 2 ).left();


        final CheckBox musicCheckbox = new CheckBox("",getSkin());
        musicCheckbox.setChecked( game.getPreferences().isMusicEnabled() );
        musicCheckbox.addListener( new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor)
            {
                boolean enabled = musicCheckbox.isChecked();
                game.getPreferences().setMusicEffectsEnabled( enabled );
            }
        } );
        table.row();
        table.add( "Music" );
        table.add( musicCheckbox ).colspan( 2 ).left();


        // range is [0.0,1.0]; step is 0.1f
        Slider volumeSlider = new Slider( 0f, 1f, 0.1f,false, getSkin() );
        volumeSlider.setValue( game.getPreferences().getVolume() );
        volumeSlider.addListener( new ChangeListener() {
            @Override
            public void changed(
                ChangeEvent event,
                Actor actor )
            {
            	float value = ((Slider)actor).getValue();
                game.getPreferences().setVolume( value );
                updateVolumeLabel();
            }
        } );      

        volumeValue = new Label("", getSkin() );
        updateVolumeLabel();
        
        table.row();
        table.add( "Volume" );
        table.add( volumeSlider );
        table.add( volumeValue ).width( 40 );

        // register the back button
        TextButton backButton = new TextButton( "Back to main menu", getSkin() );
        backButton.addListener(new ChangeListener() {  
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(new MenuScreen(game));
				Gdx.app.log(Jamkhed.LOG, "Retour dans la ecran de le menu");				
			}
		});
        table.row();
        table.add( backButton ).size( 250, 60 ).colspan( 3 );
	}


    /**
     * Updates the volume label next to the slider.
     */
    private void updateVolumeLabel()
    {
        float volume = ( game.getPreferences().getVolume() * 100 );
        volumeValue.setText( String.format( Locale.US, "%1.0f%%", volume ) );
    }

	

}
