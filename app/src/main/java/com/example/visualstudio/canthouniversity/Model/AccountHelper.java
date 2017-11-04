package com.example.visualstudio.canthouniversity.Model;

import android.util.Log;

import com.example.visualstudio.canthouniversity.Objects.AccountObj;
import com.example.visualstudio.canthouniversity.Objects.MessageObj;
import com.example.visualstudio.canthouniversity.Service.ApiInterface;
import com.example.visualstudio.canthouniversity.Service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Visual Studio on 10/7/2017.
 */

public class AccountHelper{
    private final String TAG = AccountHelper.class.getName();
    private ApiInterface api;
    private OnLoadAccountResult onLoadAccountResult;

    public AccountHelper(OnLoadAccountResult onLoadAccountResult) {
        this.onLoadAccountResult = onLoadAccountResult;
        api = ApiService.getRetrofit().create(ApiInterface.class);
    }

    public void getAuthToken(final String idAccount, final String password){
        //Set idAccount for AccountObj Model
        AccountObj.setIdAccount(idAccount);
        Call<MessageObj> call = api.accAuth(idAccount,password);
        call.enqueue(new Callback<MessageObj>() {
            @Override
            public void onResponse(Call<MessageObj> call, retrofit2.Response<MessageObj> response) {
                if (response.isSuccessful()) {
                    MessageObj message = response.body();
                    if(message.getMessage().equals(1)){
                        onLoadAccountResult.authTokenSuccess("Đăng nhập thành công");
                        Log.e(TAG,message.getMessage().toString());
                        //getScoresAddNotification(idAccount);
                    }else {
                        onLoadAccountResult.authTokenFail("Đăng nhập thất bại");
                        Log.e(TAG,message.getMessage().toString());
                    }
                }
            }
            @Override
            public void onFailure(Call<MessageObj> call, Throwable t) {
                Log.e("TAG", t.getMessage());
                onLoadAccountResult.authTokenFail("Đăng nhập thất bại chỗ này nè " + t.getMessage());
            }
        });
    }

    public void getInfoAccount(String idAccount){
        Call<AccountInformation> call = api.getInfoAccount(idAccount);
        call.enqueue(new Callback<AccountInformation>() {
            @Override
            public void onResponse(Call<AccountInformation> call, Response<AccountInformation> response) {
                if(response.isSuccessful()){
                    AccountInformation accountInformation = response.body();
                    onLoadAccountResult.onLoadInfoAccountSuccess(accountInformation);
                }else{
                    onLoadAccountResult.onLoadInfoAccountFail("Thông tin chưa tải hoàn tất");
                }
            }
            @Override
            public void onFailure(Call<AccountInformation> call, Throwable t) {
                onLoadAccountResult.onLoadInfoAccountFail("Lỗi khi kết nối cở sở dữ liệu " + t.getMessage());
            }
        });
    }

    public void getScoresAddNotification(String idAccount){
        Call<ScoresAddNotification> call = api.getScoresAddNotification(AccountObj.getIdAccount());
        call.enqueue(new Callback<ScoresAddNotification>() {
            @Override
            public void onResponse(Call<ScoresAddNotification> call, Response<ScoresAddNotification> response) {
                if(response.isSuccessful()){
                    ScoresAddNotification scoresAddNotification = response.body();
                    Log.e("TAG",scoresAddNotification.getScores());
                    //onLoadAccountResult.onLoadInfoAccountSuccess(accountInformation);
                }else{
                    //onLoadAccountResult.onLoadInfoAccountFail("Thông tin chưa tải hoàn tất");
                }
            }

            @Override
            public void onFailure(Call<ScoresAddNotification> call, Throwable t) {
                onLoadAccountResult.onLoadInfoAccountFail("Lỗi khi kết nối cở sở dữ liệu " + t.getMessage());
            }
        });
    }

}
