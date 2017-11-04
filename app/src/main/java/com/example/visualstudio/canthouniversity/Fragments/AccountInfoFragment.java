package com.example.visualstudio.canthouniversity.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.visualstudio.canthouniversity.Objects.AccountObj;
import com.example.visualstudio.canthouniversity.Model.AccountInformation;
import com.example.visualstudio.canthouniversity.Presenter.AccountInfoPresenter;
import com.example.visualstudio.canthouniversity.R;
import com.example.visualstudio.canthouniversity.View.AccountInfoFragmentView;
import com.gc.materialdesign.widgets.ProgressDialog;

/**
 * Đây là Fragment thông tin sinh viên
 */
public class AccountInfoFragment extends Fragment implements AccountInfoFragmentView{
    private static final String ARG_PARAM_STUDENT_CODE = "idAccount";
    private final String TAG = AccountInfoFragment.class.getName();

    private OnFragmentInteractionListener mListener;
    private String idAccount;

    private TextView tvIdAccount;
    private TextView tvAccountName;
    private TextView tvBirthday;
    private TextView tvAddress;
    private TextView tvSex;
    private TextView tvPhone;
    private TextView tvEmail;
    private TextView tvClassId;
    private TextView tvClassName;
    private TextView tvAcademyName;
    private TextView tvSchoolYear;

    private ProgressDialog mProgressDialog;

    public AccountInfoFragment() {
    }

    public static AccountInfoFragment newInstance(String idAccount) {
        AccountInfoFragment fragment = new AccountInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_STUDENT_CODE,idAccount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = new ProgressDialog(this.getContext(),"Đang load dữ liệu...");
        if (getArguments() != null) {
            idAccount = getArguments().getString(ARG_PARAM_STUDENT_CODE);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fragment_account_info, container, false);
        tvIdAccount = view.findViewById(R.id.textView_idAccount);
        tvAccountName = view.findViewById(R.id.textView_accountName);
        tvBirthday = view.findViewById(R.id.textView_birthday);
        tvAddress = view.findViewById(R.id.textView_address);
        tvSex = view.findViewById(R.id.textView_sex);
        tvPhone = view.findViewById(R.id.textView_phone);
        tvEmail = view.findViewById(R.id.textView_email);
        tvClassId = view.findViewById(R.id.textView_class_idClass);
        tvClassName = view.findViewById(R.id.textView_className);
        tvAcademyName = view.findViewById(R.id.textView_academyName);
        tvSchoolYear = view.findViewById(R.id.textView_schoolYear);

        AccountInfoPresenter accountInfoPresenter = new AccountInfoPresenter(this);
        accountInfoPresenter.getInfoAccount(AccountObj.getIdAccount());
        Log.e(TAG, AccountObj.getIdAccount());
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            Toast.makeText(context, "Cá nhân", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    @Override
    public void showProgress() {
        mProgressDialog.show();
    }

    @Override
    public void hideProgress() {
        mProgressDialog.dismiss();
    }

    @Override
    public void onLoadInfoAccSuccess(AccountInformation accountInformation) {
        tvIdAccount.setText(accountInformation.getIdAccount());
        tvAccountName.setText(accountInformation.getAccountName());
        tvBirthday.setText(accountInformation.getBirthday());
        tvAddress.setText(accountInformation.getAddress());
        tvSex.setText(accountInformation.getSex());
        tvPhone.setText(accountInformation.getPhone());
        tvEmail.setText(accountInformation.getEmail());
        tvClassId.setText(accountInformation.getClassIdClass());
        tvClassName.setText(accountInformation.getClassName());
        tvAcademyName.setText(accountInformation.getAcademyName());
        tvSchoolYear.setText(accountInformation.getSchoolYear());
    }

    @Override
    public void onLoadInfoAccFail(String error) {
        Toast.makeText(this.getActivity(), error, Toast.LENGTH_SHORT).show();
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
