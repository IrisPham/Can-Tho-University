package com.example.visualstudio.canthouniversity.View;

import com.example.visualstudio.canthouniversity.Objects.AccountObj;

/**
 * Created by Visual Studio on 10/7/2017.
 */

public interface AccountInfoView {

    void showProgress();

    void hideProgress();

    void onLoadSuccess(AccountObj accountObj);

    void onLoadFail();

}
