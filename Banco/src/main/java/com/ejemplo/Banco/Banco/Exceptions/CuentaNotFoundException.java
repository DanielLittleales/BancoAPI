package com.ejemplo.Banco.Banco.Exceptions;

public class CuentaNotFoundException extends RuntimeException {

    public CuentaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CuentaNotFoundException(Throwable cause) {
        super(cause);
    }

    public CuentaNotFoundException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CuentaNotFoundException(String message) {
        super(message);
    }
}
