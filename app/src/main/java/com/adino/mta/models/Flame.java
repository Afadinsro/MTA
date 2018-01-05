package com.adino.mta.models;

/**
 * Created by afadinsro on 12/31/17.
 */

public class Flame {

    private String name;
    private int num_branches;
    private String img_url;

    public Flame() {
        name = "";
        num_branches = 0;
        img_url = "";
    }

    public Flame(String name, int num_branches, String img_url) {
        this.name = name;
        this.num_branches = num_branches;
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumBranches() {
        return num_branches;
    }

    public void setNumBranches(int num_branches) {
        this.num_branches = num_branches;
    }

    public String getImgUrl() {
        return img_url;
    }

    public void setImgUrl(String img_url) {
        this.img_url = img_url;
    }

    @Override
    public String toString() {
        return name + ": " + num_branches;
    }
}
