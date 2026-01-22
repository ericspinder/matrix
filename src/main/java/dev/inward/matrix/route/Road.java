/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.route;

import dev.inward.matrix.predictable.Complication;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.*;

public class Road extends ThreadPoolExecutor implements Comparable<Road>  {

    protected final UUID uuid = UUID.randomUUID();

    public Road(Dispatch dispatch, BlockingQueue<Runnable> predictableBlockingQueue) {
        this(dispatch,predictableBlockingQueue,dispatch.getDefaultDriverFactory(),dispatch);
    }

    public Road(Dispatch dispatch, BlockingQueue<Runnable> driverQueue, DriverFactory driverFactory, RejectedExecutionHandler handler) {
        super(dispatch.corePoolSize, dispatch.maximumPoolSize, dispatch.keepAliveTime, dispatch.defaultTimeUnit,driverQueue,driverFactory, Objects.requireNonNullElse(handler,new AbortPolicy()));
    }

    @Override
    public int compareTo(Road that) {
        return this.uuid.compareTo(that.uuid);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        Driver driver = (Driver) t;
        Complication<?,?,?> complication = (Complication<?,?,?>) r;
        if (complication.isCanceled()) {
            throw new CancellationException("predictable not open");
        }
        driver.resetRouteStartInstant();
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        Complication<?,?,?> complication = (Complication<?,?,?>) r;
        complication.wrapUp();
    }

    @Override
    protected void terminated() {
        super.terminated();
    }
}
