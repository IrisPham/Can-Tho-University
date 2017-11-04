package com.example.visualstudio.canthouniversity.Activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.example.visualstudio.canthouniversity.Adapters.IndexStructureAdapter;
import com.example.visualstudio.canthouniversity.Model.IndexStructure.Index;
import com.example.visualstudio.canthouniversity.R;

import java.util.ArrayList;

public class IndexStructureActivity extends AppCompatActivity {

    private ExpandableListView mExpandableListView;
    private ArrayList<Index> indexList = new ArrayList<>();
    private ArrayList<Index> indexList2 = new ArrayList<>();
    private ArrayList<Index> indexList3 = new ArrayList<>();
    private IndexStructureAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_structure);
        init();
    }
    private void init() {
        mExpandableListView = (ExpandableListView) findViewById(R.id.ExpandableListView);
        mAdapter = new IndexStructureAdapter(indexList,this);
        mExpandableListView.setAdapter(mAdapter);
        prepareIndexData();
    }

    private void prepareIndexData() {
        indexList3.add(new Index("a. Ý thức và thái độ trong học tập.",null));
        indexList2.add(new Index("a. Ý thức và thái độ trong học tập.",indexList3));
        Index n = new Index("Mục I",indexList2);
        indexList.add(n);
        n = new Index("Mục II",indexList2);
        indexList.add(n);
        n = new Index("Mục II",indexList2);
        indexList.add(n);
        n = new Index("Mục III",indexList2);
        indexList.add(n);
        n = new Index("Tổng điểm",indexList2);
        indexList.add(n);
        mAdapter.notifyDataSetChanged();
    }
}
