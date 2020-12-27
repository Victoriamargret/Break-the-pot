package com.example.vic.pinata_trial;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

public class MainActivity extends Activity {

        ImageButton mButton;
        EditText mEdit;
        TextView mText;
        String name;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mButton = (ImageButton) findViewById(R.id.imageButton3);
            mEdit = (EditText) findViewById(R.id.editText1);
            mText = (TextView) findViewById(R.id.textView3);

            mButton.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    EditText userName = (EditText) findViewById(R.id.editText1);
                    if( TextUtils.isEmpty(userName.getText())){
                       userName.setError( "Please enter your name!" );


                    }else{
                        Intent it2 = new Intent(getApplicationContext(), gameScreen.class);
                        startActivity(it2);
                    }
                }
            });

        }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            exitByBackKey();
            return true;}

        else{
            return false;

        }}
        protected void onPause(){
            super.onPause();
            finish();

        }

    protected boolean exitByBackKey() {

        AlertDialog.Builder alertDialogbuilder = new AlertDialog.Builder(MainActivity.this);
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