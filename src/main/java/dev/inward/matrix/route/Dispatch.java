package dev.inward.matrix.route;

import dev.inward.matrix.*;
import dev.inward.matrix.director.library.Director;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class Dispatch<S extends Scheme<S,L>,L extends Library<S,L>,D extends Director<S,L,D,R>,R extends Road<S,L,D,R>> extends ThreadGroup implements ThreadFactory, RejectedExecutionHandler {

    protected int corePoolSize;
    protected int maximumPoolSize;
    protected long keepAliveTime;
    protected TimeUnit unit;
    protected BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
    protected AtomicLong driverNameCount;

    public Dispatch(Dispatch parent, String name, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit) {
        super(parent,name);
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.unit = unit;
    }

    @Override
    @SuppressWarnings("all")
    public Driver<S,L,PATH,D,R,B,O> newThread(Runnable r) {
        return new Driver<>(this,r,this.getName() + driverNameCount.incrementAndGet(),0l,false);
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (executor instanceof Road) {
            System.out.println("Caller runs: " + r.getClass().getCanonicalName() + "; executor: " + executor.getClass().getCanonicalName());
        }
        else {
            System.out.println("Caller runs: " + r.getClass().getCanonicalName() + "; executor: " + executor.toString() );
        }
        new ThreadPoolExecutor.CallerRunsPolicy().rejectedExecution(r,executor);

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
