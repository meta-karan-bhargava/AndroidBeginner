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


public class FirstFragment extends Fragment {
    private Button buttonFtoParentA;
    private IFragmentToActivityListener mListener;
    private View rootView;
    private EditText editText1 , editText2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_first, container, false);
        buttonFtoParentA = (Button)rootView.findViewById(R.id.buttonFtoA);
        editText1 = (EditText)rootView.findViewById(R.id.editText1);
        editText2 = (EditText)rootView.findViewById(R.id.editText2);
        buttonFtoParentA.setOnClickListener(onClickListener);
        String strtext = getArguments().getString("Message");
        TextView fragmentAText = (TextView)rootView.findViewById(R.id.fragmentAText);
        fragmentAText.append(" " + strtext);
        Toast.makeText(getContext(), strtext, Toast.LENGTH_SHORT).show();
        return rootView;
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
    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mListener != null) {
                Integer numberOne = Integer.parseInt(editText1.getText().toString());
                Integer numberTwo = Integer.parseInt(editText2.getText().toString());
                mListener.addNumbers(numberOne, numberTwo);
            }
        }

    };

    public interface IFragmentToActivityListener {
        void addNumbers(int firstNo, int secondNo);
    }

    }



