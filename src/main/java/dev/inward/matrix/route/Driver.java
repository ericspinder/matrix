package dev.inward.matrix.route;

import dev.inward.matrix.*;

import java.io.Closeable;
import java.lang.ref.SoftReference;
import java.nio.channels.AsynchronousChannel;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.locks.StampedLock;

public abstract class Driver<DISPATCH extends Dispatch<DISPATCH,R,D,RIDER>,R extends Road<DISPATCH,R,D,RIDER>,D extends Driver<DISPATCH,R,D,RIDER>,RIDER extends Closeable> extends Thread {

    protected SoftReference<RIDER> currentRider;
    protected final UUID uuid = UUID.randomUUID();
    protected final StampedLock gate = new StampedLock();
    protected final Instant createInstant = Instant.now();
    protected Instant lastBeginning;
    protected Instant lastHealthCheck;

    public Driver(DISPATCH group, Runnable target, String name,
                  long stackSize) {
        super(group,target,name,stackSize,false);
    }

    public static class Pilot<RIDER extends AsynchronousChannel> extends Driver<Dispatch.Controller<RIDER>,Road.Way<RIDER>,Pilot<RIDER>, RIDER>  {

        public Pilot(Dispatch.Controller group, Runnable target,String name) {
            super(group,target,name,group.stackSize);
        }
    }
    public static class Scribe extends Driver<Dispatch.Editor,Road.Concrete,Driver.Scribe, AsynchronousFileChannel> {

        public Scribe(Dispatch.Editor group, Runnable target, String name) {
            super(group, target, name, group.stackSize);
        }
    }

    public RIDER getCurrentRider() {
        return this.currentRider.get();
    }

    public void setCurrentRider(RIDER currentRider) {
        this.currentRider = new SoftReference<>(currentRider);
    }

    @SuppressWarnings("unchecked")
    public DISPATCH getDispatch() {
        return (DISPATCH) this.getThreadGroup();
    }

    public UUID getUuid() {
        return uuid;
    }

    public Instant getLastBeginning() {
        long readLock = gate.readLock();
        try {
            return lastBeginning;
        }
        finally {
            gate.unlockRead(readLock);
        }
    }

    public void setLastBeginning() {
        long writeLock = gate.writeLock();
        try {
            this.lastBeginning = Instant.now();
        }
        finally {
            gate.unlockWrite(writeLock);
        }
    }

    public Instant getLastHealthCheck() {
        long readLock = gate.readLock();
        try {
            return lastHealthCheck;
        }
        finally {
            gate.unlockRead(readLock);
        }
    }

    public void setLastHealthCheck() {
        long writeLock = gate.writeLock();
        try {
            this.lastHealthCheck = Instant.now();
        }
        finally {
            gate.unlockWrite(writeLock);
        }
    }
}
