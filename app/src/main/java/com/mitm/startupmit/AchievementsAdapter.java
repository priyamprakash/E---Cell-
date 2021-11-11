package com.mitm.startupmit;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AchievementsAdapter  extends FirebaseRecyclerAdapter<Achievements_model,AchievementsAdapter.ViewHolder  > {

    Context context;
    public AchievementsAdapter(Context context , @NonNull FirebaseRecyclerOptions<Achievements_model> options) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull AchievementsAdapter.ViewHolder holder, int i, @NonNull Achievements_model achievements_model) {

        String mtitle = achievements_model.getTitle();
        String mdescription =achievements_model.getDescription();
        String mmembers = achievements_model.getMembers();

        holder.title.setText(mtitle);
        holder.description.setText(mdescription);
        holder.members.setText(mmembers);



    }

    @NonNull
    @Override
    public AchievementsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.achieve_sample, parent, false);

        return new ViewHolder(view);
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        TextView description , title , members;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            description=itemView.findViewById(R.id.description);

            title=itemView.findViewById(R.id.title);

            members = itemView.findViewById(R.id.members);

        }
    }
}
