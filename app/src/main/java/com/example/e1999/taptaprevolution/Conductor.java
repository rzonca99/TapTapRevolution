package com.example.e1999.taptaprevolution;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;

import java.util.Locale;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class Conductor extends YouTubeBaseActivity {

    private static final String TAG = "Conductor";

    private static final long START_TIME_IN_MILLIS = 121000;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    private TextView mTextViewCountDown;

    boolean pointAdd = false;

    YouTubePlayerView mYouTubePlayerView;
    Button btnPlay;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: Starting");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conductor);
        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        final TextView pointsView = (TextView) findViewById(R.id.hitCount);
        Button leftButt = (Button) findViewById(R.id.leftButt);
        Button rightButt = (Button) findViewById(R.id.rightButt);
        Button backButt = (Button) findViewById(R.id.backButt);
        leftButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leftTimerPoint()) {
                    points++;
                }
                pointsView.setText("Score: " + Integer.toString(points));
                leftTimerPoint();
            }
        });
        rightButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rightTimerPoint()) {
                    points++;
                }
                pointsView.setText("Score: " + Integer.toString(points));
                rightTimerPoint();
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

        //YouTube stuff
        btnPlay = (Button) findViewById(R.id.btnPlay);
        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.youTubePlay);

        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onInitializationSuccess: Done initializing YouTube Player");
                youTubePlayer.loadVideo("SqtPY0q1Gz8");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onInitializationFailure: YouTube Player failed to initialize");
            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Initializing YouTube Player");
                mYouTubePlayerView.initialize(YouTubeConfig.getApiKey(), mOnInitializedListener);
                startTimer();
            }
        });
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
            }
        }.start();

        mTimerRunning = true;
    }
    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }
    public boolean leftTimerPoint() {
        if (mTimeLeftInMillis < 117000 && mTimeLeftInMillis > 116000) {
            return true;
        }
        if (mTimeLeftInMillis <= 116000 && mTimeLeftInMillis >= 114500) {
            return false;
        }
        if (mTimeLeftInMillis < 115000 && mTimeLeftInMillis > 113600) {
            return true;
        } else {
            return false;
        }
    }
    public boolean rightTimerPoint() {
        if (mTimeLeftInMillis < 115000 && mTimeLeftInMillis > 113600) {
            return true;
        } else {
            return false;
        }
    }

    public int points = 0;

}