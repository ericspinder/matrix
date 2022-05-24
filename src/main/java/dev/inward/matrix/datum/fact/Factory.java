package dev.inward.matrix.datum.fact;

import dev.inward.matrix.advisor.NotionStartupException;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.boot.BootLoader;
import dev.inward.matrix.matter.Subject;
import dev.inward.matrix.meta.Specification;
import dev.inward.matrix.meta.Standard;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.rubric.Complication;
import dev.inward.matrix.rubric.Criteria;
import dev.inward.matrix.rubric.Envoy;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.StampedLock;

public abstract class Factory<Y extends Factory<Y,F,O,I,X,B,P,N,A>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,N,A>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,N,A>,P extends Diplomat<Y,F,O,I,X,B,P,N,A>,N extends Notion<N,I,X,A>,A extends Ambassador<?,N,?,I,X,?,A,?,?>> extends ClassLoader implements Comparable<Y>, Serializable {

    protected final UUID uuid = UUID.randomUUID();
    /**
     * This might be null, but only for BootLoader, any other time should throw an error
     */
    protected final A parent;
    private O operational;
    protected Map<Standard<?,F,I,X>, Resources<Y,?,?,?,F,O,I,X,B,P,N,A>> resourceMap;
    protected StampedLock gate = new StampedLock();
    ThreadLocal<P> progenitorInThread = new ThreadLocal<>();

    public Factory(A parent, Map<Standard<?,F,I,X>, Resources<Y,?,?,?,F,O,I,X,B,P,N,A>> resourceMap) {
        this.parent = parent;
        this.resourceMap = resourceMap;
    }
    public void apply(O operational) {
        long writeLock = gate.writeLock();
        try {
            this.operational = operational;
        }
        finally {
            gate.unlockWrite(writeLock);
        }
    }
    public O getOperational() {
        long readLock = gate.readLock();
        try {
            return this.operational;
        }
        finally {
            gate.unlockRead(readLock);
        }
    }

    @SuppressWarnings("unchecked")
    public <DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P, N, A>> byte[] init(String datumClassName,byte[] ) {
        Criteria<DATUM,D,E,F,I,X,P,N,A,?> criteria = this.getOperational().getSupplier().gainCriteria(datumClassName);
        if (criteria != null) {
            try {
                ClassReader classReader = new ClassReader(this.getResourceAsStream(datumClassName));
                classReader.accept(criteria.visitor(),0);
                ClassWriter classWriter = new ClassWriter(classReader, 0);
                return classWriter.toByteArray();
            }
            catch (IOException io) {
                throw new NotionStartupException(NotionStartupException.Type.VisitorFailed, this.getClass(), Subject.Focus.Admonitory, Subject.Severity.Exceptional,io);
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public <DATUM,D extends Datum<DATUM,D,E>, E extends Envoy<DATUM,D,E,F,I,X,P,N,A>> E add(DATUM datum) {
        try {
            Resources<Y,DATUM,D,E,F,O,I,X,B,P,N,A> resources = (Resources<Y,DATUM,D,E,F,O,I,X,B,P,N,A>) this.resourceMap.get(((D) datum).getClass());
            return (E) this.getOperational().getSupplier().(datum,resources.getReferenceQueue(), progenitorInThread.get());
        }
        catch (ClassCastException cce) {

        }


//        for (Predictor<Y,?,F,O,I,X,B,P,?,?,?> predictor: predictorMap.keySet()) {
//            predictor.registerCriterion()
//        }
        return null;
    }

    @Override
    public int compareTo(Y that) {
        int isZero = 0;
        if (!(this instanceof BootLoader)) {
            isZero = this.parent.compareTo(that.parent);
        }
        if (isZero == 0) {
            return this.uuid.compareTo(that.uuid);
        }
        return isZero;
    }

}
