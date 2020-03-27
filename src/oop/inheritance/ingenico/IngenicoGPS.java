package oop.inheritance.ingenico;

import oop.inheritance.data.TransactionBuilder;
import oop.inheritance.data.TransactionResponse;
import oop.inheritance.tpv.CommunicationDevice;

public class IngenicoGPS implements CommunicationDevice {

    private static IngenicoGPS theIngenicoGPS;

    private IngenicoGPS(){
    }

    public static IngenicoGPS getTheIngenicoGPS(){
        if(theIngenicoGPS == null) {
            theIngenicoGPS = new IngenicoGPS();
        }
        return theIngenicoGPS;
    }
    /**
     * Opens a connection using the GPS device
     *
     * @return true if the connection was successfully opened
     */
    public boolean open() {

        return true;
    }

    /**
     * Sends a message to the server
     *
     * @param message message to be sent to the server
     * @return true if the message was sent successfully, false otherwise
     */
    public boolean send(TransactionBuilder message) {
        return true;
    }

    /**
     * Method blocks until host send a response or until a timeout is reached.
     *
     * @return Message received from the host. In case of timeout it returns null
     */
    public TransactionResponse receive() {
        return new TransactionResponse(true, "782132");
    }

    /**
     * Closes the channel releasing every used resources
     */
    public void close() {

    }
}
