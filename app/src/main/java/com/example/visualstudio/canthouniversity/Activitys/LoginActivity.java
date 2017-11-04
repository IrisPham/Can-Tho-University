package com.example.visualstudio.canthouniversity.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.visualstudio.canthouniversity.Presenter.LoginPresenter;
import com.example.visualstudio.canthouniversity.R;
import com.example.visualstudio.canthouniversity.Service.SocketIOService;
import com.example.visualstudio.canthouniversity.View.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private ProgressBar progressBar;
    private LinearLayout linearLayout;
    private EditText edtUserName;
    private EditText edtUserPass;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.progressBartest);
        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        edtUserName = (EditText) findViewById(R.id.textView_Code);
        edtUserPass = (EditText) findViewById(R.id.textView_Pass);

        loginPresenter = new LoginPresenter(this,this);
        SocketIOService.getConnect();

    }

    public void onClickBtnLogin(View view) {
        loginPresenter.checkInputAccount(edtUserName.getText().toString()
                , edtUserPass.getText().toString());
    }


    @Override
    public void showProgress() {
        linearLayout.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        linearLayout.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void idAccountError(String status) {
        Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passwordError(String status) {
        Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(String status) {
        Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
