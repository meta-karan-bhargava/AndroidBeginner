package com.example.karan.formcontrols;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class FeedbackSummary extends AppCompatActivity {
    private TextView name,email,feedbackType,feedback,response,rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary_feedback);
        init();
        processIntentInformation();
    }

    public void init() {

        name = (TextView)findViewById(R.id.nameLabel);
        email = (TextView)findViewById(R.id.emailLabel);
        feedbackType = (TextView)findViewById(R.id.feedbackTypeLabel);
        feedback = (TextView)findViewById(R.id.feedbackLabel);
        response = (TextView)findViewById(R.id.responseLabel);
        rating = (TextView)findViewById(R.id.ratingLabel);
    }

    public void processIntentInformation() {

        Intent summaryIntent = getIntent();
        name.append(": " + summaryIntent.getStringExtra("Name")+ "\n");
        email.append(": " + summaryIntent.getStringExtra("Email")+ "\n");
        feedbackType.append(": " + summaryIntent.getStringExtra("FeedbackType")+ "\n");
        feedback.append(": " + summaryIntent.getStringExtra("Feedback")+ "\n");
        response.append(": " + summaryIntent.getStringExtra("SendEmail") + "\n");
        rating.append(": " + summaryIntent.getFloatExtra("Rating", 0.0f) + "\n");

    }

}
