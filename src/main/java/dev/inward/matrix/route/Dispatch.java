package dev.inward.matrix.route;

import dev.inward.matrix.*;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.director.library.Director;
import dev.inward.matrix.fact.Predictable;

import java.io.Closeable;
import java.nio.channels.AsynchronousChannel;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.NetworkChannel;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.StampedLock;

public abstract class Dispatch<DISPATCH extends Dispatch<DISPATCH,R,D,RIDER>,R extends Road<DISPATCH,R,D,RIDER>,D extends Driver<DISPATCH,R,D,RIDER>,RIDER extends Closeable> extends ThreadGroup implements ThreadFactory, RejectedExecutionHandler {

    protected final StampedLock gate = new StampedLock();
    protected volatile int corePoolSize;
    protected volatile int maximumPoolSize;
    protected volatile long keepAliveTime;
    protected volatile TimeUnit defaultTimeUnit;
    protected volatile long stackSize;
    protected AtomicLong driverNameCount;


    public Dispatch(Dispatch parent, String name, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit defaultTimeUnit,long stackSize) {
        super(parent,name);
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.defaultTimeUnit = defaultTimeUnit;
        this.stackSize = stackSize;
    }

    public abstract D newDriver(Runnable r);
    @Override
    public D newThread(Runnable r) {
        return this.newDriver(r);
    }

    public static class Controller<RIDER extends AsynchronousSocketChannel> extends Dispatch<Controller<RIDER>,Road.Way<RIDER>,Driver.Pilot<RIDER>,RIDER> {
        public Controller(Dispatch dispatch, String name) {
            super(dispatch,name,25,150,300,TimeUnit.SECONDS,1024000);
        }

        @Override
        public Driver.Pilot newDriver(Runnable r) {
            return new Driver.Pilot(this,r,String.format("%s_%s",this.getName(),this.driverNameCount.get()));
        }
    }
    public static class Editor extends Dispatch<Dispatch.Editor,Road.Concrete,Driver.Scribe, AsynchronousFileChannel> {

        public Editor(Dispatch parent, String name) {
            super(parent, name, 25,150, 300,TimeUnit.SECONDS, 1024000);
        }

        @Override
        public Driver.Scribe newDriver(Runnable r) {
            return new Driver.Scribe(this,r,String.format("%s_%s",this.getName(),this.driverNameCount));
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (executor instanceof Road) {
            R road = (R) executor;

        }
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public TimeUnit getDefaultTimeUnit() {
        return defaultTimeUnit;
    }

    public void setDefaultTimeUnit(TimeUnit defaultTimeUnit) {
        this.defaultTimeUnit = defaultTimeUnit;
    }

    public ThreadFactory getThreadFactory() {
        return this;
    }

    public RejectedExecutionHandler getHandler() {
        return this;
    }
}
