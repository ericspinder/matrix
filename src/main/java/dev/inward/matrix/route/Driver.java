package dev.inward.matrix.route;

import dev.inward.matrix.*;
import dev.inward.matrix.director.library.Director;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.locks.StampedLock;

public class Driver<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,D extends Director<S,L,PATH,D,?>,R extends Route<S,L,PATH,D,?>,B extends Librarian<S,L,PATH,D,R,B,O>,O extends Road<S,L,PATH,D,R,B,O>> extends Thread implements Comparable<Driver<S,L,PATH,D,R,B,O>> {

    protected final UUID uuid = UUID.randomUUID();
    protected final StampedLock gate = new StampedLock();
    protected volatile Passage passage;
    protected final Instant createInstant = Instant.now();
    protected Instant lastBeginning;
    protected Instant lastHealthCheck;

    public Driver(Dispatch group, Runnable target, String name,
                  long stackSize, boolean inheritThreadLocals) {
        super(group,target,name,stackSize,inheritThreadLocals);
        passage = Passage.NEW;
    }
    @SuppressWarnings("unchecked")
    public Dispatch<S,L,PATH,D,R,B,O> getDispatch() {
        return (Dispatch<S,L,PATH,D,R,B,O>) this.getThreadGroup();
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

    @Override
    public int compareTo(Driver<S, L, PATH, D, R, B, O> o) {
        return 0;
    }
}
