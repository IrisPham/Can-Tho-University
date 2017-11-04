package com.example.visualstudio.canthouniversity.Objects;

/**
 * Created by Android Studio on 10/23/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CalendarScoringObj {

    @SerializedName("openDate")
    @Expose
    private String openDate;
    @SerializedName("closeDate")
    @Expose
    private String closeDate;
    @SerializedName("Permission_position")
    @Expose
    private String permissionPosition;

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

    public String getPermissionPosition() {
        return permissionPosition;
    }

    public void setPermissionPosition(String permissionPosition) {
        this.permissionPosition = permissionPosition;
    }

}
