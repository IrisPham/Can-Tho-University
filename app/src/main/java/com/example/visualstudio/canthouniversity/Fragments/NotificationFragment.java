package com.example.visualstudio.canthouniversity.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.visualstudio.canthouniversity.Adapters.NotificationAdapter;
import com.example.visualstudio.canthouniversity.Objects.CalendarScoringObj;
import com.example.visualstudio.canthouniversity.Presenter.NotificationPresenter;
import com.example.visualstudio.canthouniversity.R;
import com.example.visualstudio.canthouniversity.View.NotificationFragmentView;
import com.gc.materialdesign.widgets.ProgressDialog;

import java.util.ArrayList;

public class NotificationFragment extends Fragment implements NotificationFragmentView {
    private final String TAG = NotificationFragment.class.getName();

    private ProgressDialog mProgressDialog;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private NotificationAdapter adapter;

    private NotificationPresenter notificationPresenter;

    private OnFragmentInteractionListener mListener;

    public NotificationFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Yêu cầu Presenter trả về danh sách thông báo hạn chấm điểm
        notificationPresenter = new NotificationPresenter(this);
        notificationPresenter.requestLoadNotificationFromDba();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification,container,false);
        mRecyclerView = view.findViewById(R.id.rcyCalendarScoring);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager  = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
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

    @Override
    public void showProgress(String status) {
        mProgressDialog = new ProgressDialog(this.getContext(),status);
        mProgressDialog.show();
    }

    @Override
    public void hideProgress() {
        mProgressDialog.dismiss();
    }

    @Override
    public void onLoadInfoAccSuccess(ArrayList<CalendarScoringObj> calendarScoringObjList){
        adapter = new NotificationAdapter(this.getContext(), calendarScoringObjList);
        mRecyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadInfoAccFail(String error) {
        Toast.makeText(this.getContext(),error, Toast.LENGTH_SHORT).show();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
