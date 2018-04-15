package com.example.karan.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] mDataset;
    private Integer[] mImages;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public LinearLayout mLinearLayout;
        public TextView mTextView;
        public PlaceHolder mPlaceHolder;
        public ImageView mImageView;
        public ViewHolder(TextView v, ImageView iv) {
            super((View) v.getParent());
            mTextView = v;
            mImageView = iv;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(PlaceHolder mPlaceHolder) {
        mDataset = mPlaceHolder.mDataSet;
        mImages = mPlaceHolder.mImages;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LinearLayout ll = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        //mLinearLayout = ll;
        TextView v = (TextView) ll.findViewById(R.id.textView);
        ImageView iv = (ImageView)ll.findViewById(R.id.imageView);
        ViewHolder vh = new ViewHolder(v, iv);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset[position]);
        holder.mImageView.setImageResource(mImages[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
