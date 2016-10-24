package com.example.han.populararchitecturedemo.net;

/**
 * Created by ${han} on 2016/10/21.
 */

public class ApiException extends RuntimeException {
    public ApiException() {
        this("服务器异常...");


    }

    public ApiException(String message) {
        super(message);
    }
}
