package com.example.visualstudio.canthouniversity.rateMark.Adapters;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.visualstudio.canthouniversity.R;
import com.example.visualstudio.canthouniversity.rateMark.models.Mark;

import java.util.ArrayList;

/**
 * Created by Visual Studio on 8/1/2017.
 */

public class ExpandableMark extends BaseExpandableListAdapter{
    private Context mContext;
    ArrayList<Mark> marksList;

    public ExpandableMark(Context mContext, ArrayList<Mark> marksList) {
        this.mContext = mContext;
        this.marksList = marksList;
    }

    @Override
    public int getGroupCount() {
        return marksList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return marksList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return marksList.get(i).getMarkChildList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewParentGroup = inflater.inflate(R.layout.items_row_mark_parent,viewGroup,false);
        TextView tvItemName = viewParentGroup.findViewById(R.id.texview_idItem);
        tvItemName.setText(marksList.get(i).getItemName());
        return viewParentGroup;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewChildGroup = null;
        if(marksList.get(i).getMarkChildList().get(i1).isChild()){
            viewChildGroup = inflater.inflate(R.layout.items_row__mark__detail,viewGroup,false);
            TextView tvItemName = viewChildGroup.findViewById(R.id.texview_idItem);
            tvItemName.setText(marksList.get(i).getMarkChildList().get(i1).getItemName());
//            Spinner spinner = viewChildGroup.findViewById(R.id.Spinner_StudentMark);
//            ArrayList<Integer> arr = new ArrayList<>();
//            arr.add(0);
//            arr.add(1);
//            arr.add(2);
//            arr.add(3);
//            arr.add(4);
//            arr.add(5);
//            arr.add(6);
//            arr.add(7);
//            arr.add(8);
//            arr.add(9);
//            arr.add(10);
//
//            ArrayAdapter adapter = new ArrayAdapter(viewChildGroup.getContext(),R.layout.custom_spinner_layout,arr);
//            spinner.setAdapter(adapter);
            return viewChildGroup;
        }else{
            SecondExpandableMark adapter = new SecondExpandableMark((ArrayList<Mark>) marksList.get(i).getMarkChildList());

            SecondExpandable expandableListView = new SecondExpandable(mContext);
            expandableListView.setAdapter(adapter);

            //expandableListView.setGroupIndicator(null);
            adapter.notifyDataSetChanged();

            return expandableListView;
        }
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }


    /*
    * Class ExpanSecond định dạng lại kích thướng listView child of child
    * */
    public class SecondExpandable extends ExpandableListView{

        public SecondExpandable(Context context) {
            super(context);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            Display display = windowManager.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;
            int height = size.y;
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(width,MeasureSpec.AT_MOST);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height,MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }


    /*
    * Class Expan cho phần chỉ mục con của con
    *
    * */

    public class SecondExpandableMark extends BaseExpandableListAdapter{
        ArrayList<Mark> marksList;

        public SecondExpandableMark(ArrayList<Mark> marksList) {
            this.marksList = marksList;
            Log.e("TAG", String.valueOf(marksList.get(0).getMarkChildList().size()));
        }

        @Override
        public int getGroupCount() {
            return marksList.size();
        }

        @Override
        public int getChildrenCount(int i) {
            return marksList.get(i).getMarkChildList().size();
        }

        @Override
        public Object getGroup(int i) {
            return marksList.get(i);
        }

        @Override
        public Object getChild(int i, int i1) {
            return marksList.get(i).getMarkChildList().get(i1);
        }

        @Override
        public long getGroupId(int i) {
            return 0;
        }

        @Override
        public long getChildId(int i, int i1) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View viewParentGroup = inflater.inflate(R.layout.items_row_mark_parent2,viewGroup,false);
            TextView tvItemName = viewParentGroup.findViewById(R.id.texview_idItem);
            tvItemName.setText(marksList.get(i).getItemName());
            return viewParentGroup;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View viewChildGroup = inflater.inflate(R.layout.items_row__mark__detail,viewGroup,false);
            TextView tvItemName = viewChildGroup.findViewById(R.id.texview_idItem);
            tvItemName.setText(marksList.get(i).getMarkChildList().get(i1).getItemName());
            //Set value for Spinner
//            Spinner spinner = viewChildGroup.findViewById(R.id.Spinner_StudentMark);
//            ArrayList<Integer> arr = new ArrayList<>();
//            arr.add(0);
//            arr.add(1);
//            arr.add(2);
//            arr.add(3);
//            arr.add(4);
//            arr.add(5);
//            arr.add(6);
//            arr.add(7);
//            arr.add(8);
//            arr.add(9);
//            arr.add(10);
//
//            ArrayAdapter adapter = new ArrayAdapter(viewChildGroup.getContext(),R.layout.custom_spinner_layout,arr);
//            spinner.setAdapter(adapter);
            //spinner.setSelection(0);
            return viewChildGroup;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return false;
        }
    }

}


