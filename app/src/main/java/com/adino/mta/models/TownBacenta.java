package com.adino.mta.models;

import com.adino.mta.models.Bacenta;

/**
 * Created by afadinsro on 12/17/17.
 */

public class TownBacenta extends Bacenta {
    private String town;
    private String img_url;
    /**
     * Constructor
     * @param name name
     * @param venue venue
     * @param time service time
     * @param town town
     */
    public TownBacenta(String name, String venue, String time, String town,String img_url) {
        super(name, venue, time, img_url);
        this.town = town;
    }

    /**
     * Get the town this bacenta is in
     * @return bacenta's town
     */
    public String getTown() {
        return town;
    }

    /**
     * Set the name of the town this bacenta is in
     * @param town bacenta's town
     */
    public void setTown(String town) {
        this.town = town;
    }
}
