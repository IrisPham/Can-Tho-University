package com.example.visualstudio.canthouniversity.Presenter;

import android.content.Context;

import com.example.visualstudio.canthouniversity.Model.AccountHelper;
import com.example.visualstudio.canthouniversity.Model.AccountInformation;
import com.example.visualstudio.canthouniversity.Model.DatabaseManager;
import com.example.visualstudio.canthouniversity.Model.OnLoadAccountResult;
import com.example.visualstudio.canthouniversity.View.LoginView;

/**
 * Created by Visual Studio on 9/30/2017.
 */

public class LoginPresenter implements LoginPresenterIm, OnLoadAccountResult{

    private final String TAG = LoginPresenter.class.getName();
    private final String URL_ACCOUNT_AUTHENTICATION = DatabaseManager.DBA_HOST
            + "/WebManageScore2/android/AccountAuthenticator.php";
    private LoginView loginView;
    private AccountHelper accountHelper;
    private Context mContext;

    public LoginPresenter(LoginView view, Context mContext) {
        this.loginView = view;
        this.mContext = mContext;
    }

    @Override
    public void checkInputAccount(String idAccount, String password) {
        if(idAccount.equals("")){
            loginView.onFail("Mã đăng nhập không được để trống");
        }
        if(password.equals("")){
            loginView.onFail("Mật khẩu không được để trống");
        }
        if(!idAccount.equals("") && !password.equals("")){
            accountHelper = new AccountHelper(this);
            accountHelper.getAuthToken(idAccount,password);
            loginView.showProgress();
        }
    }

    @Override
    public void authTokenSuccess(String status) {
        loginView.onSuccess(status);
        loginView.navigateToHome();
    }

    @Override
    public void authTokenFail(String error) {
        loginView.onFail(error);
        loginView.hideProgress();
    }

    @Override
    public void onLoadInfoAccountSuccess(AccountInformation accountInformation) {

    }

    @Override
    public void onLoadInfoAccountFail(String error) {

    }
}
