package oop.inheritance.verifone.vx690;

public class VerifoneVx690Display {

    private static VerifoneVx690Display theVerifoneVx690Display;

    private VerifoneVx690Display(){
    }

    public static VerifoneVx690Display getTheVerifoneVx690Display(){
        if(theVerifoneVx690Display == null) {
            theVerifoneVx690Display = new VerifoneVx690Display();
        }
        return theVerifoneVx690Display;
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
