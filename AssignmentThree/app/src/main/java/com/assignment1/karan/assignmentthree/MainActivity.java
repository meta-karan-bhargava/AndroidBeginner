package com.assignment1.karan.assignmentthree;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FirstFragment.IFragmentToActivityListener {
    Button buttonAtoF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAtoF = (Button) findViewById(R.id.buttonAtoF);
        buttonAtoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                Bundle bundle = new Bundle();
                bundle.putString("Message", "Called from Main Activity");
                    Fragment newFragment = new FirstFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.add(R.id.fragment_container, newFragment);
                    transaction.commit();
                    newFragment.setArguments(bundle);
                    buttonAtoF.setActivated(false);
                    buttonAtoF.setVisibility(View.INVISIBLE);
                }catch(Exception e)
                {
                    Log.v("Error", e.getLocalizedMessage());
                }
            }
        });

    }

    @Override
    public void addNumbers(int firstNo, int secondNo) {
        int sum = firstNo + secondNo;
        String message = "Adding two nos in MainActivity\n";
        message += "The sum of " + firstNo + " and " + secondNo + " is";
        Toast.makeText(this, message + sum, Toast.LENGTH_LONG).show();
    }
}
