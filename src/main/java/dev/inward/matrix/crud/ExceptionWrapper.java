package dev.inward.matrix.crud;

import com.notionds.dataSupplier.subject.Subject;
import com.notionds.dataSupplier.datum.Datum;
import dev.inward.matrix.Recommendation;

public class ExceptionWrapper extends Exception implements NotionExceptionWrapper {

    private Subject<>

    public ExceptionWrapper(Subject subject, Datum<?,?,?,?> datum, Exception cause) {
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
