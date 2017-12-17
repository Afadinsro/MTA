package com.adino.mta.bacenta;

/**
 * Created by afadinsro on 12/17/17.
 */

public class Bacenta {
    private String name;
    private String venue;
    private String time;

    /**
     * Constructor
     * @param name Bacenta name
     * @param venue venue
     * @param time service time
     */
    public Bacenta(String name, String venue, String time) {
        setName(name);
        setVenue(venue);
        setTime(time);
    }

    /***************************  GETTER METHODS  *******************************/
    /**
     * Get the name of this Bacenta
     * @return bacenta name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the venue for this bacenta
     * @return bacenta service venue
     */
    public String getVenue() {
        return venue;
    }

    /**
     * Get the time this bacenta meets
     * @return bacenta service time
     */
    public String getTime() {
        return time;
    }

    /***************************  SETTER METHODS  *******************************/
    /**
     * Set the name of this bacenta
     * @param name the name of this bacenta
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the venue where this bacenta meets
     * @param venue venue for bacenta service
     */
    public void setVenue(String venue) {
        this.venue = venue;
    }

    /**
     * Set the time this bacenta meets
     * @param time time for bacenta service
     */
    public void setTime(String time) {
        this.time = time;
    }
}
