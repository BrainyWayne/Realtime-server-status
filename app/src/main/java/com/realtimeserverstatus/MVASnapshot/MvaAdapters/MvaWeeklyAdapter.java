package com.realtimeserverstatus.MVASnapshot.MvaAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.realtimeserverstatus.MVASnapshot.MvaUtil.MvaModels;
import com.realtimeserverstatus.R;

import java.util.List;

public class MvaWeeklyAdapter extends RecyclerView.Adapter<MvaWeeklyAdapter.MyViewHolder> {

    private List<MvaModels> mvaModelsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView total, year;

        public MyViewHolder(View view) {
            super(view);
            total =  view.findViewById(R.id.year_total);
            year =  view.findViewById(R.id.year);
        }
    }


    public MvaWeeklyAdapter(List<MvaModels> mvaModelsList) {
        this.mvaModelsList = mvaModelsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mva_year_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MvaModels mvaModels = mvaModelsList.get(position);
        holder.year.setText(mvaModels.getYear());
        holder.total.setText(String.valueOf(mvaModels.getTotal()));
    }

    @Override
    public int getItemCount() {
        return mvaModelsList.size();
    }
}