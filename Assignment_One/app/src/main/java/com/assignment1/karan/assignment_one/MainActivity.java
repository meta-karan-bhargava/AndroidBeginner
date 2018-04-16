package com.assignment1.karan.assignment_one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initiate progress bar and start button
        final ProgressBar simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);
        Button startButton = (Button) findViewById(R.id.startButton);
        // perform click event on button
        final TextView TextString = (TextView)findViewById(R.id.TextString);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // visible the progress bar
                simpleProgressBar.setVisibility(View.VISIBLE);

                EditText editText = (EditText)findViewById(R.id.editText);
                String content = editText.getText().toString(); //gets you the contents of edit text
                if(content.isEmpty()) {
                    TextString.append("");
                }else {
                    TextString.append(" " + content);
                }
                TextString.setVisibility(View.VISIBLE);
            }
        });
    }
}
