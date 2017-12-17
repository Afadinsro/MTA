package com.adino.mta.bacenta;

/**
 * Created by afadinsro on 12/17/17.
 */

public class UniBacenta extends Bacenta{
    private String university;

    public UniBacenta(String name, String venue, String time, String university) {
        super(name, venue, time);
        this.university = university;
    }
}
