package com.makarios.app.makarios.adapters;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makarios.app.makarios.R;
import com.makarios.app.makarios.models.MyCollections;

import java.util.Collections;
import java.util.List;


public class CollectionsAdapter extends RecyclerView.Adapter {
    private Context context;

    public CollectionsAdapter(Context context, List<MyCollections> myCollectionsList, FragmentActivity activity) {
        this.context = context;
    }

    @Override
    public CollectionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_collection_item, parent, false);

            return new CollectionsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CollectionsViewHolder holder, int position) {
//        Glide.with(context)
//                .load("")
//                .into(holder.collectionImage);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class CollectionsViewHolder extends RecyclerView.ViewHolder {
        private ImageView collectionImage;
        private TextView collectionName;
        private TextView collectionStyle;

        private CollectionsViewHolder(View itemView) {
            super(itemView);
            collectionImage = (ImageView) itemView.findViewById(R.id.item_image);
            collectionName = (TextView) itemView.findViewById(R.id.collection_name);
            collectionStyle = (TextView) itemView.findViewById(R.id.collection_type);
        }
    }
}
