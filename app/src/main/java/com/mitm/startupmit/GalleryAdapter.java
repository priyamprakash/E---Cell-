package com.mitm.startupmit;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

import static android.content.ContentValues.TAG;


public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    View mView;
    String url;
    private Context mCtx;
    private List<Gallery_Model> gallery_list;

    public GalleryAdapter(Context mCtx, List<Gallery_Model> gallery_list) {
        this.mCtx = mCtx;
        this.gallery_list = gallery_list;
    }

    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.prototype_gallery, null);

        return new GalleryViewHolder(view);


    }

    @Override
    public void onBindViewHolder(final GalleryViewHolder holder, int position) {
        final Gallery_Model gallery_model = gallery_list.get(position);

        url = gallery_model.getUrl();
        Log.d(TAG, "onBindViewHolder: " + gallery_model.getUrl());
        Log.d(TAG, "onBindViewHolder: " + url);


        holder.tv.setText(gallery_model.getUrl());
        Glide.with(mCtx)
                .load(gallery_model.getUrl())
                .placeholder(R.drawable.startup_logo)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class GalleryViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        ImageView imageView;

        public GalleryViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            imageView = itemView.findViewById(R.id.img);

        }


    }
}
