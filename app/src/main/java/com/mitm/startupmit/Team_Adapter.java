package com.mitm.startupmit;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import static android.content.ContentValues.TAG;

public class Team_Adapter extends RecyclerView.Adapter<Team_Adapter.TeamViewHolder> {

    View mView;
    private Context mCtx;
    private List<Team_Model> teamList;

    public Team_Adapter(Context mCtx, List<Team_Model> teamList) {
        this.mCtx = mCtx;
        this.teamList = teamList;
    }

    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.prototype_team_member, null);

        return new TeamViewHolder(view);


    }

//    (int id, String name, String email, int batch, String url, String designation, int image


    @Override
    public void onBindViewHolder(final TeamViewHolder holder, int position) {
        final Team_Model team_model = teamList.get(position);
        Log.d(TAG, "onBindViewHolder: " + "Hey");


        holder.name.setText(team_model.getName());
//        holder.batch.setText(team_model.getBatch());
        String url = team_model.getUrl();
        Glide.with(mCtx)
                .load(url)
                .placeholder(R.drawable.startup_logo)
                .into(holder.imageView);



        //    (int id, String name, String email, int batch, String url, String designation
        holder.proto_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: " + 1);
                Intent intent = new Intent(mCtx, MemberDetails.class);
                intent.putExtra("id", ""+ team_model.getId()); //int
                intent.putExtra("name", team_model.getName());
                intent.putExtra("email", team_model.getEmail());
                intent.putExtra("batch", team_model.getBatch());
                intent.putExtra("designation", team_model.getDesignation());
                intent.putExtra("url", team_model.getUrl()); //int
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //important for intent in adapter

                mCtx.startActivity(intent);



            }
        });
    }


    @Override
    public int getItemCount() {
        return teamList.size();
    }


    class TeamViewHolder extends RecyclerView.ViewHolder {

        TextView name , batch;
        ImageView imageView;
        LinearLayout proto_layout;

        public TeamViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
//            batch = itemView.findViewById(R.id.batch);
            proto_layout= itemView.findViewById(R.id.proto_layout);
            imageView = itemView.findViewById(R.id.img);

        }


    }
}
