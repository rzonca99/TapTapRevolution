package com.example.e1999.taptaprevolution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.lang.System;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Conductor extends AppCompatActivity {

    private static final String TAG = "Conductor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conductor);
        final TextView pointsView = (TextView) findViewById(R.id.hitCount);
        Button beatButt = (Button) findViewById(R.id.beatButt);
        Button backButt = (Button) findViewById(R.id.backButt);
        beatButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                points++;
                pointsView.setText("Score: " + Integer.toString(points));
            }
        });
        backButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Back button clicked");
                Intent intent = new Intent(Conductor.this, MainMenu.class);
                startActivity(intent);
            }
        });
    }


    /**
     * Possible plan of attack: create a function that requires players to hit the button within the
     * given time frame in order to gain points, as planned. THEN implement a Timer object and
     * have it call the function at given intervals. That should make the app more versatile and
     * efficient, as we could theoretically include more songs as long as we examine their lengths
     * and call the function at the right times.
     */

    /**
     * the song's bpm
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

}
