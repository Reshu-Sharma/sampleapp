package com.example.sampleapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sampleapp.R;
import com.example.sampleapp.model.DataModel;
import com.example.sampleapp.model.Rows;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContentListAdapter extends RecyclerView.Adapter<ContentListAdapter.ViewHolder> {

    public ArrayList<Rows> rows;
    public Context context;

    public ContentListAdapter(ArrayList<Rows> rows,Context context){
        this.rows = rows;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View contentItem = inflater.inflate(R.layout.content_list_item, viewGroup, false);

        return new ViewHolder(contentItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.textTitle.setText(rows.get(position).getTitle());
        viewHolder.textDescription.setText(rows.get(position).getDescription());
        Glide.with(context).load(rows.get(position).getImageHref()).into(viewHolder.imageView);
        viewHolder.textTitle.setText(rows.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textTitle;
        public TextView textDescription;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.txttitle);
            textDescription = itemView.findViewById(R.id.txtdescription);
            imageView = itemView.findViewById(R.id.imgView);
        }
    }
}
