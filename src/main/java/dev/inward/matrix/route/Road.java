package dev.inward.matrix.route;

import dev.inward.matrix.Library;
import dev.inward.matrix.MatrixException;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.Matter;

import java.util.concurrent.*;

public abstract class Road<S extends Scheme<S,L>,L extends Library<S,L>,R extends Road<S,L,R>> extends ThreadPoolExecutor  {

    protected final Dispatch<S,L,R> dispatch;
    public Road(Dispatch<S,L,R> dispatch) {
        super(dispatch.corePoolSize, dispatch.maximumPoolSize, dispatch.keepAliveTime, dispatch.unit, dispatch.workQueue,dispatch,dispatch);
        this.dispatch = dispatch;
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        try {
            Driver<S,L,R> driver = (Driver<S, L, R>) t;
            if (driver.getPassage().equals(Passage.NEW) ||driver.getPassage().equals(Passage.POOLED)) {
                driver.setPassage(Passage.COMPLETING);
            }
            if (driver.getPassage().equals(Passage.COMPLETING) || driver.getPassage().equals(Passage.First_Route)) {
                driver.setPassage(Passage.COMPLETING);
            }
            else {
                System.out.println(driver.getPassage() + ", passage not expected");
            }
            driver.setLastBeginning();
        }
        catch (ClassCastException classCastException) {
            throw new MatrixException(MatrixException.Type.ClassCastException,"Road Creation", Indicia.Focus.Genesis, Indicia.Severity.Unexpected,new Exception("stacktrace"));
        }
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return super.newTaskFor(runnable, value);
    }

    public Dispatch<S,L,R> getDispatch() {
        return dispatch;
    }

    @Override
    public void shutdown() {
        super.shutdown();
    }
}
