package oop.inheritance.data;

import java.time.LocalDateTime;

public class TransactionBuilder {
    private int amountInCents;
    private Card card;
    private LocalDateTime localDateTime;

    TransactionBuilder(){
    }

    public int getAmountInCents() {
        return amountInCents;
    }

    public TransactionBuilder setAmountInCents(int amountInCents) {
        this.amountInCents = amountInCents;
        return this;
    }

    public Card getCard() {
        return card;
    }

    public TransactionBuilder setCard(Card card) {
        this.card = card;
        return this;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public TransactionBuilder setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }

    public Transaction build(){
        return new Transaction(amountInCents, card, localDateTime);
    }
}
