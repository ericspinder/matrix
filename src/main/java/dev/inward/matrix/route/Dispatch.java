/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.route;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.StampedLock;

public class Dispatch extends ThreadGroup implements RejectedExecutionHandler, Comparable<Dispatch> {

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
            Road road = (Road) executor;
            if (r instanceof Driver) {
                Driver driver = (Driver) r;
            }

        }
    }
    public static class DriverFactory implements ThreadFactory {
        protected final AtomicLong driverNameCount = new AtomicLong();
        protected final Dispatch dispatch;
        protected final String roadName;
        protected final String driver_name_base;


        public DriverFactory(Dispatch dispatch, String roadName) {
            this.dispatch = dispatch;
            this.roadName = roadName;
            this.driver_name_base = roadName + '_' + dispatch.getName() + "_#";
        }

        @Override
        public Driver newThread(Runnable r) {
                return new Driver(dispatch, r,String.format("%s_%s",driver_name_base,this.driverNameCount.getAndIncrement()),dispatch.stackSize);
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

