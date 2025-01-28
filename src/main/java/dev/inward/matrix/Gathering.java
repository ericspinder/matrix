package dev.inward.matrix;

import dev.inward.matrix.operation.Operation;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.StampedLock;

public abstract class Gathering<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends Representative<PATH,ID,I,A,R,F>,F extends Addressed.FileAttributes<PATH,ID,I,A,R,F>,O extends Operation<PATH,ID,I,A,R,F,O>> {

    private transient final StampedLock gate = new StampedLock();
    protected final Map<PATH, O> operations = new ConcurrentHashMap<>();


    public Gathering() {
    }

    public Map<PATH, O> getOperations() {
        return this.operations;
    }
}
