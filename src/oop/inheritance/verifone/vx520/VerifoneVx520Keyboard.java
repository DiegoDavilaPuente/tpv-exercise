package oop.inheritance.verifone.vx520;

public class VerifoneVx520Keyboard {

    private static VerifoneVx520Keyboard theVerifoneVx520Keyboard;

    private VerifoneVx520Keyboard(){
    }

    public static VerifoneVx520Keyboard getTheVerifoneVx520Keyboard(){
        if(theVerifoneVx520Keyboard == null) {
            theVerifoneVx520Keyboard = new VerifoneVx520Keyboard();
        }
        return theVerifoneVx520Keyboard;
    }

    public String get(){
        return "Key pressed";
    }
}
