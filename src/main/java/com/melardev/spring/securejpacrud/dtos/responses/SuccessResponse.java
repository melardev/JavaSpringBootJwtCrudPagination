package com.melardev.spring.securejpacrud.dtos.responses;

public class SuccessResponse extends AppResponse {


    public SuccessResponse(String message) {
        super(true);
        addFullMessage(message);
    }

    public SuccessResponse() {
        this(null);
    }
}
