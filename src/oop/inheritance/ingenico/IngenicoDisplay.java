package oop.inheritance.ingenico;

import oop.inheritance.tpv.Display;

public class IngenicoDisplay implements Display {

    private static IngenicoDisplay theIngenicoDisplay;

    private IngenicoDisplay(){
    }

    public static IngenicoDisplay getTheIngenicoDisplay(){
        if(theIngenicoDisplay == null) {
            theIngenicoDisplay = new IngenicoDisplay();
        }
        return theIngenicoDisplay;
    }

    public static Display getInstance() {
        return null;
    }

    /**
     * Prints a message to specied position
     *
     * @param x       horizontal position
     * @param y       vertical position
     * @param message message to be printed
     */
    public void showMessage(int x, int y, String message) {
    }

    /**
     * Clears the screen
     */
    public void clear() {

    }
}
