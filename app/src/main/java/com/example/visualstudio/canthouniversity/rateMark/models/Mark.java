package com.example.visualstudio.canthouniversity.rateMark.models;

import java.util.List;

/**
 * Created by Visual Studio on 7/31/2017.
 */

public class Mark{
    private String idItem;
    private String itemName;
    private int scores;
    private String describe;
    private String IDParent;
    private List<Mark> markChildList;
    private boolean isChild = true;

    public Mark(String idItem, String itemName, int scores, String describe
            , String IDParent, List<Mark> markChildList) {
        this.idItem = idItem;
        this.itemName = itemName;
        this.scores = scores;
        this.describe = describe;
        this.IDParent = IDParent;
        this.markChildList = markChildList;
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

    public List<Mark> getMarkChildList() {
        return markChildList;
    }

    public void setMarkChildList(List<Mark> markChildList) {
        this.markChildList = markChildList;
    }

    public boolean isChild() {
        return isChild;
    }

    public void setChild(boolean child) {
        isChild = child;
    }

}
