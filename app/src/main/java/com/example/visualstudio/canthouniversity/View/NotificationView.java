package com.example.visualstudio.canthouniversity.View;

/**
 * Created by Visual Studio on 10/7/2017.
 */

public interface NotificationView {
    void showProgress();

    void hideProgress();

    void onSuccess();

    void onFail();
}
