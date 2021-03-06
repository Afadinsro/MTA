package com.adino.mta.models;

/**
 * Created by afadinsro on 12/17/17.
 */
//TODO Implement bacenta codes

public class Bacenta {
    private String name;
    private String venue;
    private String time;
    private String img_url;

    /**
     * Constructor
     * @param name Bacenta name
     * @param venue venue
     * @param time service time
     */
    public Bacenta(String name, String venue, String time, String img_url) {
        setName(name);
        setVenue(venue);
        setTime(time);
        setImgUrl(img_url);
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

    public String getImgUrl() {
        return img_url;
    }

    public void setImgUrl(String img_url) {
        this.img_url = img_url;
    }
}
