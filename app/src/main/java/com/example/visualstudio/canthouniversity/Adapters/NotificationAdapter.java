package com.example.visualstudio.canthouniversity.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.visualstudio.canthouniversity.Objects.CalendarScoringObj;
import com.example.visualstudio.canthouniversity.R;

import java.util.ArrayList;

/**
 * Created by Visual Studio on 9/7/2017.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.RecyclerViewHolder>{
    private Context mContext;
    private ArrayList<CalendarScoringObj> calendarScoringObjs;

    public NotificationAdapter(Context mContext, ArrayList<CalendarScoringObj> calendarScoringObjs) {
        this.mContext = mContext;
        this.calendarScoringObjs = calendarScoringObjs;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_row_calendar_scoring,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.tvPermission_position.setText(calendarScoringObjs.get(position).getPermissionPosition());
        holder.tvContent.setText("Đã mỏ đợt chấm điểm rèn luyện cho " + calendarScoringObjs.get(position).getPermissionPosition());
        holder.tvOpenDate.setText(calendarScoringObjs.get(position).getOpenDate());
        holder.tvCloseDate.setText(calendarScoringObjs.get(position).getCloseDate());
    }

    @Override
    public int getItemCount() {
        return calendarScoringObjs.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView tvOpenDate;
        TextView tvContent;
        TextView tvCloseDate;
        TextView tvPermission_position;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tvOpenDate = itemView.findViewById(R.id.txtOpenDate);
            tvContent = itemView.findViewById(R.id.txtContent);
            tvCloseDate = itemView.findViewById(R.id.txtCloseDate);
            tvPermission_position = itemView.findViewById(R.id.txtPermissionPosition);
        }
    }
}
