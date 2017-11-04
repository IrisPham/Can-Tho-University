package com.example.visualstudio.canthouniversity.Presenter;

import com.example.visualstudio.canthouniversity.Model.AccountHelper;
import com.example.visualstudio.canthouniversity.Model.AccountInformation;
import com.example.visualstudio.canthouniversity.Model.OnLoadAccountResult;
import com.example.visualstudio.canthouniversity.View.AccountInfoFragmentView;

/**
 * Created by Visual Studio on 10/7/2017.
 */

public class AccountInfoPresenter implements AccountInfoPresenterIm, OnLoadAccountResult{
    private AccountHelper accountHelper;
    private AccountInfoFragmentView accountInfoFragmentView;

    public AccountInfoPresenter(AccountInfoFragmentView accountInfoFragmentView) {
        this.accountInfoFragmentView = accountInfoFragmentView;
    }

    @Override
    public void getInfoAccount(String idAccount) {
        accountHelper = new AccountHelper(this);
        accountHelper.getInfoAccount(idAccount);
        accountInfoFragmentView.showProgress();
    }

    @Override
    public void authTokenSuccess(String status) {

    }

    @Override
    public void authTokenFail(String error) {

    }

    @Override
    public void onLoadInfoAccountSuccess(AccountInformation accountInformation) {
        accountInfoFragmentView.hideProgress();
        accountInfoFragmentView.onLoadInfoAccSuccess(accountInformation);
    }

    @Override
    public void onLoadInfoAccountFail(String error) {
        accountInfoFragmentView.onLoadInfoAccFail(error);
    }
}
