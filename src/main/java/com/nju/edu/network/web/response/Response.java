package com.nju.edu.network.web.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Setter
@Data
@AllArgsConstructor
public class Response<T> {
    int statusCode;
    String message;
    T data;

    public Response(){}

    public void ok(){
        this.statusCode = StatusCode.SUCCESS.getCode();
        this.message = StatusCode.SUCCESS.getMessage();
    }

    public void internalServiceError(){
        this.statusCode = StatusCode.INTERNAL_SERVER_ERROR.getCode();
        this.message = StatusCode.INTERNAL_SERVER_ERROR.getMessage();
    }

    public void duplicatedKey(){
        this.statusCode = StatusCode.BAD_REQUEST_DUPLICATED_KEY.getCode();
        this.message = StatusCode.BAD_REQUEST_DUPLICATED_KEY.getMessage();
    }
}
