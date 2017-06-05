package com.larry.osakwe.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play = (Button) findViewById(R.id.play);

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.neverhadit);
        //Find the View that shows the numbers category

        //Set a click listener on that view
        play.setOnClickListener(new View.OnClickListener() {
            //The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                mediaPlayer.start();

            }
        });

        Button stop = (Button) findViewById(R.id.stop);

        //Find the View that shows the numbers category

        //Set a click listener on that view
        stop.setOnClickListener(new View.OnClickListener() {
            //The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    currentPos = mediaPlayer.getCurrentPosition();
                }

            }
        });

        Button mute = (Button) findViewById(R.id.mute);

        //Find the View that shows the numbers category

        //Set a click listener on that view
        mute.setOnClickListener(new View.OnClickListener() {
            //The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                    mediaPlayer.setVolume(0, 0);

            }
        });

        Button unmute = (Button) findViewById(R.id.unmute);

        //Find the View that shows the numbers category

        //Set a click listener on that view
        unmute.setOnClickListener(new View.OnClickListener() {
            //The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                mediaPlayer.setVolume(1.0f, 1.0f);

            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast aToast = Toast.makeText(MainActivity.this, "I'm done!", Toast.LENGTH_SHORT);
                aToast.show();
            }

        });
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer!=null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
