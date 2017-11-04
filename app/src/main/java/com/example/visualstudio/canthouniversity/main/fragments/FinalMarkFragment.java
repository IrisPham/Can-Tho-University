package com.example.visualstudio.canthouniversity.main.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.visualstudio.canthouniversity.R;

/**
 * Created by Visual Studio on 8/13/2017.
 */

public class FinalMarkFragment extends Fragment {
    private TextView tvTitle;
    public FinalMarkFragment() {
    }
    public static FinalMarkFragment newIntance(String itemName){
        FinalMarkFragment fragment = new FinalMarkFragment();
        Bundle bundle = new Bundle();
        bundle.putString("itemName",itemName);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_final_mark,container,false);
//        tvTitle = rootView.findViewById(R.id.section_label);
//        tvTitle.setText(getArguments().getString("itemName"));
        return rootView;
    }
}
