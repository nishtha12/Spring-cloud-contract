package com.provider.retialbank.creditcheckservices;

public class CreditCheckResponse {
        private Score score;

    public CreditCheckResponse(Score high) {
        this.score=high;
    }


    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public enum Score {
        HIGH
    }
}
