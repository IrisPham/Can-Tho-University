package com.example.visualstudio.canthouniversity.Service;

import com.example.visualstudio.canthouniversity.Model.AccountInformation;
import com.example.visualstudio.canthouniversity.Objects.CalendarScoringObj;
import com.example.visualstudio.canthouniversity.Objects.MessageObj;
import com.example.visualstudio.canthouniversity.Model.ScoresAddNotification;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Android Studio on 10/22/2017.
 */

public interface ApiInterface {
    @POST("AccountAuthenticator.php")
    @FormUrlEncoded
    Call<MessageObj> accAuth(@Field("idAccount") String idAccount,
                             @Field("password") String password);

    @POST("AccountInfomation.php")
    @FormUrlEncoded
    Call<AccountInformation> getInfoAccount(@Field("idAccount") String idAccount);

    @POST("ScoreAddNotification.php")
    @FormUrlEncoded
    Call<ScoresAddNotification> getScoresAddNotification(@Field("idAccount") String idAccount);

    @GET("NotificationObj.php?calendarScoring")
    Call<ArrayList<CalendarScoringObj>> getCalendarScoring();
}
