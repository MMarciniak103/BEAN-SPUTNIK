package com.example.wojci.bean_sputnik;

import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SpotTheDot extends AppCompatActivity { // dlaczego tak jest że najprostsze rzeczy dają najwięcej radości?
    Display display;
    Random buttonR = new Random();
    Button redButton; // button w charakterze kropki
    TextView text1;
    Timer Clockster = new Timer();
    Point size = new Point(); // i to też

    int width; // proporcje ekranu
    int height;
    int licznik=20; //liczba pozostałych zmian umiejscowienia kropki
    double time=0; // cały czas trwania testu


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dots);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        text1 = findViewById(R.id.textView);
        display = getWindowManager().getDefaultDisplay();
        display.getSize(size);  //tu chyba z grubsza wiadomo co się dzieje
        width = size.x;
        height = size.y;

        redButton = findViewById(R.id.buttonRed);
        text1.setText("This is a simple reaction time measuring program.\nBegin by pressing the bean");
        //wiem że instrukcja powinna być nieco lepiej napisana, nie mam pomysłu jak

        redButton.setX(width / 2-30); //początkowa pozycja kropy
        redButton.setY(height / 2 + 100);

        width -= 80; //marginesy
        height -= 80;

        redButton.setOnClickListener(new View.OnClickListener() { // robi się zabawnie
            @Override
            public void onClick(View v) {
                 // nie wiem czy to najbardziej wyrafinowana metoda implementacji pomiaru czasu... ale działa ^^

                Clockster.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                time++;
                            }
                        });
                    }
                }, 0, 10);

                if (licznik > 0) { // decydujemy czy znowu losować położenie kropy czy wracać do ekranu głównego
                    licznik--;
                    redButtonClicked();
                    text1 = findViewById(R.id.textView);
                    text1.setText(Integer.toString(licznik + 1) + " rounds left");
                } else {
                    Clockster.cancel();
                    time /= 1000;
                    time /= 20;
                    Toast.makeText(SpotTheDot.this,
                            "Finished. \nYour average reaction time is " + Double.toString(time).substring(0, 4) + " seconds"
                            , Toast.LENGTH_LONG).show();
                    setContentView(R.layout.activity_main);
                    finish();
                }

            }
        }
        );
    }
    public void redButtonClicked() {
        redButton.setX(buttonR.nextInt(width));
        redButton.setY(buttonR.nextInt(height));
    }

}
