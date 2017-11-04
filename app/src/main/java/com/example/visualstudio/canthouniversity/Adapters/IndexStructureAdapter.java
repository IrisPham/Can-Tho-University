package com.example.visualstudio.canthouniversity.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.visualstudio.canthouniversity.Activitys.DetailStructureActivity;
import com.example.visualstudio.canthouniversity.Activitys.FinalMarkActivity;
import com.example.visualstudio.canthouniversity.Model.IndexStructure.Index;
import com.example.visualstudio.canthouniversity.R;

import java.util.ArrayList;

/**
 * Created by Visual Studio on 10/1/2017.
 */

public class IndexStructureAdapter  extends BaseExpandableListAdapter {
    private ArrayList<Index> indexList;
    private Context mContext;

    public IndexStructureAdapter(ArrayList<Index> indexList, Context mContext) {
        this.indexList = indexList;
        this.mContext = mContext;
    }

    @Override
    public int getGroupCount() {
        return indexList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return indexList.get(i).getIndexChildList().size();
    }

    @Override
    public Object getGroup(int i) {
        return indexList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return indexList.get(i).getIndexChildList().get(i1);
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
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewParent = layoutInflater.inflate(R.layout.items_row_index_structure, viewGroup, false);
        TextView tvIndex = viewParent.findViewById(R.id.textView_indexStructure);
        tvIndex.setText(indexList.get(i).getIndex());
        if(tvIndex.getText().equals("Tổng điểm")){
            tvIndex.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mContext.startActivity(new Intent(mContext.getApplicationContext(), FinalMarkActivity.class));
                }
            });
        }
        return viewParent;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewChildGroup = null;
        if (indexList.get(i).isChild()) {
            SecondExpandableMark adapter = new SecondExpandableMark((ArrayList<Index>) indexList.get(i).getIndexChildList());
            SecondExpandable expandableListView = new SecondExpandable(mContext);
            expandableListView.setAdapter(adapter);
            //expandableListView.setGroupIndicator(null);
            adapter.notifyDataSetChanged();
            return expandableListView;
        } else {
//            viewChildGroup = inflater.inflate(R.layout.items_row__mark__detail, viewGroup, false);
//            TextView tvItemName = viewChildGroup.findViewById(R.id.texview_idItem);
//            tvItemName.setText(marksList.get(i).getMarkChildList().get(i1).getItemName());
////            Spinner spinner = viewChildGroup.findViewById(R.id.Spinner_StudentMark);
////            ArrayList<Integer> arr = new ArrayList<>();
////            arr.add(0);
////            arr.add(1);
////            arr.add(2);
////            arr.add(3);
////            arr.add(4);
////            arr.add(5);
////            arr.add(6);
////            arr.add(7);
////            arr.add(8);
////            arr.add(9);
////            arr.add(10);
////
////            ArrayAdapter adapter = new ArrayAdapter(viewChildGroup.getContext(),R.layout.custom_spinner_layout,arr);
//            spinner.setAdapter(adapter);
            return viewChildGroup;
        }
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    public class SecondExpandable extends ExpandableListView {

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
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.AT_MOST);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public class SecondExpandableMark extends BaseExpandableListAdapter {
        private ArrayList<Index> indexList;

        public SecondExpandableMark(ArrayList<Index> indexList) {
            this.indexList = indexList;
        }

        @Override
        public int getGroupCount() {
            return indexList.size();
        }

        @Override
        public int getChildrenCount(int i) {
            return indexList.get(i).getIndexChildList().size();
        }

        @Override
        public Object getGroup(int i) {
            return indexList.get(i);
        }

        @Override
        public Object getChild(int i, int i1) {
            return indexList.get(i).getIndexChildList().get(i1);
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
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View viewParent = layoutInflater.inflate(R.layout.items_row__mark__detail, viewGroup, false);
            TextView tvIndex = viewParent.findViewById(R.id.texview_idItem);
            tvIndex.setText(indexList.get(i).getIndex());
            return viewParent;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View viewChildGroup = inflater.inflate(R.layout.items_row__mark__detail,viewGroup,false);
            TextView tvItemName = viewChildGroup.findViewById(R.id.texview_idItem);
            tvItemName.setText(indexList.get(i).getIndexChildList().get(i1).getIndex());
            tvItemName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // FrameLayout frameLayout = Activity.findViewById(R.id.content);
                    mContext.startActivity(new Intent(mContext.getApplicationContext(),DetailStructureActivity.class));
                }
            });
            return viewChildGroup;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return false;
        }
    }

}
