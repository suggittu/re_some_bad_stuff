package com.yandex.metrica.impl.ob;

/* loaded from: classes.dex */
public class dx extends Exception {

    public enum a {
        DEFAULT,
        AUTH,
        NETWORK,
        NO_CONNECTION,
        PARSE,
        SERVER,
        TIMEOUT
    }

    public dx() {
    }

    public dx(byte b) {
    }

    public dx(Throwable th) {
        super(th);
    }
}
