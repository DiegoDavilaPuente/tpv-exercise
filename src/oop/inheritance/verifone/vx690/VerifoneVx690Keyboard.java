package oop.inheritance.verifone.vx690;

public class VerifoneVx690Keyboard {

    private static VerifoneVx690Keyboard theVerifoneVx690Keyboard;

    private VerifoneVx690Keyboard(){
    }

    public static VerifoneVx690Keyboard getTheVerifoneVx690Keyboard(){
        if(theVerifoneVx690Keyboard == null) {
            theVerifoneVx690Keyboard = new VerifoneVx690Keyboard();
        }
        return theVerifoneVx690Keyboard;
    }

    public String get(){
        return "Key pressed";
    }
}
