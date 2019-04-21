package com.consume.retialbank.creditcardservices;

public class ApplyforcreditcardResponse {
    private  Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ApplyforcreditcardResponse(Status status) {
        this.status=status;
    }

    public enum Status{ GRANTED}

}
