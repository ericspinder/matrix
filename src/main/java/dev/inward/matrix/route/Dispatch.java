package dev.inward.matrix.route;

import dev.inward.matrix.*;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.director.library.Director;
import dev.inward.matrix.fact.Predictable;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Dispatch<S extends Scheme<S,L>,L extends Library<S,L>,R extends Road<S,L,R>> extends ThreadGroup implements ThreadFactory, RejectedExecutionHandler {

    protected int corePoolSize;
    protected int maximumPoolSize;
    protected long keepAliveTime;
    protected TimeUnit unit;
    protected long stackSize;
    protected BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
    protected AtomicLong driverNameCount;

    public Dispatch(Dispatch parent, String name, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,long stackSize) {
        super(parent,name);
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.unit = unit;
        this.stackSize = stackSize;
    }

    @Override
    @SuppressWarnings("all")
    public Driver<S,L,R> newThread(Runnable r) {
        try {
            Driver<S,L,R> driver = new Driver<>(this, r, this.getName() + driverNameCount.incrementAndGet(), this.stackSize);
            if (r == null) {
                driver.setPassage(Passage.NEW);
            }
            else {
                driver.setPassage(Passage.COMPLETING);
            }
            return driver;
        }
        catch (ClassCastException cce) {
            throw new MatrixException(MatrixException.Type.ClassCastException,"new Driver", Indicia.Focus.Genesis, Indicia.Severity.Critical,new Exception("stacktrace"));
        }
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (executor instanceof Road) {
            Road<S,L,?> road = (Road<S, L, ?>) executor;
            road.purge();
        }
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public BlockingQueue<Runnable> getWorkQueue() {
        return workQueue;
    }

    public ThreadFactory getThreadFactory() {
        return this;
    }

    public RejectedExecutionHandler getHandler() {
        return this;
    }
}
