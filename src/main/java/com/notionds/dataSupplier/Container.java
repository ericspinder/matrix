package com.notionds.dataSupplier;

import com.notionds.dataSupplier.notion.Notion;
import com.notionds.dataSupplier.provider.Receipt;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.exceptions.ExceptionWrapper;
import com.notionds.dataSupplier.exceptions.Recommendation;
import com.notionds.dataSupplier.options.Options;
import com.notionds.dataSupplier.provider.Situation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.time.Instant;

public abstract class Container<DATUM extends Comparable<DATUM> & Serializable, O extends Options<DATUM,O,D>,C extends Container<DATUM,O,C,D,B>,D extends Datum<DATUM,O,C,D,B>,B extends Bus<DATUM,O,C,D,B,?,?,?>> {

    protected final static Logger logger = LogManager.getLogger();
    public final Instant createInstant = Instant.now();
    protected final B bus;
    public volatile Situation currentSituation;

    public Container(B bus) {
        this.bus = bus;
        this.currentSituation = Situation.Unconditioned;
    }

    /**
     *
     * @return true to continue false to reject use of object
     */
    protected abstract boolean checkout();
    public boolean checkout(Receipt<DATUM,O, U,?> receipt) {
        this.receipt = receipt;
        if (this.checkout()) {
            this.currentSituation = Situation.Open;
            return true;
        }
        else {
            this.currentSituation = Situation.Closed_Failure;
            DoDelegateClose(this.getReceipt().get().getDelegate());
            return false;
        }
    }
    protected abstract boolean reuseInterest(boolean currently);

    public boolean reuseInterest() {
        return this.reuseInterest(this.currentSituation.equals(Situation.Open));
    }

    public void handleException(Exception exception, Datum delegatedInstance) {
        logger.debug(exception.getMessage());
        ExceptionWrapper exceptionWrapper = this.bus.advice.adviseException(exception);
        this.reviewException(delegatedInstance, exceptionWrapper.getRecommendation());
    }

    public void closeDelegate() {
        this.currentSituation = Situation.Closed;
        DoDelegateClose(this.getReceipt().get().getDelegate());
        if (this.receipt != null) {
            this.receipt.clear();
        }
    }


    public static void PrintCause(Throwable t, StringBuilder stringBuilder) {
        stringBuilder.append(t.getMessage());
        if (t.getCause() != null) {
            stringBuilder.append("\n caused by: ");
            Container.PrintCause(t.getCause(), stringBuilder);
        }
    }

    public Receipt<DATUM,O, U,?> getReceipt() {
        return this.receipt;
    }
    public Bus<DATUM,O, U,?,?,?,?,?> getBus() {
        return this.bus;
    }

    public abstract void reviewException(Datum datumArtifact, Recommendation recommendation);
}
