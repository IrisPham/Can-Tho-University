package com.example.visualstudio.canthouniversity.modules.main.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.visualstudio.canthouniversity.R;
import com.example.visualstudio.canthouniversity.modules.main.model.contentMarkModel;

import java.util.ArrayList;

/**
 * Created by Visual Studio on 7/20/2017.
 */

public class ContentMarkAdapter extends RecyclerView.Adapter<ContentMarkAdapter.ContentMarkHolder> {
    private ArrayList<contentMarkModel> contentMarkModelArrayList;
    private Context mContext;

    public class ContentMarkHolder extends RecyclerView.ViewHolder {
        public TextView conentMark;

        public ContentMarkHolder(View itemView) {
            super(itemView);
            conentMark = itemView.findViewById(R.id.textview_contentMark);
        }
    }

    public ContentMarkAdapter(ArrayList<contentMarkModel> contentMarkModelArrayList, Context mContext) {
        this.contentMarkModelArrayList = contentMarkModelArrayList;
        this.mContext = mContext;
    }


    @Override
    public ContentMarkHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_mark,parent,false);
        return new ContentMarkHolder(view);
    }

    @Override
    public void onBindViewHolder(ContentMarkHolder holder, int position) {
        holder.conentMark.setText(contentMarkModelArrayList.get(position).getConentMark());
    }

    @Override
    public int getItemCount() {
        return contentMarkModelArrayList.size();
    }
}
