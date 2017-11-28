package Proxy;

import org.apache.log4j.Logger;

public class IvoryTower implements WizardTower{
    private static final Logger LOGGER = Logger.getLogger(IvoryTower.class);


    @Override
    public void enter(Wizard wizard) {
        LOGGER.info("{} enters the tower.", wizard);
    }
}
