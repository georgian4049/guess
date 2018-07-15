package com.example.ayush.guess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.widget.Button;
import java.lang.Throwable;

import java.util.Random;


import android.view.View;

import java.util.Random;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity  {
    private EditText input1;
    private Button submit;
    private TextView tv3;
    public int n2;
    private Button btnexit;
    public int j=5;
    private TextView tv5;
    private Button start;
    Random r = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = (EditText) findViewById(R.id.ip);
        submit = (Button) findViewById(R.id.submit);
        btnexit = (Button)findViewById(R.id.btn_exit);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv3.setText(" Attempt Left : 5");
        start=(Button)findViewById(R.id.start);
        n2=r.nextInt(100);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {







                System.exit(1);


            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                start();
            }
        });


        submit.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                guess();
                input1.setText("");


            }
        });
    }
    void start()
    {
        j=5;
        n2=r.nextInt(100);
        input1.setText("");
        tv5.setText("");
        tv3.setText("Attempt Left :"+j);
        submit.setVisibility(View.VISIBLE);
    }
    void guess() {

        int n1 = Integer.valueOf(input1.getText().toString());
        j--;
        for (int i = 0; i < 5; i++) {
            if (n1 < n2) {
                tv5.setText("You Guessed  no: "+n1+" "+" is smaller");
                tv3.setText(" Attempt Left :"+ j);

            }
            else if (n1 > n2 ) {
                tv5.setText("You Guessed no: "+n1+" "+ "is larger ");
                tv3.setText(" Attempt Left :"+ j);
            }
            else if (n1 == n2) {

                tv5.setText("Congo !! you Guessed correct no: " +n1+" in " +(5-j) + "attempts");

                start.setText("Play Again");
                j=5;
                submit.setVisibility(View.GONE);
                break;

            }
            if(j==0)
            {
                tv5.setText("Sorry "+n1+" "+" is wrong guess...Better lucknext time");
                j=5;
                submit.setVisibility(View.GONE);
                break;

            }
            if(n1==NULL)
            {
                tv5.setText("enter something");
            }
            if(n1<0 || n1>100)
            {
                tv5.setText("enter the value between 0-100");
            }
        }



    }
}

