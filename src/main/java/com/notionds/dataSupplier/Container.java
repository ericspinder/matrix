package com.notionds.dataSupplier;

import com.notionds.dataSupplier.advisor.Receipt;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.exceptions.ExceptionWrapper;
import com.notionds.dataSupplier.exceptions.Recommendation;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Situation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.time.Instant;

public abstract class Container<NOTION extends Comparable<NOTION> & Serializable,O extends Operational<NOTION,O,B,C,U>, B extends Bus<NOTION,O,B,C,U,?,?,?,?>, C extends Container<NOTION,O,B,C,U>,U extends Datum<NOTION,O,B,C,U>> {

    protected final static Logger logger = LogManager.getLogger();
    public final Instant createInstant = Instant.now();
    protected final B bus;
    public volatile Situation currentSituation;
    private Receipt<NOTION,O, U,?> receipt = null;

    public Container(B bus) {
        this.bus = bus;
        this.currentSituation = Situation.Unconditioned;
    }

    /**
     *
     * @return true to continue false to reject use of object
     */
    protected abstract boolean checkout();
    public boolean checkout(Receipt<NOTION,O, U,?> receipt) {
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

    public Receipt<NOTION,O, U,?> getReceipt() {
        return this.receipt;
    }
    public Bus<NOTION,O, U,?,?,?,?,?> getBus() {
        return this.bus;
    }

    public abstract void reviewException(Datum datumArtifact, Recommendation recommendation);
}
