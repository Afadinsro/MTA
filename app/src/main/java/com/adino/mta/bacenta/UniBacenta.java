package com.adino.mta.bacenta;

/**
 * Created by afadinsro on 12/17/17.
 */

public class UniBacenta extends Bacenta{
    private String university;

    /**
     * Constructor
     * @param name name
     * @param venue venue
     * @param time service time
     * @param university university
     */
    public UniBacenta(String name, String venue, String time, String university) {
        super(name, venue, time);
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
