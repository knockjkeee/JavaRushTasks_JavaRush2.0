package Adapter;

import org.apache.log4j.Logger;

public class FishingBoat {

    private static final Logger LOGGER = Logger.getLogger(FishingBoat.class);

    public void sail(){
        LOGGER.info("The fishing boat is sailing");
    }
}
