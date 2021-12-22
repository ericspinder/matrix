package com.notionds.dataSupplier.notion;

public class Issue extends Throwable {

    public enum Type {
        Adjustment_Not_Available("")
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
