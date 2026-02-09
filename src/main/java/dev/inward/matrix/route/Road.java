/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.route;

import dev.inward.matrix.predictable.Complication;

import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.*;

public class Road extends ThreadPoolExecutor implements Comparable<Road>, WatchService {

    protected final UUID uuid = UUID.randomUUID();

    public Road(DriverFactory driverFactory, BlockingQueue<Runnable> complicationQueue, RejectedExecutionHandler handler) {
        super(driverFactory.dispatch.corePoolSize, driverFactory.dispatch.maximumPoolSize, driverFactory.dispatch.keepAliveTime, driverFactory.dispatch.defaultTimeUnit,complicationQueue,driverFactory, Objects.requireNonNullElse(handler,new AbortPolicy()));
    }

    @Override
    public int compareTo(Road that) {
        return this.uuid.compareTo(that.uuid);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        Complication<?,?,?> complication = (Complication<?,?,?>) r;
        if (complication.isCanceled()) {
            throw new CancellationException("Complication has been canceled");
        }
        Driver driver = (Driver) t;
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

    public void close() {
        shutdown();
    }

    @Override
    public Complication<?,?,?,?,?,?,?,?,> poll() {
        return null;
    }

    @Override
    public WatchKey poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public WatchKey take() throws InterruptedException {
        return null;
    }
}
