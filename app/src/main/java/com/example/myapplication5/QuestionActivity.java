package com.example.myapplication5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener{
    AppCompatButton button1,button2,button3,button4,next_button;
    TextView qcount,question,timer;
    List<QuestionList> questionLists;
    int next = 1, last, answer, total_correct_answer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        next_button=findViewById(R.id.next_button);
        qcount= findViewById(R.id.Question_Number);
        question= findViewById(R.id.question);
        timer= findViewById(R.id.countdown);

        questionLists=new ArrayList<>();

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        next_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundDrawable(getDrawable(R.drawable.new_opbt));
                button2.setBackgroundDrawable(getDrawable(R.drawable.new_opbt));
                button3.setBackgroundDrawable(getDrawable(R.drawable.new_opbt));
                button4.setBackgroundDrawable(getDrawable(R.drawable.new_opbt));

                if (next< last) {
                    setData(next);
                    next++;
                }else {
                    QuestionActivity.this.finish();
                    startActivity(new Intent(QuestionActivity.this, ScoreActivity.class).putExtra("total",total_correct_answer));
                }
            }
        });

        getQuestionList();


        Intent in = getIntent();
        String category = in.getStringExtra("category");
        String set = in.getStringExtra("set");







        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference root = db.getReference("Category").child(category).child(set);
        root.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    for (DataSnapshot s : snapshot.getChildren()) {
                        String QuNu = s.getKey();
                        String Qu = String.valueOf(s.child("question").getValue().toString());
                        String Ans = s.child("answer").getValue().toString();
                        String O1 = s.child("option1").getValue().toString();
                        String O2 = s.child("option2").getValue().toString();
                        String O3 = s.child("option3").getValue().toString();
                        String O4 = s.child("option4").getValue().toString();
                        questionLists.add(new QuestionList(QuNu, Qu,O1, O2, O3, O4,Ans));


                    }

                    timer.setText(String.valueOf(10));
                    last = questionLists.size();
                    setData(0);




                    startTimer();



                }


            }

            /*private void setData(int i) {


            }*/

            public void startTimer(){
                CountDownTimer countDownTimer = new CountDownTimer(1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        timer.setText(String.valueOf(millisUntilFinished/1000));

                    }

                    @Override
                    public void onFinish() {
                        //changeQuestion();

                    }
                };
                countDownTimer.start();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });


    }

    private void setData(int i) {
        QuestionList q = questionLists.get(i);
        qcount.setText(q.getArrayQuNu());
        question.setText(q.getArrayQu());
        button1.setText(q.getArrayO1());
        button2.setText(q.getArrayO2());
        button3.setText(q.getArrayO3());
        button4.setText(q.getArrayO4());
        answer = q.getArrayAns();
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    public void getQuestionList(){

    }

    @Override
    public void onClick(View v) {
        button1.setOnClickListener(null);
        button2.setOnClickListener(null);
        button3.setOnClickListener(null);
        button4.setOnClickListener(null);
        switch (v.getId()){
            case R.id.button1:
                if (answer == 1){
                    button1.setActivated(true);
                    total_correct_answer++;
                    //button1.setBackgroundColor(getColor(R.color.yellow));
                }else{
                    button1.setActivated(false);
                    switch(answer){
                        case 2:
                            button2.setActivated(true);
                            button2.setBackgroundDrawable(getDrawable(R.drawable.result_button_color));
                            break;
                        case 3:
                            button3.setActivated(true);
                            button3.setBackgroundDrawable(getDrawable(R.drawable.result_button_color));
                            break;
                        case 4:
                            button4.setActivated(true);
                            button4.setBackgroundDrawable(getDrawable(R.drawable.result_button_color));
                            break;
                    }

                }
                button1.setBackgroundDrawable(getDrawable(R.drawable.result_button_color));
                break;

            case R.id.button2:
                if (answer == 2){
                    button2.setActivated(true);
                    total_correct_answer++;

                }else{
                    button2.setActivated(false);
                    switch(answer){
                        case 2:
                            button1.setActivated(true);
                            button1.setBackgroundDrawable(getDrawable(R.drawable.result_button_color));
                            break;
                        case 3:
                            button3.setActivated(true);
                            button3.setBackgroundDrawable(getDrawable(R.drawable.result_button_color));
                            break;
                        case 4:
                            button4.setActivated(true);
                            button4.setBackgroundDrawable(getDrawable(R.drawable.result_button_color));
                            break;
                    }

                }
                button2.setBackgroundDrawable(getDrawable(R.drawable.result_button_color));

                break;

            case R.id.button3:
                if (answer == 3){
                    button3.setActivated(true);
                    total_correct_answer++;

                }else{
                    button3.setActivated(false);
                    switch(answer){
                        case 2:
                            button1.setActivated(true);
                            button1.setBackgroundDrawable(getDrawable(R.drawable.result_button_color));
                            break;
                        case 3:
                            button2.setActivated(true);
                            button2.setBackgroundDrawable(getDrawable(R.drawable.result_button_color));
                            break;
                        case 4:
                            button4.setActivated(true);
                            button4.setBackgroundDrawable(getDrawable(R.drawable.result_button_color));
                            break;
                    }
                }
                button3.setBackgroundDrawable(getDrawable(R.drawable.result_button_color));
                break;

            case R.id.button4:
                if (answer == 4){
                    button4.setActivated(true);
                    total_correct_answer++;

                }else{
                    button4.setActivated(false);
                    switch(answer){
                        case 2:
                            button1.setActivated(true);
                            button1.setBackgroundDrawable(getDrawable(R.drawable.result_button_color));
                            break;
                        case 3:
                            button2.setActivated(true);
                            button2.setBackgroundDrawable(getDrawable(R.drawable.result_button_color));
                            break;
                        case 4:
                            button3.setActivated(true);
                            button3.setBackgroundDrawable(getDrawable(R.drawable.result_button_color));
                            break;
                    }
                }
                button4.setBackgroundDrawable(getDrawable(R.drawable.result_button_color));
                break;
            default:

        }
    }
}