package com.example.visualstudio.canthouniversity.Model;

import com.example.visualstudio.canthouniversity.Objects.CalendarScoringObj;

import java.util.ArrayList;

/**
 * Created by Visual Studio on 10/7/2017.
 */

public interface OnLoadNotificationResult {
    void onGetSONSuccess(ArrayList<CalendarScoringObj> calendarScoringObjs);
    void onGetSONFail(String error);
}
