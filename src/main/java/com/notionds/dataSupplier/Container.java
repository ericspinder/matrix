package com.notionds.dataSupplier;

import com.notionds.dataSupplier.advisor.Matter;
import com.notionds.dataSupplier.datum.Bus;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.notion.fact.Id;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Receipt;
import com.notionds.dataSupplier.task.Task;

import java.io.Serializable;
import java.util.concurrent.LinkedBlockingDeque;


public abstract class Container<D extends Datum<D,O,C,I>,O extends Operational<D,O>,C extends Container<D,O,C,I,B>,I extends Id<D,I>, B extends Bus<D,O,C,I,B,?,?,?>> implements Comparable<C>, Serializable {

    protected final B bus;
    private Receipt<D,O,C,I> receipt = null;
    public volatile Situation situation;

    public Container(B bus) {
        this(bus,null, null);
    }
    public Container(B bus, Situation situation, LinkedBlockingDeque<Task<D,?,?,?,?>> tasks) {
        this.bus = bus;
        this.situation = situation;
    }
    public boolean initialize(LinkedBlockingDeque<Task<D,?,?,?,?>> tasks) {
       //this.receipt = new Receipt<D,O,C,I>()
        return false;
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
//
//    protected abstract boolean reuseInterest(boolean currently);
//    protected abstract boolean recondition() throws ProtocolException;
//    public void checkout( reason)
//    public abstract boolean recondition(Reason reason) {
//
//    }
//
//
//    public boolean reuseInterest() {
//        return this.reuseInterest(this.currentSituation.equals(Situation.Open));
//    }
//
//
//    public void closeDelegate() {
//        this.currentSituation = Situation.Closed;
//        DoDelegateClose(this.getReceipt().get().getDelegate());
//        if (this.receipt != null) {
//            this.receipt.clear();
//        }
//    }
//
//
//    public static void PrintCause(Throwable t, StringBuilder stringBuilder) {
//        stringBuilder.append(t.getMessage());
//        if (t.getCause() != null) {
//            stringBuilder.append("\n caused by: ");
//            Container.PrintCause(t.getCause(), stringBuilder);
//        }
//    }

    public Receipt<D,O,C,I> getReceipt() {
        return this.receipt;
    }
    public B getBus() {
        return this.bus;
    }

//    public abstract void reviewException(Datum datumArtifact, Recommendation recommendation);
}
