package com.example.wojci.bean_sputnik;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DaltonizmTest extends AppCompatActivity {

    private int plateIndex=1;
    private int score=0;
    ImageView Testplate;
    Button Switchpic2;
    Button Switchpic1;
    TextView Ishihara;
    TextView Frage;

    private void switchPic(View v, int buttonId) {
        Switchpic1 = findViewById(R.id.buttonA);
        Switchpic2 = findViewById(R.id.buttonB);
        Ishihara = findViewById(R.id.textViewPlateIndex);
        Frage = findViewById(R.id.textViewPytanie);
        Testplate = findViewById(R.id.imageViewTest);
        int score1=score;
        if(plateIndex < 25){ plateIndex++; Ishihara.setText(Integer.toString(plateIndex) + "/24");}
        switch (plateIndex) {  ///  tak... poszalałem.
            // // wiem że to wygląda strasznie, sorry nadal nie okiełznałem enum...
            case 2:
                Testplate.setImageResource(R.drawable.plate2);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("nic");
                Switchpic2.setText("8"); //*
                if(buttonId==1){score++;}
                break;
            case 3:
                Testplate.setImageResource(R.drawable.plate3);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("nic");
                Switchpic2.setText("29"); //*
                if(buttonId==2){ score++;}
                break;
            case 4:
                Testplate.setImageResource(R.drawable.plate4);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("5"); //*
                Switchpic2.setText("2");
                if(buttonId==2){ score++;}
                break;
            case 5:
                Testplate.setImageResource(R.drawable.plate5);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("5");
                Switchpic2.setText("3"); //*
                if(buttonId==1){ score++;}
                break;
            case 6:
                Testplate.setImageResource(R.drawable.plate6);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("15"); //*
                Switchpic2.setText("17");
                if(buttonId==2){ score++;}
                break;
            case 7:
                Testplate.setImageResource(R.drawable.plate7);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("74"); //*
                Switchpic2.setText("21");
                if(buttonId==1){ score++;}
                break;
            case 8:
                Testplate.setImageResource(R.drawable.plate8);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("nic");
                Switchpic2.setText("6"); //*
                if(buttonId==1){ score++;}
                break;
            case 9:
                Testplate.setImageResource(R.drawable.plate9);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("45"); //*
                Switchpic2.setText("nic");
                if(buttonId==2){ score++;}
                break;
            case 10:
                Testplate.setImageResource(R.drawable.plate10);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("5"); //*
                Switchpic2.setText("nic");
                if(buttonId==1){ score++;}
                break;
            case 11:
                Testplate.setImageResource(R.drawable.plate11);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("7"); //*
                Switchpic2.setText("nic");
                if(buttonId==1){ score++;}
                break;
            case 12:
                Testplate.setImageResource(R.drawable.plate12);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("16"); //*
                Switchpic2.setText("nic");
                if(buttonId==1){ score++;}
                break;
            case 13:
                Testplate.setImageResource(R.drawable.plate13);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("nic");
                Switchpic2.setText("73"); //*
                if(buttonId==1){ score++;}
                break;
            case 14:
                Testplate.setImageResource(R.drawable.plate14);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("nic"); //*
                Switchpic2.setText("5");
                if(buttonId==2){ score++;}
                break;
            case 15:
                Testplate.setImageResource(R.drawable.plate15);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("45");
                Switchpic2.setText("nic"); //*
                if(buttonId==1){ score++;}
                break;
            case 16:
                Testplate.setImageResource(R.drawable.plate16);
                Frage.setText("Ile cyfr jest widocznych?"); // 26
                Switchpic1.setText("2"); //*
                Switchpic2.setText("1");
                if(buttonId==2){ score++;}
                break;
            case 17:
                Testplate.setImageResource(R.drawable.plate17);
                Frage.setText("Ile cyfr jest widocznych?");
                Switchpic1.setText("1");
                Switchpic2.setText("2"); //*
                if(buttonId==1){ score++;}
                break;
            case 18:
                Testplate.setImageResource(R.drawable.plate18);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("Dwie linie"); //*
                Switchpic2.setText("Jedna linia\nlub żadna");
                if(buttonId==2){ score++;}
                break;
            case 19:
                Testplate.setImageResource(R.drawable.plate19);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("Jedna krzywa");
                Switchpic2.setText("nic"); //*
                if(buttonId==1){ score++;}
                break;
            case 20:
                Testplate.setImageResource(R.drawable.plate20);
                Frage.setText("Co widzisz?"); // linia
                Switchpic1.setText("jedna krzywa"); //*
                Switchpic2.setText("nic");
                if(buttonId==2){ score++;}
                break;
            case 21:
                Testplate.setImageResource(R.drawable.plate21);
                Frage.setText("Co widzisz?"); // linia
                Switchpic1.setText("jedna krzywa"); //*
                Switchpic2.setText("nic");
                if(buttonId==1){ score++;}
                break;
            case 22:
                Testplate.setImageResource(R.drawable.plate22);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("jedna krzywa"); // linia ***
                Switchpic2.setText("nic"); // nic
                if(buttonId==1){ score++;}
                break;
            case 23:
                Testplate.setImageResource(R.drawable.plate23);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("jedna krzywa"); // linia ***
                Switchpic2.setText("nic"); // nic
                if(buttonId==1){ score++;}
                break;
            case 24:
                Testplate.setImageResource(R.drawable.plate24);
                Frage.setText("Co widzisz?");
                Switchpic1.setText("nic"); // nic szczególnego
                Switchpic2.setText("jedna krzywa"); // linia ***
                if(buttonId==1){ score++;}
                break;

            case 25:
                if(buttonId==2){ score++;}
                Toast.makeText(this, "Odpowiedziałeś poprawnie na "+Integer.toString(score)+" z 24 pytań",Toast.LENGTH_LONG).show();
                if(score==24){
                    Toast.makeText(this, "To bardzo dobry wynik, nie masz problemu z percepcją barw.",Toast.LENGTH_LONG).show();
                } else if(score>20){
                    Toast.makeText(this, "To nienajgorszy wynik, w codziennym życiu radzisz sobie równie dobrze jak większość ludzi.",Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(this, "Twoja percepcja barw budzi niepokój, warto skontaktować się z lekarzem.",Toast.LENGTH_LONG).show();
                }
                finish();
                break;
        }
        if(score>score1) {
            Toast.makeText(this, "Odpowiedź poprawna", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Falsch", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daltonizm_test);
        Button Switchpic1 = findViewById(R.id.buttonA);
        Button Switchpic2 = findViewById(R.id.buttonB);
        Switchpic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchPic(v, 1);
            }
        });

        Switchpic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchPic(v, 2);
            }
        });
    }
}
