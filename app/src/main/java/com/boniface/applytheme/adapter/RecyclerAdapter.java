package com.boniface.applytheme.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boniface.applytheme.R;
import com.boniface.applytheme.model.Landscape;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private static final String TAG = RecyclerAdapter.class.getSimpleName();
    private List<Landscape> mData;
    private LayoutInflater mInflater;

    public  RecyclerAdapter(Context context, List<Landscape> data){
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View view = mInflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder"+ position);
        Landscape current = mData.get(position);
        holder.setData(current, position);
        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  void removeItem(int position){
        mData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mData.size());
//        we can use notifyDataSetChanged but no animation. Recreates the views.
    }

    public void addItem(int position, Landscape landscape){
        mData.add(position, landscape);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, mData.size());
    }



    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        ImageView imgThumb, imgDelete, imgAdd;
        int position;
        Landscape current;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            imgThumb = itemView.findViewById(R.id.img_row);
            imgDelete = itemView.findViewById(R.id.img_row_delete);
            imgAdd = itemView.findViewById(R.id.img_row_add);
        }

        public void setData(Landscape current, int position) {
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageID());
            this.position = position;
            this.current = current;
        }

        public void setListeners(){
            imgDelete.setOnClickListener(MyViewHolder.this);
            imgAdd.setOnClickListener(MyViewHolder.this);
        }

        @Override
        public void onClick(View v) {
            Log.i(TAG, "onClick before operation at Position " + position + " Size " + mData.size());
            switch (v.getId()){
                case R.id.img_row_delete:
                    removeItem(position);
                    break;

                case R.id.img_row_add:
                    addItem(position, current);
                    break;
            }
            Log.i(TAG, "onClick after operation - Size " + mData.size());

        }
    }

}
