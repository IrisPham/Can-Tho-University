package com.example.visualstudio.canthouniversity.rateMark.models;

/**
 * Created by Visual Studio on 8/8/2017.
 */

public class CauTrucBangDiem {
    private String idItem;
    private String itemName;
    private int scores;
    private String describe;
    private String IDParent;

    public CauTrucBangDiem(String idItem, String itemName, int scores, String describe, String IDParent) {
        this.idItem = idItem;
        this.itemName = itemName;
        this.scores = scores;
        this.describe = describe;
        this.IDParent = IDParent;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getIDParent() {
        return IDParent;
    }

    public void setIDParent(String IDParent) {
        this.IDParent = IDParent;
    }
}
