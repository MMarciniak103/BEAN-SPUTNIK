package com.example.wojci.bean_sputnik;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SpotTheDot extends MainActivity { // dlaczego tak jest że najprostsze rzeczy dają najwięcej radości?

    Random button = new Random();
    private Button redButton; // button w charakterze kropki
    private int width; // proporcje ekranu
    private int height;
    private int licznik=20; //liczba pozostałych zmian umiejscowienia kropki
    private double time=0; // cały czas trwania testu


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dots);
        Display display = getWindowManager().getDefaultDisplay(); // wiem że to powinno być przed override żeby nie zaśmiecać
        Point size = new Point(); // i to też

        display.getSize(size);  //tu chyba z grubsza wiadomo co się dzieje
        width = size.x;
        height = size.y;

        redButton = findViewById(R.id.buttonRed);
        TextView text1 = findViewById(R.id.textView);
        text1.setText("This is a simple reaction time measuring program.\nBegin by pressing the red dot");
        //wiem że instrukcja powinna być nieco lepiej napisana, nie mam pomysłu jak

        redButton.setX(width / 2-30); //początkowa pozycja kropy
        redButton.setY(height / 2 + 100);

        width -= 80; //marginesy
        height -= 80;

        redButton.setOnClickListener(new View.OnClickListener() { // robi się zabawnie
            @Override
            public void onClick(View v) {

                Timer T = new Timer(); // nie wiem czy to najbardziej wyrafinowana metoda implementacji pomiaru czasu... ale działa ^^
                T.scheduleAtFixedRate(new TimerTask() {
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
                    TextView text1 = findViewById(R.id.textView);
                    text1.setText(Integer.toString(licznik + 1) + " rounds left");
                } else {
                    T.cancel();
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
    private void redButtonClicked() {
        redButton.setX(button.nextInt(width));
        redButton.setY(button.nextInt(height));
    }

}
