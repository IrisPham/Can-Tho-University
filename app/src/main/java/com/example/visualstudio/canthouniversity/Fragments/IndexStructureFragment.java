package com.example.visualstudio.canthouniversity.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.visualstudio.canthouniversity.Adapters.IndexStructureAdapter;
import com.example.visualstudio.canthouniversity.Model.IndexStructure.Index;
import com.example.visualstudio.canthouniversity.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link IndexStructureFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link IndexStructureFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IndexStructureFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ExpandableListView mExpandableListView;
    private ArrayList<Index> indexList = new ArrayList<>();
    private ArrayList<Index> indexList2 = new ArrayList<>();
    private ArrayList<Index> indexList3 = new ArrayList<>();
    private IndexStructureAdapter mAdapter;

    private OnFragmentInteractionListener mListener;

    public IndexStructureFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IndexStructureFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IndexStructureFragment newInstance(String param1, String param2) {
        IndexStructureFragment fragment = new IndexStructureFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_index_structure, container, false);
        mExpandableListView = (ExpandableListView) view.findViewById(R.id.ExpandableListView_fragment);
        mAdapter = new IndexStructureAdapter(indexList,view.getContext());
        mExpandableListView.setAdapter(mAdapter);
        prepareIndexData();
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
//    private void init() {
//        mExpandableListView = (ExpandableListView) findViewById(R.id.ExpandableListView);
//        mAdapter = new IndexStructureAdapter(indexList,this);
//        mExpandableListView.setAdapter(mAdapter);
//        prepareIndexData();
//    }

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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
