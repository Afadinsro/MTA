package com.adino.mta.flame;

/**
 * Created by afadinsro on 12/31/17.
 */

public class Flame {

    private String name;
    private int num_branches;

    public Flame(String name, int num_branches) {
        this.name = name;
        this.num_branches = num_branches;
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
}
