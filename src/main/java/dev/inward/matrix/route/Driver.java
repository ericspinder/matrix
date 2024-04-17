package dev.inward.matrix.route;

import dev.inward.matrix.*;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.locks.StampedLock;

public class Driver<S extends Scheme<S,L>,L extends Library<S,L>,R extends Road<S,L,R>> extends Thread {

    protected final UUID uuid = UUID.randomUUID();
    protected final StampedLock gate = new StampedLock();
    protected volatile Passage passage;
    protected final Instant createInstant = Instant.now();
    protected Instant lastBeginning;
    protected Instant lastHealthCheck;

    public Driver(Dispatch<S,L,R> group, Runnable target, String name,
                  long stackSize) {
        super(group,target,name,stackSize,false);
        passage = Passage.NEW;
    }
    @SuppressWarnings("unchecked")
    public Dispatch<S,L,R> getDispatch() {
        return (Dispatch<S,L,R>) this.getThreadGroup();
    }

    public UUID getUuid() {
        return uuid;
    }

    public Passage getPassage() {
        long readLock = gate.readLock();
        try {
            return passage;
        }
        finally {
            gate.unlockRead(readLock);
        }
    }
    public void setPassage(Passage passage) {
        long writeLock = gate.writeLock();
        try {
            this.passage = passage;
        }
        finally {
            gate.unlockWrite(writeLock);
        }
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
