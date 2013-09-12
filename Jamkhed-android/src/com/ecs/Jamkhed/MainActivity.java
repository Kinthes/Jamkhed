package com.ecs.Jamkhed;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;


public class MainActivity extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        boolean useOpenGLES2 = false;
        
        initialize(new Jamkhed(),useOpenGLES2);
    }
}