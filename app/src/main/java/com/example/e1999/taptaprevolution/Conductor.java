package com.example.e1999.taptaprevolution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.lang.System;
import android.widget.Button;

public class Conductor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conductor);
    }

    /**
     * the songs bpm
     */
    public int bpm = 125;
    /**
     * how many milliseconds the players has to hit the button
     */
    public int hitWindow = 25;
    /**
     * if the button was hit in time
     */
    public boolean hitButt = false;
    /**
     * length of song in milliseconds
     */
    public int songLength = 121000;

    public int points = 0;

    public int misses = 0;

    public int timer = 0;

    /*
    We probably need a class that contains the video and a function that will launch it, that can
    be called by the start button.
     */

}
