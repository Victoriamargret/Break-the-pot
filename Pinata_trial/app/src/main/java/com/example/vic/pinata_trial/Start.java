package com.example.vic.pinata_trial;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.content.Intent;
import android.media.MediaPlayer;

import android.view.View;

import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class Start extends AppCompatActivity {

    ImageButton button4;
    ImageButton b5;
    ImageButton button3;
    public static MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mp = MediaPlayer.create(this, R.raw.happiness);
        mp.setLooping(true);
        mp.start();


        button4 = (ImageButton) findViewById(R.id.imageButton1);
        b5 = (ImageButton) findViewById(R.id.imageButton2);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            mp.stop();
            finish();

        }


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it1);
            }
        });


        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mp.isPlaying()) {
                    mp.pause();

                } else {
                    mp.start();

                }
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {


                AlertDialog.Builder alertDialogbuilder = new AlertDialog.Builder(Start.this);

                alertDialogbuilder.setMessage("Are you sure, You wanted to Quit?");

                alertDialogbuilder.setCancelable(false);

                alertDialogbuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    @Override

                    public void onClick(DialogInterface dialog, int id) {


                        Intent intent = new Intent(getApplicationContext(), Start.class);


                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        intent.putExtra("EXIT", true);

                        startActivity(intent);
                        finish();


                    }
                });


                alertDialogbuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();


                    }
                });


                AlertDialog alertDialog = alertDialogbuilder.create();

                alertDialog.setTitle("QUIT?");

                alertDialog.show();

            }

            ;

        });
    }
}
