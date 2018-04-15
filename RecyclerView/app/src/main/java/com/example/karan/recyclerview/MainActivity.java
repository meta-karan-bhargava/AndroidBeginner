package com.example.karan.recyclerview;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private PlaceHolder mplaceHolder;
    private LinearLayoutManager mLayoutManager;
    private GridLayoutManager mGridManager;
    private String[] myDataset = new String[10];
    private Integer[] myImages = new Integer[10];
    private final Integer SPAN_COUNT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initialize the dataset
        initDataset();
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        // handle layout on orientation change
        mLayoutManager = new LinearLayoutManager(this);
        mGridManager = new GridLayoutManager(this, SPAN_COUNT);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            mRecyclerView.setLayoutManager(mLayoutManager);
        }
        else {
            mRecyclerView.setLayoutManager(mGridManager);
        }
        mplaceHolder = new PlaceHolder(myDataset, myImages);
        // specify an adapter
        mAdapter = new MyAdapter(mplaceHolder);
        mRecyclerView.setAdapter(mAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
    }
    private void initDataset() {
        for(int i=0; i<=9; i++) {
            myDataset[i] = "Dataset " + i;
            myImages[i] = R.drawable.ic_if__android_1156668;
        }

    }
}
