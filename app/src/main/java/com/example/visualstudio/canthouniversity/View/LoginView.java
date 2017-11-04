package com.example.visualstudio.canthouniversity.View;

import com.example.visualstudio.canthouniversity.Model.AccountInformation;

/**
 * Created by Visual Studio on 9/30/2017.
 */

public interface LoginView {

    void showProgress();

    void hideProgress();

    void idAccountError(String status);

    void passwordError(String status);

    void onSuccess(String status);

    void onFail(String error);

    void navigateToHome();
}
