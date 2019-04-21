package com.consume.retialbank.creditcardservices;

public class CreditCheckResponse {
    private Score Score;

    public CreditCheckResponse.Score getScore() {
        return Score;
    }

    public void setScore(CreditCheckResponse.Score score) {
        Score = score;
    }

    public enum Score{
        HIGH
    }
}
