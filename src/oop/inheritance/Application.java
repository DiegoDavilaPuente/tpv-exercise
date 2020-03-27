package oop.inheritance;

import java.time.LocalDateTime;
import java.util.Map;

import oop.inheritance.data.*;
import oop.inheritance.ingenico.IngenicoKeyboard;
import oop.inheritance.ingenico.IngenicoPrinter;
import oop.inheritance.tpv.AbstractTPVFactory;
import oop.inheritance.tpv.CardSwipper;
import oop.inheritance.tpv.ChipReader;
import oop.inheritance.tpv.CommunicationDevice;
import oop.inheritance.tpv.Display;
import oop.inheritance.tpv.Keyboard;

public class Application {

    private CommunicationType communicationType = CommunicationType.ETHERNET;
    private AbstractTPVFactory abstractTPVFactory;

    public Application(AbstractTPVFactory abstractTPVFactory) {
        this.abstractTPVFactory = abstractTPVFactory;
    }

    public void showMenu() {

        Display ingenicoDisplay = abstractTPVFactory.getDisplay();

        ingenicoDisplay.showMessage(5, 5, "MENU");
        ingenicoDisplay.showMessage(5, 10, "1. VENTA");
        ingenicoDisplay.showMessage(5, 13, "2. DEVOLUCION");
        ingenicoDisplay.showMessage(5, 16, "3. REPORTE");
        ingenicoDisplay.showMessage(5, 23, "4. CONFIGURACION");

    }

    public String readKey() {
        IngenicoKeyboard ingenicoKeyboard = new IngenicoKeyboard();

        return ingenicoKeyboard.get();
    }

    public void doSale() {
        CardSwipper cardSwipper = abstractTPVFactory.getCardSwipper();
        ChipReader chipReader = abstractTPVFactory.getChipReader();
        Display display = abstractTPVFactory.getDisplay();
        Keyboard keyboard = abstractTPVFactory.getKeyboard();

        Card card;

        do {
            card = cardSwipper.readCard();
            if (card == null) {
                card = chipReader.readCard();
            }
        } while (card == null);

        display.clear();
        display.showMessage(5, 20, "Capture monto:");

        String amount = keyboard.get(); //Amount with decimal point as string

        TransactionBuilder transaction = Transaction.builder();

        transaction.setLocalDateTime(LocalDateTime.now());
        transaction.setCard(card);
        transaction.setAmountInCents(Integer.parseInt(amount.replace(".", "")));

        TransactionResponse response = sendSale(transaction);

        if (response.isApproved()) {
            display.showMessage(5, 25, "APROBADA");
            printReceipt(transaction, response.getHostReference());
        } else {
            display.showMessage(5, 25, "DENEGADA");
        }
    }

    private void printReceipt(TransactionBuilder transaction, String hostReference) {
        IngenicoPrinter ingenicoPrinter = new IngenicoPrinter();
        Card card = transaction.getCard();

        ingenicoPrinter.print(5, "APROBADA");
        ingenicoPrinter.lineFeed();
        ingenicoPrinter.print(5, card.getAccount());
        ingenicoPrinter.lineFeed();
        ingenicoPrinter.print(5, "" + transaction.getAmountInCents());
        ingenicoPrinter.lineFeed();
        ingenicoPrinter.print(5, "________________");

    }

    private TransactionResponse sendSale(TransactionBuilder transaction) {

        Map<CommunicationType, CommunicationDevice> communicationDeviceMap = abstractTPVFactory.getCommunicationDeviceMap();

        CommunicationDevice communicationDevice = communicationDeviceMap.get(CommunicationType.ETHERNET);

        communicationDevice.open();
        communicationDevice.send(transaction);
        TransactionResponse transactionResponse = communicationDevice.receive();
        communicationDevice.close();

        return transactionResponse;
    }

    public void doRefund() {
    }

    public void printReport() {
    }

    public void showConfiguration() {
    }

    public void clearScreen() {
        Display display = abstractTPVFactory.getDisplay();
        display.clear();
    }
}
