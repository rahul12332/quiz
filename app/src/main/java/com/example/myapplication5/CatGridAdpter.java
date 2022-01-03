package com.example.myapplication5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


class CatGridAdapter extends RecyclerView.Adapter<CatGridAdapter.MyViewHolder> {

    Activity activity;
    RecycleViewOnClick recycleViewOnClick;
    List<String> catList;

    public CatGridAdapter(Activity activity,List<String> catList, RecycleViewOnClick recycleViewOnClick) {
        this.activity = activity;
        this.catList = catList;
        this.recycleViewOnClick = recycleViewOnClick;
        

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_item_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.CatName.setText(catList.get(position));
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

        return catList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView CatName;


        public MyViewHolder(View itemView) {
            super(itemView);

            CatName = itemView.findViewById(R.id.CatName);
            CatName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recycleViewOnClick.onItemClick(getAdapterPosition(),catList.get(getAdapterPosition()));
                }
            });
        }
    }
}
