package oop.inheritance.ingenico;

import oop.inheritance.tpv.Keyboard;

public class IngenicoKeyboard implements Keyboard {

    private static IngenicoKeyboard theIngenicoKeyboard;

    public IngenicoKeyboard(){
    }

    public static IngenicoKeyboard getTheIngenicoKeyboard(){
        if(theIngenicoKeyboard == null) {
            theIngenicoKeyboard = new IngenicoKeyboard();
        }
        return theIngenicoKeyboard;
    }

    /**
     * @return key pressed
     */
    public String get() {
        return "Key pressed";
    }
}
