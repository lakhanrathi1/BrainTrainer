package com.example.lakhan.braintrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button startbutton,button0,button1,button2,button3,easy,medium,hard;
    int loc_ans;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int score=0;
    TextView result,scoretext,sum,timer;
    int no_que=0,cor_ans=0;
    int inc_ans,level=10;
    Button playagnain;
    ConstraintLayout first,second;


    public void play(View view){

        score=0;
        no_que=0;

        timer.setText("30 sec");
        scoretext.setText("0/0");
        result.setText("");
        playagnain.setVisibility(View.INVISIBLE);
        if(level==0) {
            generateeasy();
        }else if (level==1){
            generatemedium();
        }else if (level==2){
            generatehard();
        }

        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                timer.setText(String.valueOf(millisUntilFinished/1000)+"sec");

            }

            @Override
            public void onFinish() {
                timer.setText("0 sec");
                result.setText("Your score:" +Integer.toString(score) + "/" + Integer.toString(no_que ) );

                playagnain.setVisibility(View.VISIBLE);
            }
        }.start();


    }



    public void generatemedium(){

        Random rand = new Random();

        int a = rand.nextInt(100);
        int b = rand.nextInt(100);

        sum.setText(Integer.toString(a)+"+"+Integer.toString(b));

        loc_ans=rand.nextInt(4);
        answers.clear();


        for (int i = 0;i<4;i++){

            if (i==loc_ans){

                answers.add(a+b);
            }
            else {

                inc_ans=rand.nextInt(200);

                while(inc_ans==a+b){
                    inc_ans=rand.nextInt(200);
                }
                answers.add(inc_ans);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));


    }
    public void generateeasy(){

        Random rand = new Random();

        int a = rand.nextInt(10);
        int b = rand.nextInt(10);

        sum.setText(Integer.toString(a)+"+"+Integer.toString(b));

        loc_ans=rand.nextInt(4);
        answers.clear();


        for (int i = 0;i<4;i++){

            if (i==loc_ans){

                answers.add(a+b);
            }
            else {

                inc_ans=rand.nextInt(100);

                while(inc_ans==a+b){
                    inc_ans=rand.nextInt(100);
                }
                answers.add(inc_ans);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));


    }


    public void generatehard(){

        Random rand = new Random();

        int a = rand.nextInt(1000);
        int b = rand.nextInt(1000);

        sum.setText(Integer.toString(a)+"+"+Integer.toString(b));

        loc_ans=rand.nextInt(4);
        answers.clear();


        for (int i = 0;i<4;i++){

            if (i==loc_ans){

                answers.add(a+b);
            }
            else {

                inc_ans=rand.nextInt(2000);

                while(inc_ans==a+b){
                    inc_ans=rand.nextInt(2000);
                }
                answers.add(inc_ans);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));


    }

    public void answer(View view){

        if(view.getTag().toString().equals(Integer.toString(loc_ans))){

            score++;
            result.setText("Corret!");

        }
        else {
            result.setText("Wrong!");

        }
        no_que++;
        scoretext.setText(Integer.toString(score) + "/" + Integer.toString(no_que ));
        if(level==0) {
            generateeasy();
        }else if (level==1){
            generatemedium();
        }else if (level==2){
            generatehard();
        }

    }

    public  void  playeasy(View view){

        level=0;
        first.setVisibility(View.INVISIBLE);
        second.setVisibility(View.VISIBLE);
        play(findViewById(R.id.PlayButton));


    }
    public  void  playmedium(View view){

        level=1;
        first.setVisibility(View.INVISIBLE);
        second.setVisibility(View.VISIBLE);
        play(findViewById(R.id.PlayButton));


    }

    public  void  playhard(View view){

        level=2;
        first.setVisibility(View.INVISIBLE);
        second.setVisibility(View.VISIBLE);
        play(findViewById(R.id.PlayButton));


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        first = (ConstraintLayout)findViewById(R.id.firstlayout);
        second = (ConstraintLayout)findViewById(R.id.secondlayout);
        easy = (Button)findViewById(R.id.EasyButton);
        medium = (Button)findViewById(R.id.MediumButton);
        hard = (Button)findViewById(R.id.HardButton);

        sum = (TextView)findViewById(R.id.sumtext);
        button0 = (Button)findViewById(R.id.button0);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        result = (TextView)findViewById(R.id.displaytext);
        scoretext = (TextView)findViewById(R.id.scoretext);
        timer = (TextView)findViewById(R.id.timertext);
        playagnain=(Button)findViewById(R.id.PlayButton);


      //  generate();




    }
}
