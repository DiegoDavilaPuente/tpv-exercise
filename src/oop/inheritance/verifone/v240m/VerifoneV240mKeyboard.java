package oop.inheritance.verifone.v240m;

import oop.inheritance.tpv.Keyboard;

public class VerifoneV240mKeyboard implements Keyboard {

    private static VerifoneV240mKeyboard theVerifoneV240mKeyboard;

    public VerifoneV240mKeyboard(){
    }

    public static VerifoneV240mKeyboard getTheVerifoneV240mKeyboard(){
        if(theVerifoneV240mKeyboard == null) {
            theVerifoneV240mKeyboard = new VerifoneV240mKeyboard();
        }
        return theVerifoneV240mKeyboard;
    }

    public String get(){
        return "Key pressed";
    }
}
