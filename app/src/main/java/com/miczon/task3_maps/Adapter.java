package com.miczon.task3_maps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Model> list;
    private Context context;

    public Adapter(List<Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.id.setText(String.valueOf(position));
            holder.address.setText(list.get(position).getAddress());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return list.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder  {
       private TextView address,id;

        ViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textView_id);
            address = itemView.findViewById(R.id.textView_address);
        }
    }
}