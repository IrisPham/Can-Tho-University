package com.example.visualstudio.canthouniversity.View;

import com.example.visualstudio.canthouniversity.Objects.CalendarScoringObj;

import java.util.ArrayList;

/**
 * Created by Android Studio on 10/23/2017.
 */

public interface NotificationFragmentView {
    void showProgress(String status);
    void hideProgress();
    void onLoadInfoAccSuccess(ArrayList<CalendarScoringObj> calendarScoringObjList);
    void onLoadInfoAccFail(String error);
}
