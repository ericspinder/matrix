package dev.inward.matrix.route;

import java.io.IOException;
import java.nio.channels.AsynchronousChannelGroup;
import java.util.UUID;
import java.util.concurrent.*;

public abstract class Road<D extends Dispatch<D,R>,R extends Road<D,R>> extends ThreadPoolExecutor implements Comparable<R>  {

    protected final D dispatch;
    protected final UUID uuid = UUID.randomUUID();

    public static class Network extends Road<Dispatch.Network, Network> {

        protected final AsynchronousChannelGroup group;

        public Network(Dispatch.Network dispatch, BlockingQueue<Runnable> driverQueue, Dispatch.DriverFactory<Dispatch.Network, Network> driverFactory) {
            super(dispatch, driverQueue,driverFactory);
            try {
                this.group = AsynchronousChannelGroup.withThreadPool(this);
            }
            catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }
        }

        public AsynchronousChannelGroup getGroup() {
            return group;
        }
    }
    public static class Policy extends Road<Dispatch.Policy,Road.Policy> {

        public Policy(Dispatch.Policy dispatch, BlockingQueue<Runnable> driverQueue, Dispatch.DriverFactory<Dispatch.Policy, Policy> driverFactory) {
            super(dispatch, driverQueue, driverFactory);
        }
    }


    public Road(D dispatch, BlockingQueue<Runnable> driverQueue, Dispatch.DriverFactory<D,R> driverFactory) {
        super(dispatch.corePoolSize, dispatch.maximumPoolSize, dispatch.keepAliveTime, dispatch.defaultTimeUnit,driverQueue,driverFactory, dispatch);
        this.dispatch = dispatch;
    }

    public D getDispatch() {
        return dispatch;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int compareTo(R that) {
        int isZero = this.dispatch.compareTo(that.dispatch);
        if (isZero == 0) {
            isZero = ((Dispatch.DriverFactory<D,R>)this.getThreadFactory()).getRoadName().compareTo(((Dispatch.DriverFactory<D,R>)that.getThreadFactory()).getRoadName());
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
