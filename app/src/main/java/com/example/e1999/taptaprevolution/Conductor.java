package com.example.e1999.taptaprevolution;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;

import java.util.Locale;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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
        Button backButt = (Button) findViewById(R.id.backButt);
        ImageButton leftButt = (ImageButton) findViewById(R.id.leftButt);
        ImageButton rightButt = (ImageButton) findViewById(R.id.rightButt);
        ImageButton upButt = (ImageButton) findViewById(R.id.upButt);
        ImageButton downButt = (ImageButton) findViewById(R.id.downButt);

        //Button stuff
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
        upButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (upTimerPoint()) {
                    points++;
                }
                pointsView.setText("Score: " + Integer.toString(points));
                upTimerPoint();
            }
        });
        downButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (downTimerPoint()) {
                    points++;
                }
                pointsView.setText("Score: " + Integer.toString(points));
                downTimerPoint();
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
                youTubePlayer.loadVideo("YAji3WyouL0");
                startTimer();
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
            }
        });
    }

    //Timer stuff
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
        if (mTimeLeftInMillis < 115800 && mTimeLeftInMillis > 114900) {
            return true;
        }
        if (mTimeLeftInMillis < 113800 && mTimeLeftInMillis > 112900) {
            return true;
        }
        if (mTimeLeftInMillis < 111700 && mTimeLeftInMillis > 110000) {
            return true;
        }
        if (mTimeLeftInMillis < 109800 && mTimeLeftInMillis > 109000) {
            return true;
        }
        if (mTimeLeftInMillis < 108999 && mTimeLeftInMillis > 108000) {
            return true;
        }
        if (mTimeLeftInMillis < 107999 && mTimeLeftInMillis > 107000) {
            return true;
        }
        if (mTimeLeftInMillis < 102999 && mTimeLeftInMillis > 102000) {
            return true;
        }
        if (mTimeLeftInMillis < 101999 && mTimeLeftInMillis > 101000) {
            return true;
        }
        if (mTimeLeftInMillis < 100999 && mTimeLeftInMillis > 100000) {
            return true;
        }
        if (mTimeLeftInMillis < 99999 && mTimeLeftInMillis > 90000) {
            return true;
        }
        if (mTimeLeftInMillis < 87500 && mTimeLeftInMillis > 87301) {
            return true;
        }
        if (mTimeLeftInMillis < 87300 && mTimeLeftInMillis > 87000) {
            return true;
        }
        if (mTimeLeftInMillis < 87100 && mTimeLeftInMillis > 86000) {
            return true;
        } else {
            return false;
        }
    }
    public boolean rightTimerPoint() {
        if (mTimeLeftInMillis < 109000 && mTimeLeftInMillis > 108000) {
            return true;
        }
        if (mTimeLeftInMillis < 107200 && mTimeLeftInMillis > 106200) {
            return true;
        }
        if (mTimeLeftInMillis < 176000 && mTimeLeftInMillis > 161000) {
            return true;
        }
        if (mTimeLeftInMillis < 241000 && mTimeLeftInMillis > 226000) {
            return true;
        }
        if (mTimeLeftInMillis < 251000 && mTimeLeftInMillis > 236000) {
            return true;
        }
        if (mTimeLeftInMillis < 265000 && mTimeLeftInMillis > 260000) {
            return true;
        }
        if (mTimeLeftInMillis < 275000 && mTimeLeftInMillis > 270000) {
            return true;
        }
        if (mTimeLeftInMillis < 287500 && mTimeLeftInMillis > 277500) {
            return true;
        }
        if (mTimeLeftInMillis < 320000 && mTimeLeftInMillis > 310000) {
            return true;
        }
        if (mTimeLeftInMillis < 335000 && mTimeLeftInMillis > 325000) {
            return true;
        }
        if (mTimeLeftInMillis < 345000 && mTimeLeftInMillis > 340000) {
            return true;
        }
        if (mTimeLeftInMillis < 355000 && mTimeLeftInMillis > 345000) {
            return true;
        }
        if (mTimeLeftInMillis < 395000 && mTimeLeftInMillis > 385000) {
            return true;
        }
        if (mTimeLeftInMillis < 445000 && mTimeLeftInMillis > 440000) {
            return true;
        }
        if (mTimeLeftInMillis < 455000 && mTimeLeftInMillis > 445000) {
            return true;
        }
        if (mTimeLeftInMillis < 467500 && mTimeLeftInMillis > 457500) {
            return true;
        }
        if (mTimeLeftInMillis < 515000 && mTimeLeftInMillis > 510000) {
            return true;
        }
        if (mTimeLeftInMillis < 530000 && mTimeLeftInMillis > 520000) {
            return true;
        }
        if (mTimeLeftInMillis < 600000 && mTimeLeftInMillis > 590000) {
            return true;
        } else {
            return false;
        }
    }
    public boolean upTimerPoint() {
        if (mTimeLeftInMillis < 100000) {
            return true;
        } else {
            return false;
        }
    }
    public boolean downTimerPoint() {
        if (mTimeLeftInMillis < 100000) {
            return true;
        } else {
            return false;
        }
    }

    public int points = 0;

}