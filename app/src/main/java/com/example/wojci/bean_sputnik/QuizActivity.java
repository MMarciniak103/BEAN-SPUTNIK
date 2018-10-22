// package beanmm.beanquiz;
package com.example.wojci.bean_sputnik; //musiałem zmienić nazwę pakietu żeby to pasowało do mojej paczki // SYROP

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class QuizActivity extends AppCompatActivity {

    public static final String EXTRA_SCORE="extraScore";
    public static final String KEY_SCORE="keyScore";
    public static final String KEY_QUESTION_COUNT="keyQuestionCount";
    public static final String KEY_ANSWERED="keyAnswered";
    public static final String KEY_QUESTION_LIST="keyQuestionList";

    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewQuestion;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private Button buttonConfirmNext;

    private ColorStateList textColorDefaultRb;

    private ArrayList<Question> questionList;

    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;

    private int score;
    private boolean answered;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);

        textViewQuestion=findViewById(R.id.text_view_question);
        textViewScore=findViewById(R.id.text_view_score);
        textViewQuestionCount=findViewById(R.id.text_view_question_count);
        rbGroup=findViewById(R.id.radio_group);
        rb1=findViewById(R.id.radio_button1);
        rb2=findViewById(R.id.radio_button2);
        rb3=findViewById(R.id.radio_button3);
        buttonConfirmNext=findViewById(R.id.button_confirm_next);

        textColorDefaultRb = rb1.getTextColors();
        //dbamy o ciaglasc trwania logiki aplikacji podczas obrotu ekranu
        if(savedInstanceState==null){
//            beanm.beanquiz.QuizDb quizDb=new beanm.beanquiz.QuizDb(this);
            com.example.wojci.bean_sputnik.QuizDb quizDb=new com.example.wojci.bean_sputnik.QuizDb(this); //podmianka ścieżki // SYROP
            questionList=quizDb.getAllQuestions();
            questionCountTotal=20;
            Collections.shuffle(questionList);

            showNextQuestion();
        }else{
            questionList=savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST);
            questionCountTotal=20;
            questionCounter=savedInstanceState.getInt(KEY_QUESTION_COUNT);
            currentQuestion=questionList.get(questionCounter-1);
            score=savedInstanceState.getInt(KEY_SCORE);
            answered=savedInstanceState.getBoolean(KEY_ANSWERED);

            if(answered){
                showSolution();
            }
        }
        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered){
                    if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked()){
                        checkAnswer();
                    }else{
                        Toast.makeText(QuizActivity.this,"Please select an answer",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion(){
        rb1.setTextColor(textColorDefaultRb);
        rb1.setClickable(true);
        rb2.setTextColor(textColorDefaultRb);
        rb2.setClickable(true);
        rb3.setTextColor(textColorDefaultRb);
        rb3.setClickable(true);
        rbGroup.clearCheck();

        if(questionCounter<questionCountTotal){
            currentQuestion=questionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());

            questionCounter++;
            textViewQuestionCount.setText("Question "+questionCounter+"/"+questionCountTotal);
            answered=false;
            buttonConfirmNext.setText("Confirm");
        }else{
            finishQuiz();
        }
    }

    private void checkAnswer(){
        answered=true;
        RadioButton rbSelected=findViewById(rbGroup.getCheckedRadioButtonId());
        rb1.setClickable(false);
        rb2.setClickable(false);
        rb3.setClickable(false);
        int answerNr=rbGroup.indexOfChild(rbSelected)+1;

        if(answerNr==currentQuestion.getAnswerNr()){
            score++;
            textViewScore.setText("Score: "+score);
        }
        showSolution();
    }

    private void showSolution(){
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNr()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 1 is correct");
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 2 is correct");
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 3 is correct");
                break;
        }

        if(questionCounter<questionCountTotal){
            buttonConfirmNext.setText("Next");
        }else{
            buttonConfirmNext.setText("Finish");
        }
    }

    private void finishQuiz(){
        Intent resultIntent=new Intent();
        resultIntent.putExtra(EXTRA_SCORE,score);
        setResult(RESULT_OK,resultIntent);
        finish();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE,score);
        outState.putInt(KEY_QUESTION_COUNT,questionCounter);
        outState.putBoolean(KEY_ANSWERED,answered);
        outState.putParcelableArrayList(KEY_QUESTION_LIST,questionList);
    }
}
