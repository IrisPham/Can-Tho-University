package com.example.visualstudio.canthouniversity.Model.Login;

/**
 * Created by Visual Studio on 10/1/2017.
 */

public interface OnLoadUserResult {
    void onSuccess(User user);
    void onSuccess();
    void onFail(String status);
}
