package com.example.vic.pinata_trial;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;




public class gameOver extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);


        TextView tv3 = (TextView) findViewById(R.id.tv3);

        TextView tv1 = (TextView) findViewById(R.id.tv1);

        TextView tv2 = (TextView) findViewById(R.id.textView2);

        ImageButton button2 = (ImageButton) findViewById(R.id.imageButton6);

        ImageButton button3 = (ImageButton) findViewById(R.id.imageButton9);


        int score = getIntent().getIntExtra("Score", 0);

        tv1.setText("Do you want to try again" + "@string/enter_your_name");

        tv3.setText(score + " ");

        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);

        int highScore = settings.getInt("HIGH SCORE", 0);


        if (score > highScore) {

            tv1.setText(" " + score);

            SharedPreferences.Editor editor = settings.edit();

            editor.putInt("HIGH SCORE", score);

            editor.commit();
        } else {

            tv1.setText(" " + highScore);

        }


        button3.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {


                AlertDialog.Builder alertDialogbuilder = new AlertDialog.Builder( gameOver.this);

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


        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent i = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(i);

                finish();


            }

        });

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            exitByBackKey();
            return true;

        } else {
            return false;


        }
    }


    protected boolean exitByBackKey() {

        Intent intent = new Intent(getApplicationContext(), Start.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
        finish();

        return true;
    }

    protected void back() {

        finish();

    }

}
