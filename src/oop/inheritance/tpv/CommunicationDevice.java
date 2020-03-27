package oop.inheritance.tpv;

import oop.inheritance.data.TransactionBuilder;
import oop.inheritance.data.TransactionResponse;

public interface CommunicationDevice {
    boolean open();

    boolean send(TransactionBuilder transaction);

    TransactionResponse receive();

    void close();
}