package dev.inward.matrix.route;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.StampedLock;

public abstract class Dispatch<D extends Dispatch<D,R>,R extends Road<D,R>> extends ThreadGroup implements RejectedExecutionHandler, Comparable<D> {

    protected final StampedLock gate = new StampedLock();

    public final String description;
    protected volatile int corePoolSize;
    protected volatile int maximumPoolSize;
    protected volatile long keepAliveTime;
    protected volatile TimeUnit defaultTimeUnit;
    protected volatile long stackSize;


    public Dispatch(dev.inward.matrix.route.Dispatch parent, String name, String description, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit defaultTimeUnit, long stackSize) {
        super(parent,name);
        this.description = description;
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.defaultTimeUnit = defaultTimeUnit;
        this.stackSize = stackSize;
    }
    @SuppressWarnings("unchecked")
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (executor instanceof Road) {
            R road = (R) executor;
            if (r instanceof Driver) {
                D driver = (D) r;
            }

        }
    }
    public static class Network extends Dispatch<Network, Road.Network> {

        public Network(Dispatch parent, String name, String description, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit defaultTimeUnit, long stackSize) {
            super(parent, name, description, corePoolSize, maximumPoolSize, keepAliveTime, defaultTimeUnit, stackSize);
        }

        @Override
        public int compareTo(Network o) {
            return 0;
        }
    }
    public static class Policy extends Dispatch<Policy,Road.Policy> {

        public Policy(Dispatch parent, String name, String description, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit defaultTimeUnit, long stackSize) {
            super(parent, name, description, corePoolSize, maximumPoolSize, keepAliveTime, defaultTimeUnit, stackSize);
        }

        @Override
        public int compareTo(Policy o) {
            return 0;
        }
    }
    public static class DriverFactory<D extends Dispatch<D,R>,R extends Road<D,R>> implements ThreadFactory {
        protected final AtomicLong driverNameCount = new AtomicLong();
        protected final D dispatch;
        protected final String roadName;
        protected final String driver_name_base;


        public DriverFactory(D dispatch, String roadName) {
            this.dispatch = dispatch;
            this.roadName = roadName;
            this.driver_name_base = roadName + '_' + dispatch.getName() + "_#";
        }

        @Override
        public Driver<D, R> newThread(Runnable r) {
                return new Driver<>(dispatch, r,String.format("%s_%s",driver_name_base,this.driverNameCount.getAndIncrement()),dispatch.stackSize);
        }

        public String getRoadName() {
            return roadName;
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

    public long getStackSize() {
        return stackSize;
    }
}

