package com.example.visualstudio.canthouniversity.Presenter;

import com.example.visualstudio.canthouniversity.Model.NotificationHelper;
import com.example.visualstudio.canthouniversity.Model.OnLoadNotificationResult;
import com.example.visualstudio.canthouniversity.Objects.CalendarScoringObj;
import com.example.visualstudio.canthouniversity.View.NotificationFragmentView;

import java.util.ArrayList;

/**
 * Created by Visual Studio on 10/7/2017.
 */

public class NotificationPresenter implements OnLoadNotificationResult{
    private NotificationFragmentView notificationFragmentView;
    private NotificationHelper notificationHelper;

    public NotificationPresenter(NotificationFragmentView notificationFragmentView) {
        this.notificationFragmentView = notificationFragmentView;
    }

    public void requestLoadNotificationFromDba(){
        notificationHelper = new NotificationHelper(this);
        notificationHelper.getCalendarScoring();
        notificationFragmentView.showProgress("Đang tải thông báo!.....");
    }

    @Override
    public void onGetSONSuccess(ArrayList<CalendarScoringObj> calendarScoringObjs) {
        notificationFragmentView.onLoadInfoAccSuccess(calendarScoringObjs);
        notificationFragmentView.hideProgress();
    }

    @Override
    public void onGetSONFail(String error) {
        notificationFragmentView.onLoadInfoAccFail(error);
        notificationFragmentView.hideProgress();
    }
}
