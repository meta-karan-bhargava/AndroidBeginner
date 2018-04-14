package com.assignment1.karan.assignmentthree;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SecondFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        String strtext = getArguments().getString("Message");
        TextView fragmentAText = (TextView)rootView.findViewById(R.id.fragmentBText);
        fragmentAText.append(" " + strtext);
        Toast.makeText(getContext(), strtext, Toast.LENGTH_SHORT).show();
        return rootView;
    }
}
