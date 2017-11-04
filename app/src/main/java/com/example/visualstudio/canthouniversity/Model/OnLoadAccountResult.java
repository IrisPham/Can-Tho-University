package com.example.visualstudio.canthouniversity.Model;

import com.example.visualstudio.canthouniversity.Model.Login.User;

/**
 * Created by Visual Studio on 10/7/2017.
 */

public interface OnLoadAccountResult {
    void authTokenSuccess(String status);
    void authTokenFail(String error);
    void onLoadInfoAccountSuccess(AccountInformation accountInformation);
    void onLoadInfoAccountFail(String error);
}
