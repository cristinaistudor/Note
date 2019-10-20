package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<String> notes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startAnimation();
        notes = new ArrayList<>();
        Button buttonNew = (Button) findViewById(R.id.buttonNew);
        buttonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSecondActivity();

            }
        });

        Button buttonShow = (Button) findViewById(R.id.buttonView);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchShowNotes();
            }
        });

        /*try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.append("");

            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }*/




    }

    public void  startAnimation(){
        TextView txtHello = (TextView) findViewById(R.id.textHello);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim);
        txtHello.startAnimation(animation);
    }

    public void launchSecondActivity(){
        Intent intent  = new Intent(this, NewNote.class);
        startActivity(intent);


    }

    public  void launchShowNotes(){
        Intent intent = new Intent(this, ShowNotes.class);
        startActivity(intent);

    }





}
