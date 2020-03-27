package oop.inheritance.verifone.v240m;

import oop.inheritance.data.TransactionBuilder;
import oop.inheritance.data.TransactionResponse;
import oop.inheritance.tpv.CommunicationDevice;

public class VerifoneV240mEthernet implements CommunicationDevice {

    private static VerifoneV240mEthernet theVerifoneV240mEthernet;

    private VerifoneV240mEthernet(){
    }

    public static VerifoneV240mEthernet getTheVerifoneV240mEthernet(){
        if(theVerifoneV240mEthernet == null) {
            theVerifoneV240mEthernet = new VerifoneV240mEthernet();
        }
        return theVerifoneV240mEthernet;
    }

    /**
     * Opens a connection using the ethernet device
     *
     * @return true if the connection was successfully opened
     */
    public boolean open() {

        return true;
    }

    /**
     * Sends a message to the server
     *
     * @param transaction message to be sent to the server
     * @return true if the message was sent successfully, false otherwise
     */
    public boolean send(TransactionBuilder transaction) {
        return true;
    }

    /**
     * Method blocks until host send a response or until a timeout is reached.
     *
     * @return Message received from the host. In case of timeout it returns null
     */
    public TransactionResponse receive() {
        return new TransactionResponse(true, "12314");
    }

    /**
     * Closes the channel releasing every used resources
     */
    public void close() {

    }

}
