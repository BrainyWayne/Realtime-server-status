package com.realtimeserverstatus.ServerStatus.models;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.realtimeserverstatus.R;

import java.util.List;

public class ServerAdapter extends RecyclerView.Adapter<ServerAdapter.MyViewHolder> {

    private List<Server> serverList;
     Server Server;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description, cpu;
        public RelativeLayout mainContent;

        public MyViewHolder(View view) {
            super(view);
            name =  view.findViewById(R.id.servername);
            description =  view.findViewById(R.id.serverdescription);
            cpu =  view.findViewById(R.id.servercpu);
            mainContent = view.findViewById(R.id.main_content);
        }
    }




    public ServerAdapter(List<Server> serverList) {
        this.serverList = serverList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.server_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Server = serverList.get(position);
        holder.name.setText(Server.getName());
        holder.description.setText(Server.getDescription());
        holder.cpu.setText(String.valueOf(Server.getCpu()));


    }




    @Override
    public int getItemCount() {
        return serverList.size();
    }
}