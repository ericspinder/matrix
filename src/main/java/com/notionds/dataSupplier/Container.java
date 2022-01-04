package com.notionds.dataSupplier;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.context.Context;
import com.notionds.dataSupplier.exceptions.Recommendation;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Receipt;
import com.notionds.dataSupplier.provider.Situation;
import com.notionds.dataSupplier.task.Task;

import java.util.concurrent.LinkedBlockingDeque;


public abstract class Container<D extends Datum<D,O,C,X>,O extends Operational<D,O>,C extends Container<D,O,C,X,B>,X extends Context<D,O,C,X>,B extends Bus<D,O,C,X,B,?,?,?>> {

    protected final B bus;
    private Receipt<D,O,C,X> receipt = null;
    public volatile Situation currentSituation;

    public Container(B bus) {
        this(bus,null, null);
    }
    public Container(B bus, Situation currentSituation, LinkedBlockingDeque<Task<?,?,?>> tasks) {
        this.bus = bus;
        this.currentSituation = currentSituation;
    }
    public boolean initialize(LinkedBlockingDeque<Task<?,?,?>> tasks) {
        this.receipt = new Receipt<D,O,C,X>()
    }


//    /**
//     *
//     * @return true to continue false to reject use of object
//     */
//    protected abstract boolean checkout();
//    public boolean checkout(Receipt<DATUM,O, U,?> receipt) {
//        this.receipt = receipt;
//        if (this.checkout()) {
//            this.currentSituation = Situation.Open;
//            return true;
//        }
//        else {
//            this.currentSituation = Situation.Closed_Failure;
//            DoDelegateClose(this.getReceipt().get().getDelegate());
//            return false;
//        }
//    }

    protected abstract boolean reuseInterest(boolean currently);
    protected abstract boolean recondition() throws ProtocolException;
    public void checkout( reason)
    public abstract boolean recondition(Reason reason) {

    }


    public boolean reuseInterest() {
        return this.reuseInterest(this.currentSituation.equals(Situation.Open));
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
    public B getBus() {
        return this.bus;
    }

    public abstract void reviewException(Datum datumArtifact, Recommendation recommendation);
}
