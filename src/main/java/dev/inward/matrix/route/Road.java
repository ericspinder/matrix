package dev.inward.matrix.route;

import dev.inward.matrix.Library;
import dev.inward.matrix.MatrixException;
import dev.inward.matrix.Policy;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.Matter;

import java.io.Closeable;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.AsynchronousChannel;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Queue;
import java.util.concurrent.*;

public abstract class Road<DISPATCH extends Dispatch<DISPATCH,R,D,RIDER>,R extends Road<DISPATCH,R,D,RIDER>,D extends Driver<DISPATCH,R,D,RIDER>,RIDER extends Closeable> extends ThreadPoolExecutor implements Comparable<R>  {

    protected final DISPATCH dispatch;


    public Road(DISPATCH dispatch, BlockingQueue<Policy> driverQueue) {
        super(dispatch.corePoolSize, dispatch.maximumPoolSize, dispatch.keepAliveTime, dispatch.defaultTimeUnit,driverQueue, dispatch ,dispatch);
        this.dispatch = dispatch;
    }

    public static class Way<RIDER extends AsynchronousChannel> extends Road<Dispatch.Controller<RIDER>,Road.Way<RIDER>,Driver.Pilot<RIDER>, RIDER> {

        public Way(Dispatch.Controller dispatch, BlockingQueue<Runnable> driverQueue) {
            super(dispatch, driverQueue);
        }
    }
    public static class Concrete extends Road<Dispatch.Editor,Road.Concrete,Driver.Scribe, AsynchronousFileChannel> {

        public Concrete(Dispatch.Editor dispatch, BlockingQueue<Runnable> driverQueue) {
            super(dispatch, driverQueue);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        try {
            D driver = (D) t;
            driver.setLastBeginning();
        }
        catch (ClassCastException classCastException) {
            throw new MatrixException(MatrixException.Type.ClassCastException,"Road Creation", Indicia.Focus.Genesis, Indicia.Severity.Unexpected,new Exception("stacktrace"));
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void afterExecute(Runnable r, Throwable t) {
        D driver = (D) Thread.currentThread();
        driver.
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return super.newTaskFor(runnable, value);
    }

    public Dispatch<S,L,R> getDispatch() {
        return dispatch;
    }

    @Override
    public int compareTo(R that) {
        return 0;
    }
}
