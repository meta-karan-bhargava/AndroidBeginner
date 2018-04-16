package com.example.karan.formcontrols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText name,email,feedback;
    private CheckBox responseCheckbox;
    private Spinner feedbackSpinner;
    private RatingBar rBar;
    private Button feedbackSubmitButton;
    private List<EditText> fieldsToValidate;
    private String custName = "", custEmail = "", custFeedback = "", custFeedbackType = "";
    private Boolean sendEmail = false;
    private Float rating = 0.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initForm();
        feedbackSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                extractDetails();
                if(validateForm(fieldsToValidate))
                    sendFeedback();
            }
        });

    }

    public void sendFeedback() {
        Intent feedbackIntent = new Intent(this, FeedbackSummary.class);
        feedbackIntent.putExtra("Name", custName);
        feedbackIntent.putExtra("Email", custEmail);
        feedbackIntent.putExtra("FeedbackType", custFeedbackType);
        feedbackIntent.putExtra("Feedback", custFeedback);
        if(sendEmail)
            feedbackIntent.putExtra("SendEmail", "Yes");
        else
            feedbackIntent.putExtra("SendEmail", "No");
        feedbackIntent.putExtra("Rating", rating);
        startActivity(feedbackIntent);
    }

    public void initForm() {

        name = (EditText) findViewById(R.id.EditTextName);
        email = (EditText) findViewById(R.id.EditTextEmail);
        feedback = (EditText) findViewById(R.id.EditTextFeedbackBody);
        feedbackSpinner = (Spinner) findViewById(R.id.SpinnerFeedbackType);
        feedbackSubmitButton = (Button)findViewById(R.id.ButtonSendFeedback);
        fieldsToValidate = new ArrayList<EditText>();
        fieldsToValidate.add(name);
        fieldsToValidate.add(email);
        responseCheckbox = (CheckBox) findViewById(R.id.CheckBoxResponse);
        rBar = (RatingBar)findViewById(R.id.ratingBar);
    }
    public void extractDetails() {

        custName = name.getText().toString();
        custEmail = email.getText().toString();
        custFeedback = feedback.getText().toString();
        custFeedbackType = feedbackSpinner.getSelectedItem().toString();
        sendEmail = responseCheckbox.isChecked();
        rating = rBar.getRating();
    }
    public boolean validateForm(List<EditText> editTexts) {

        for(TextView editText: editTexts) {
            if(editText == null || (editText.getText().toString()).isEmpty()) {
                editText.setError(editText.getHint() + " cannot be empty");
                return false;
            }
        }
        return true;
    }
}
