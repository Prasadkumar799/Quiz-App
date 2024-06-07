package com.example.quizapp;

import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView questionTextView;
    TextView totalQuestionTextView;
    Button optionA, optionB, optionC, optionD;
    Button submit;

    int score = 0;
    int totalQuestions = QuestionAnswer.questions.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalQuestionTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        optionA = findViewById(R.id.option_A);
        optionB = findViewById(R.id.option_B);
        optionC = findViewById(R.id.option_C);
        optionD = findViewById(R.id.option_D);
        submit = findViewById(R.id.submit);

        optionA.setOnClickListener(this);
        optionB.setOnClickListener(this);
        optionC.setOnClickListener(this);
        optionD.setOnClickListener(this);
        submit.setOnClickListener(this);

        totalQuestionTextView.setText("Total_question: " + totalQuestions);
        loadNewQuestion();
    }

    private void loadNewQuestion() {
        if (currentQuestionIndex == totalQuestions) {
            finishQuiz();
            return;
        }
        questionTextView.setText(QuestionAnswer.questions[currentQuestionIndex]);
        optionA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        optionB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        optionC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        optionD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);

        selectedAnswer = "";
    }

    private void finishQuiz() {
        String passStatus;
        if (score >= totalQuestions * 0.6) {
            passStatus = "Passed";
        } else {
            passStatus = "Failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Your Score is " + score + " Out of " + totalQuestions)
                .setPositiveButton("Restart", ((dialog, i) -> restartQuiz()))
                .setCancelable(false)
                .show();
    }

    private void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        optionA.setBackgroundColor(Color.WHITE);
        optionB.setBackgroundColor(Color.WHITE);
        optionC.setBackgroundColor(Color.WHITE);
        optionD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.submit) {
            if (!selectedAnswer.isEmpty()) {
                if (selectedAnswer.equals(QuestionAnswer.correctanswer[currentQuestionIndex])) {
                    score++;
                } else {
                    clickedButton.setBackgroundColor(Color.GRAY);
                }
                currentQuestionIndex++;
                loadNewQuestion();
            }
            else {
            }
        }
        else{
                selectedAnswer = clickedButton.getText().toString();
                clickedButton.setBackgroundColor(Color.YELLOW);
            }


    }

}