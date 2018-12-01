package com.example.e1999.taptaprevolution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;

import java.lang.System;

public class MainMenu extends AppCompatActivity {

    private static final String TAG = "MainMenu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Log.d(TAG, "onCreate: Starting");
        Button startButt = (Button) findViewById(R.id.startButt);
        startButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Start button clicked");
                Intent intent = new Intent(MainMenu.this, Conductor.class);
                startActivity(intent);
            }
        });
    }

}