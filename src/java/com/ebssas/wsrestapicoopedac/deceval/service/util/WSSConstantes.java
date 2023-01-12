package com.ebssas.wsrestapicoopedac.deceval.service.util;

public enum WSSConstantes {

    FIRMADO("Signature"),
    TIMESTAMP("Timestamp"),
    USERNAMETOKEN("UsernameToken");

    private final String valor;

    private WSSConstantes(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
