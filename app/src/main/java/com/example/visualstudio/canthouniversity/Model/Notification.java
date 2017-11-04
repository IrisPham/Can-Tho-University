package com.example.visualstudio.canthouniversity.Model;

import android.view.View;

/**
 * Created by Visual Studio on 9/7/2017.
 */

public class Notification {
    private String openDate;
    private String closeDate;
    private String permission_position;

    public Notification(String openDate, String closeDate, String permission_position) {
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.permission_position = permission_position;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getPermission_position() {
        return permission_position;
    }

    public void setPermission_position(String permission_position) {
        this.permission_position = permission_position;
    }

    public interface OnClickListennerItemNotification {
        void  onClick(View view);
        void onLongClick(View view, int position);
    }
}
