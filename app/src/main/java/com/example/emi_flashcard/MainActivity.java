package com.example.emi_flashcard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private boolean showingResult=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
            }
        });
        findViewById(R.id.flashcard_answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
                findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.answer_option1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.answer_option1).setBackgroundColor(getResources().getColor(R.color.myRedColor));
                findViewById(R.id.answer_option2).setBackgroundColor(getResources().getColor(R.color.myGreenColor));
            }
        });
        findViewById(R.id.answer_option2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.answer_option2).setBackgroundColor(getResources().getColor(R.color.myGreenColor));
            }
        });
        findViewById(R.id.answer_option3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.answer_option3).setBackgroundColor(getResources().getColor(R.color.myRedColor));
                findViewById(R.id.answer_option2).setBackgroundColor(getResources().getColor(R.color.myGreenColor));
            }
        });

        findViewById(R.id.eye_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showingResult){
                    ((ImageView) findViewById(R.id.eye_view)).setImageResource(R.drawable.ic_eye_hide);
                    findViewById(R.id.answer_option1).setVisibility(View.VISIBLE);
                    findViewById(R.id.answer_option2).setVisibility(View.VISIBLE);
                    findViewById(R.id.answer_option3).setVisibility(View.VISIBLE);
                    showingResult=false;
                } else {
                    ((ImageView) findViewById(R.id.eye_view)).setImageResource(R.drawable.ic_eye_view);
                    findViewById(R.id.answer_option1).setVisibility(View.INVISIBLE);
                    findViewById(R.id.answer_option2).setVisibility(View.INVISIBLE);
                    findViewById(R.id.answer_option3).setVisibility(View.INVISIBLE);
                    showingResult=true;
                }
            }
        });
        findViewById(R.id.rootView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
                findViewById(R.id.answer_option1).setVisibility(View.INVISIBLE);
                findViewById(R.id.answer_option2).setVisibility(View.INVISIBLE);
                findViewById(R.id.answer_option3).setVisibility(View.INVISIBLE);
            }
        });
        findViewById(R.id.my_add_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent someData = new Intent(MainActivity.this, AddCard.class);

                MainActivity.this.startActivityForResult(someData, 100);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 100){
            String question = data.getExtras().getString("question");
            String answer = data.getExtras().getString("answer");

            ((TextView) findViewById(R.id.flashcard_question)).setText(question);
            ((TextView) findViewById(R.id.flashcard_answer)).setText(answer);
        }

        Snackbar.make(findViewById(R.id.flashcard_question),
                "Card Successfully Created",
                Snackbar.LENGTH_SHORT).show();
    }

}
