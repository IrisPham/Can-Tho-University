package com.example.visualstudio.canthouniversity.Model;

import android.util.Log;

import com.example.visualstudio.canthouniversity.Objects.CalendarScoringObj;
import com.example.visualstudio.canthouniversity.Service.ApiInterface;
import com.example.visualstudio.canthouniversity.Service.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Visual Studio on 10/7/2017.
 */

public class NotificationHelper {
    private OnLoadNotificationResult onLoadNotificationResult;
    private ApiInterface api;

    public NotificationHelper(OnLoadNotificationResult onLoadNotificationResult) {
        this.onLoadNotificationResult = onLoadNotificationResult;
        api = ApiService.getRetrofit().create(ApiInterface.class);
    }

    public void getCalendarScoring(){
        Call<ArrayList<CalendarScoringObj>> call = api.getCalendarScoring();
        call.enqueue(new Callback<ArrayList<CalendarScoringObj>>() {
            @Override
            public void onResponse(Call<ArrayList<CalendarScoringObj>> call, retrofit2.Response<ArrayList<CalendarScoringObj>> response) {
                Log.e("TAG",response.toString());
                if(response.isSuccessful()){
                    ArrayList<CalendarScoringObj> calendarScoringObjs = response.body();
                    onLoadNotificationResult.onGetSONSuccess(calendarScoringObjs);
                }else {
                    onLoadNotificationResult.onGetSONFail("Không có thông báo mới!");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<CalendarScoringObj>> call, Throwable t) {
                onLoadNotificationResult.onGetSONFail("Lỗi khi tải thông báo! Mã lỗi: " + t.getMessage());
            }
        });
    }

}
