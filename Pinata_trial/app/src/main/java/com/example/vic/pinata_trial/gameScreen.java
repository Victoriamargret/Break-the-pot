package com.example.vic.pinata_trial;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;

public class gameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Start.mp.stop();


        ImageButton button3 = (ImageButton) findViewById(R.id.b3);

        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), gameOver.class);

                startActivity(i);
                finish();
            }

        });
    }

        public boolean onKeyDown ( int keyCode, KeyEvent event){
            if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
                exitByBackKey();
                return true;

            } else {
                return false;


            }
        }

        protected void onPause () {
            super.onPause();
            finish();

        }

        protected boolean exitByBackKey () {

            AlertDialog.Builder alertDialogbuilder = new AlertDialog.Builder(gameScreen.this);
            alertDialogbuilder.setMessage("Are you sure, You wanted to quit");
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
            alertDialog.setTitle("You pressed Back button");
            alertDialog.show();

            return false;
        }

    }

