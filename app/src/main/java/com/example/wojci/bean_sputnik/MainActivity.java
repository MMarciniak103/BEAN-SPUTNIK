// app developed by Wojciech S.Y.R.O.P. Godula and Michał Majkel Marciniak for KN BEAN promotion

package com.example.wojci.bean_sputnik;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    /// Majkel
    public static final String SHARED_PREFS="sharedPrefs";
    public static final String KEY_HIGHSCORE="keyHighscore";

    private static final int REQUEST_CODE_QUIZ=1;
    private TextView textViewHighscore;
    private int highscore;


    /// SYROP

    protected void daltonizmTest1(View view){

        Intent intentDalton= new Intent(getApplicationContext(), DaltonizmTest.class);
        startActivity(intentDalton);
    }

    protected void spotTheDot(View view){
        Intent intentDot = new Intent(getApplicationContext(), SpotTheDot.class);
        startActivity(intentDot);
    }

    protected void about(View view){
        Intent intentAbout = new Intent(getApplicationContext(), aboutBEAN.class);
        startActivity(intentAbout);
    }

    protected void beanWeb(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/knbeanpwr/")));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);

            //// Majkel
            textViewHighscore = findViewById(R.id.text_view_highscore);
            loadHighscore();

            Button buttonStartQuiz = findViewById(R.id.button_start_quiz);
            buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View v) {
                                                       startQuiz();
                                                   }
                                               });

            // wyłączyłem te listenery bo z nich nie korzystam /// SYROP
        /*
        Button buttonDaltonTest=findViewById(R.id.button_start_daltonTest);
        buttonDaltonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Soon",Toast.LENGTH_SHORT).show();
            }
        });

        Button buttonSpotDot=findViewById(R.id.button_start_spotDot);
        buttonSpotDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Soon",Toast.LENGTH_SHORT).show();
            }
        });
        */

        }


    // Majkel
    private void startQuiz() {
        Intent intent=new Intent(MainActivity.this,QuizActivity.class);
        startActivityForResult(intent,REQUEST_CODE_QUIZ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE_QUIZ){
            if(resultCode==RESULT_OK){
                int score=data.getIntExtra(QuizActivity.EXTRA_SCORE,0);
                if(score>highscore){
                    updateHighscore(score);
                }
            }
        }
    }
    private void loadHighscore(){
        SharedPreferences prefs=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        highscore=prefs.getInt(KEY_HIGHSCORE,0);
        textViewHighscore.setText("Highscore "+highscore);
    }

    private void updateHighscore(int newHighscore){
        highscore=newHighscore;
        textViewHighscore.setText("Highscore: "+highscore);

        SharedPreferences prefs=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor=prefs.edit();
        editor.putInt(KEY_HIGHSCORE,highscore);
        editor.apply();
    }



}
