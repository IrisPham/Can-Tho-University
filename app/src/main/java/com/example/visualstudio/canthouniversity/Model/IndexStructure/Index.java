package com.example.visualstudio.canthouniversity.Model.IndexStructure;

import java.util.ArrayList;

/**
 * Created by Visual Studio on 10/1/2017.
 */

public class Index {
    private String index;
    private boolean isChild = true;
    private ArrayList<Index> indexChildList;

    public Index(String index, ArrayList<Index> indexChildList) {
        this.index = index;
        this.indexChildList = indexChildList;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public ArrayList<Index> getIndexChildList() {
        return indexChildList;
    }

    public void setIndexChildList(ArrayList<Index> indexChildList) {
        this.indexChildList = indexChildList;
    }

    public boolean isChild() {
        return isChild;
    }

    public void setChild(boolean child) {
        isChild = child;
    }
}
