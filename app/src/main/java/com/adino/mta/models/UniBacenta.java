package com.adino.mta.models;

import com.adino.mta.models.Bacenta;

/**
 * Created by afadinsro on 12/17/17.
 */

public class UniBacenta extends Bacenta {
    private String university;
    private String img_url;

    /**
     * Constructor
     * @param name name
     * @param venue venue
     * @param time service time
     * @param university university
     * @param img_url image URL
     */
    public UniBacenta(String name, String venue, String time, String university, String img_url) {
        super(name, venue, time, img_url);
        this.university = university;
    }

    /**
     * Get the university this bacenta is in
     * @return bacenta's university
     */
    public String getUniversity() {
        return university;
    }

    /**
     * Set the name of the university this bacenta is in
     * @param university bacenta's university
     */
    public void setUniversity(String university) {
        this.university = university;
    }
}
