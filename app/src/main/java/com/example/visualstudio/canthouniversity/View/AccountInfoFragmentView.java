package com.example.visualstudio.canthouniversity.View;

import com.example.visualstudio.canthouniversity.Model.AccountInformation;

/**
 * Created by Visual Studio on 10/16/2017.
 */

public interface AccountInfoFragmentView {
    void showProgress();
    void hideProgress();
    void onLoadInfoAccSuccess(AccountInformation accountInformation);
    void onLoadInfoAccFail(String error);
}
