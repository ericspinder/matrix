package com.notionds.dataSupplier.exceptions;

import com.notionds.dataSupplier.advisor.Matter;
import com.notionds.dataSupplier.datum.Datum;

public class ExceptionWrapper extends Exception implements NotionExceptionWrapper {

    private Matter<>

    public ExceptionWrapper(Matter matter, Datum<?,?,?,?> datum, Exception cause) {
        super(message, cause, false, false);
        this.recommendation = recommendation;
    }

    /**
     * Use of 'this' as the return prevents a stack trace from being registered.
     * This is a wrapper and has nothing to do with the creation of the exception.
     * @return this
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public Recommendation getRecommendation() {
        return this.recommendation;
    }


}
