package oop.inheritance.verifone.v240m;

import oop.inheritance.tpv.Display;

public class VerifoneV240mDisplay implements Display {

    private static VerifoneV240mDisplay theVerifoneV240mDisplay;

    public VerifoneV240mDisplay(){
    }

    public static VerifoneV240mDisplay getTheVerifoneV240mDisplay(){
        if(theVerifoneV240mDisplay == null) {
            theVerifoneV240mDisplay = new VerifoneV240mDisplay();
        }
        return theVerifoneV240mDisplay;
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

