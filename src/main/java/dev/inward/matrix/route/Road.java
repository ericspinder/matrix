/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.route;

import java.io.IOException;
import java.nio.channels.AsynchronousChannelGroup;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class Road extends ThreadPoolExecutor implements Comparable<Road>  {

    protected final Dispatch dispatch;
    protected final AsynchronousChannelGroup group;
    protected final UUID uuid = UUID.randomUUID();


    public Road(Dispatch dispatch, BlockingQueue<Runnable> driverQueue, Dispatch.DriverFactory driverFactory) {
        super(dispatch.corePoolSize, dispatch.maximumPoolSize, dispatch.keepAliveTime, dispatch.defaultTimeUnit,driverQueue,driverFactory, dispatch);
        this.dispatch = dispatch;
        try {
            this.group = AsynchronousChannelGroup.withThreadPool(this);
        }
        catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public Dispatch getDispatch() {
        return dispatch;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int compareTo(Road that) {
        int isZero = this.dispatch.compareTo(that.dispatch);
        if (isZero == 0) {
            isZero = ((Dispatch.DriverFactory)this.getThreadFactory()).getRoadName().compareTo(((Dispatch.DriverFactory)that.getThreadFactory()).getRoadName());
            if (isZero == 0) {
                return this.uuid.compareTo(that.uuid);
            }
        }
        return isZero;
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
    }

    @Override
    protected void terminated() {
        super.terminated();
    }
}
