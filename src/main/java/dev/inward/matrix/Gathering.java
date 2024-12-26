package dev.inward.matrix;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.StampedLock;

public abstract class Gathering<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,PR>,A extends Addressed<PATH,ID,I,A,R,PR>,R extends Representative<PATH,ID,I,A,R,PR>,PR extends Representative<PATH,?,?,?,PR,?>> {

    private transient final StampedLock gate = new StampedLock();
    protected final Map<String, Operation<PATH,ID,I,A,R,PR>> containers = new ConcurrentHashMap<>();

    protected final Addressed.Resource<PATH,ID,I,A,PR,R> resource;

    public Gathering(Addressed.Resource<PATH,ID,I,A,PR,R> resource, List<C> containers) {
        this.resource = resource;
        for (C container: containers) {
            this.containers.put(container.getUrl().toExternalForm(),container);
        }
    }

    public Addressed.Resource<PATH,ID,I,A,PR,R> getResource() {
        return resource;
    }
}
