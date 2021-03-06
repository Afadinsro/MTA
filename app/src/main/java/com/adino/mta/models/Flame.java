package com.adino.mta.models;

/**
 * Created by afadinsro on 12/31/17.
 */

public class Flame {

    private String name;
    private int numBranches;
    private String imgUrl;

    public Flame() {
        name = "";
        numBranches = 0;
        imgUrl = "";
    }

    public Flame(String name, int numBranches, String imgUrl) {
        this.name = name;
        this.numBranches = numBranches;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumBranches() {
        return numBranches;
    }

    public void setNumBranches(int numBranches) {
        this.numBranches = numBranches;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return name + ": " + numBranches;
    }
}
