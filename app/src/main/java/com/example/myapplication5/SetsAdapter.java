package com.example.myapplication5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class SetsAdapter extends RecyclerView.Adapter<SetsAdapter.MyViewHolder> {

    Activity activity;
    RecycleViewOnClick recycleViewOnClick;
    List<String> setsList;

    public SetsAdapter (Activity activity,List<String> setsList, RecycleViewOnClick  recycleViewOnClick) {
        this.activity = activity;
        this.setsList = setsList;
        this.recycleViewOnClick = recycleViewOnClick;



    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.set_item_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setName.setText(setsList.get(position));
        /*AppInfoHolderModel app = appList.get(position);


        holder.appIcon.setImageBitmap(app.getIcon());
        holder.appName.setText(app.getName());
        switch (textColor){
            case "White":
                holder.appName.setTextColor(activity.getResources().getColor(R.color.white));
                break;
            case "Black":
                holder.appName.setTextColor(activity.getResources().getColor(R.color.black));
                break;
            case "Green":
                holder.appName.setTextColor(activity.getResources().getColor(R.color.green));
                break;
            case "Blue":
                holder.appName.setTextColor(activity.getResources().getColor(R.color.blue));
                break;
            case "Violet":
                holder.appName.setTextColor(activity.getResources().getColor(R.color.violet));
                break;*/
        //}

    }

    @Override
    public int getItemCount() {

        return setsList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView setName;


        public MyViewHolder(View itemView) {
            super(itemView);

            setName = itemView.findViewById(R.id.setName);
            setName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recycleViewOnClick.onItemClick(getAdapterPosition(), setsList.get(getAdapterPosition()));


                }
            });
        }
    }
}


