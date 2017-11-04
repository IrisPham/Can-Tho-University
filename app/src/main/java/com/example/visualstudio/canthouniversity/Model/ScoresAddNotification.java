package com.example.visualstudio.canthouniversity.Model;

/**
 * Created by Visual Studio on 10/16/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ScoresAddNotification {

    @SerializedName("idScore")
    @Expose
    private String idScore;
    @SerializedName("scoreName")
    @Expose
    private String scoreName;
    @SerializedName("scores")
    @Expose
    private String scores;
    @SerializedName("describe")
    @Expose
    private String describe;
    @SerializedName("Transcript_idItem")
    @Expose
    private String transcriptIdItem;
    @SerializedName("idAccountManage")
    @Expose
    private String idAccountManage;

    public String getIdScore() {
        return idScore;
    }

    public void setIdScore(String idScore) {
        this.idScore = idScore;
    }

    public String getScoreName() {
        return scoreName;
    }

    public void setScoreName(String scoreName) {
        this.scoreName = scoreName;
    }

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getTranscriptIdItem() {
        return transcriptIdItem;
    }

    public void setTranscriptIdItem(String transcriptIdItem) {
        this.transcriptIdItem = transcriptIdItem;
    }

    public String getIdAccountManage() {
        return idAccountManage;
    }

    public void setIdAccountManage(String idAccountManage) {
        this.idAccountManage = idAccountManage;
    }

}

