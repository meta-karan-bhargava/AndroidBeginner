package com.assignment1.karan.assignmentthree;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FirstFragment extends Fragment implements View.OnClickListener {
    private Button buttonFtoParentA, buttonFtoF;
    private IFragmentToActivityListener mListener;
    private View rootView;
    private EditText editText1 , editText2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_first, container, false);
        initView(rootView);
        String strtext = getArguments().getString("Message");
        TextView fragmentAText = (TextView)rootView.findViewById(R.id.fragmentAText);
        fragmentAText.append(" " + strtext);
        Toast.makeText(getContext(), strtext, Toast.LENGTH_SHORT).show();
        return rootView;
    }
    public void initView(View parentView){

        buttonFtoParentA = (Button)rootView.findViewById(R.id.buttonFtoA);
        buttonFtoF = (Button)rootView.findViewById(R.id.buttonFtoF);
        buttonFtoF = (Button)rootView.findViewById(R.id.buttonFtoF);
        editText1 = (EditText)rootView.findViewById(R.id.editText1);
        editText2 = (EditText)rootView.findViewById(R.id.editText2);
        buttonFtoParentA.setOnClickListener(this);
        buttonFtoF.setOnClickListener(this);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IFragmentToActivityListener) {
            mListener = (IFragmentToActivityListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onClick(View v) {
            if(v.getId()== R.id.buttonFtoA) {
                if (mListener != null) {
                    Integer numberOne = Integer.parseInt(editText1.getText().toString());
                    Integer numberTwo = Integer.parseInt(editText2.getText().toString());
                    mListener.addNumbers(numberOne, numberTwo);

                }
            }else if(v.getId() == R.id.buttonFtoF) {
                if (mListener != null) {
                    mListener.communicateToOtherFragment("Called From Fragment A");
                }
            }
    }

    public interface IFragmentToActivityListener {
        void addNumbers(int firstNo, int secondNo);
        void communicateToOtherFragment(String message);
    }


    }



