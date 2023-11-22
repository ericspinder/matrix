package dev.inward.matrix.route;

import dev.inward.matrix.Clerk;
import dev.inward.matrix.Librarian;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.director.library.Director;
import dev.inward.matrix.fact.matter.Matter;

import java.util.concurrent.*;

public class Road<S extends Scheme<S,L>,L extends Library<S,L>,D extends Director<S,L,D,R>,R extends Road<S,L,D,R>> extends ThreadPoolExecutor  {

    protected final Dispatch<S,L,D,R> dispatch;
    public Road(Dispatch<S,L,D,R> dispatch) {
        super(dispatch.corePoolSize, dispatch.maximumPoolSize, dispatch.keepAliveTime, dispatch.unit, dispatch.workQueue,dispatch,dispatch);
        this.dispatch = dispatch;
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        ;
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return super.newTaskFor(runnable, value);
    }

    public Dispatch<S,L,D,R> getDispatch() {
        return dispatch;
    }
}
