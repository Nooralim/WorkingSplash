package com.example.nazo.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nazo on 12/2/2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    ArrayList<Country> mArrayList = new ArrayList<>();
    RecyclerAdapter(ArrayList<Country> arrayList){
        this.mArrayList = arrayList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rows,parent,false);
        return new MyViewHolder(view);



    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.pic_pictures.setImageResource(mArrayList.get(position).getPicture_id());
        holder.p_names.setText(mArrayList.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView pic_pictures;
        TextView p_names;


        public MyViewHolder(View itemView) {
            super(itemView);
            pic_pictures = (ImageView) itemView.findViewById(R.id.Apples);
            p_names = (TextView) itemView.findViewById(R.id.name);  //careful mo
        }
    }

    public void setFilter(ArrayList<Country> anotherList){

        mArrayList = new ArrayList<>();
        mArrayList.addAll(anotherList);
        notifyDataSetChanged();     //refreshes adapter when changes made

    }
}
