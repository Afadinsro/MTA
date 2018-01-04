package com.adino.mta.center;

import com.adino.mta.enums.Day;

/**
 * Created by afadinsro on 1/4/18.
 */

public class Center {
    private String name;
    private String venue;
    private String time;
    private Day day;
    private String img_url;

    /**
     * Constructor
     * @param name center name
     * @param venue venue
     * @param time service time
     */
    public Center(String name, String venue, Day day, String time, String img_url) {
        setName(name);
        setVenue(venue);
        setDay(day);
        setTime(time);
    }

    /***************************  GETTER METHODS  *******************************/
    /**
     * Get the name of this center
     * @return center name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the venue for this center
     * @return center service venue
     */
    public String getVenue() {
        return venue;
    }

    /**
     * Get the time this center meets
     * @return center service time
     */
    public String getTime() {
        return time;
    }

    /***************************  SETTER METHODS  *******************************/
    /**
     * Set the name of this center
     * @param name the name of this center
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the venue where this center meets
     * @param venue venue for center service
     */
    public void setVenue(String venue) {
        this.venue = venue;
    }

    /**
     * Set the time this center meets
     * @param time time for center service
     */
    public void setTime(String time) {
        this.time = time;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public String getImgUrl() {
        return img_url;
    }

    public void setImgUrl(String img_url) {
        this.img_url = img_url;
    }
}
