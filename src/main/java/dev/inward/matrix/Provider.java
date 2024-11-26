package dev.inward.matrix;

import java.nio.file.Watchable;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Function;

public abstract class Provider<W extends Watchable> implements Iterator<W> {


    public Provider(W watched) {
        this.setInitialValue(watched);
    }

    protected abstract void setInitialValue(W watched);
    abstract boolean reset();

    public static class Finder<W extends Watchable> extends Provider<W> {

        public Finder(W watched) {
            super(watched);
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public W next() {
            return null;
        }

        @Override
        public void remove() {
            super.remove();
        }

        @Override
        protected void setInitialValue(W watched) {

        }

        @Override
        boolean reset() {
            return false;
        }
    }

    public static class Provided<W extends Watchable> extends Provider<W> {

        protected W watched;

        public Provided(W watched) {
            super(watched);
        }

        @Override
        public void setInitialValue(W watched) {
            this.watched = watched;
        }

        @Override
        boolean reset() {
            return false;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public W next() {
            return watched;
        }
    }

    public static class Current<W extends Watchable> extends Provider<W> {

        protected W watched;
        private final StampedLock gate = new StampedLock();

        public Current(W watched) {
            super(watched);
        }
        public void setWatched(W watched) {
            long writeLock = gate.writeLock();
            try {
                this.rider = rider;
            } finally {
                gate.unlockWrite(writeLock);
            }
        }
        @Override
        public R getRider() {
            long readLock = gate.readLock();
            try {
                return this.rider;
            }
            finally {
                gate.unlockRead(readLock);
            }
        }
    }

    public static class Chain<W extends Watchable> extends Provider<W> {

        protected final Queue<R> queue;

        public Chain(Policy<? extends Function<M,OCCURRENCE>,PATH,X,ID,I,C,R,M,OCCURRENCE>[] policies,Queue<R> queue) {
            super(policies);
            this.queue = queue;
        }

        @Override
        public R getRider() {
            return this.queue.peek();
        }
        public Queue<R> getQueue() {
            return this.queue;
        }
    }

    public static final class Soft<W extends Watchable> extends Provider<W> {

        protected final R rider;
        protected final boolean tryRefreshIfNull;

        public Soft(Policy<? extends Fu nction<M,OCCURRENCE>, PATH, X, ID, I, C, R, M, OCCURRENCE>[] policies,R rider,boolean tryRefreshIfNull) {
            super(policies);
            this.rider = rider;
            this.tryRefreshIfNull = tryRefreshIfNull;
        }

        @Override
        public R getRider() {
            C concept = rider.get();
            if (concept == null && tryRefreshIfNull) {
                rider.tryRefreshIfNull(null);
            }
            return rider;
        }

    }
}

}
