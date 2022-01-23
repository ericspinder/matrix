package dev.inward.matrix;

import com.notionds.dataSupplier.datum.Datum;

import java.sql.SQLException;

public class SqlExceptionWrapper extends Datum<D,O,C,I> {

    private final Recommendation recommendation;

    public SqlExceptionWrapper(String message, SQLException cause, Recommendation recommendation) {
        super(message, cause);
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
        return recommendation;
    }

}
