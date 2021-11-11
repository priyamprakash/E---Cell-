package com.mitm.startupmit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
@Keep
public class NotificationAdapter extends FirebaseRecyclerAdapter<Notification_Model, NotificationAdapter.PostViewHolder> {

Context mctx;
    private static final String TAG = "NotificationAdapter" ;
    public NotificationAdapter(Context mctx, @NonNull FirebaseRecyclerOptions<Notification_Model> options) {
        super(options);
        this.mctx = mctx;
    }

    @Override
    protected void onBindViewHolder(@NonNull PostViewHolder holder, int position,
                                    @NonNull Notification_Model notificationModel)
    {


        String mtitle = notificationModel.getTitle();
        String mdescription =notificationModel.getDescription();
        String mdate = notificationModel.getDate();
        String mlink = notificationModel.getLink();

        holder.title.setText(mtitle);
        holder.description.setText(mdescription);
        holder.date.setText(mdate);

        holder.click_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mlink));
                mctx.startActivity(browserIntent);
            }
        });


    }

    //create karne k lye
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notify_sample, parent, false);

        return new PostViewHolder(view);

    }
    //view holder reference
    class PostViewHolder extends RecyclerView.ViewHolder {

        TextView date,description , title;
        Button click_btn;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date);

            description=itemView.findViewById(R.id.description);

            title=itemView.findViewById(R.id.title);

            click_btn = itemView.findViewById(R.id.click_btn);
        }
    }


}
