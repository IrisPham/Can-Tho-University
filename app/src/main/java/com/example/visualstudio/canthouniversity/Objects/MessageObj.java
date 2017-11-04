package com.example.visualstudio.canthouniversity.Objects;

/**
 * Created by Android Studio on 10/22/2017.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MessageObj {

    @SerializedName("message")
    @Expose
    private Integer message;

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }
}