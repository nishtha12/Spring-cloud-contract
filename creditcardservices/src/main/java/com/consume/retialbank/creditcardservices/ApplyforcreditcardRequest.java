package com.consume.retialbank.creditcardservices;

public class ApplyforcreditcardRequest {
    private int citizenNumber;

    public int getCitizenNumber() {
        return citizenNumber;
    }

    public void setCitizenNumber(int citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    private CardType cardType;

    public enum CardType {
            GOLD
    }
}
