package com.adino.mta.bacenta;

/**
 * Created by afadinsro on 12/17/17.
 */

public class TownBacenta extends Bacenta{
    private String town;
    /**
     * Constructor
     * @param name name
     * @param venue venue
     * @param time service time
     * @param town university
     */
    public TownBacenta(String name, String venue, String time, String town) {
        super(name, venue, time);
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
