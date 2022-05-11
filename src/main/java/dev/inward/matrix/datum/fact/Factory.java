package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.operational.Supplier;
import dev.inward.matrix.rubric.*;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.StampedLock;

public abstract class Factory<Y extends Factory<Y,F,O,I,X,B,P,NP,PP,C,M>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP,C,M>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP,C,M>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP,C,M>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP,C,M>,C extends Concept<C,?,M>,M extends Mortal<?,C,?,?,?,M>> extends ClassLoader implements Comparable<Y>, Serializable {

    protected final PP primogenitor;
    protected final UUID uuid = UUID.randomUUID();
    private O operational;
    protected final Map<Class<?>, Resource<Y,?,?,F,O,I,X,B,P,NP,PP,?>> resourceMap;
//    protected Criteria<Y,F,O,I,X,B,P> criteria;
    protected StampedLock gate = new StampedLock();

    public Factory(PP primogenitor,Map<Class<?>, Resource<Y,?,?,F,O,I,X,B,P,NP,PP,?>> resourceMap) {
        this.primogenitor = primogenitor;
        this.resourceMap = resourceMap;
    }
    public void init(O operational) {
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
    public <DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,E extends Envoy<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E>> void init(String datumClassName) {
        List<Complication<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E,?,?>> complications = this.getOperational().getSupplier().introduceComplications(datumClassName);
        if (complications != null) {
            try {
                ClassReader classReader = new ClassReader(this.getResourceAsStream(datumClassName));
                for (Complication<Y, DATUM, D, F, O, I, X, B, P, NP, PP, E, ?, ?> complication : complications) {
                    classReader.accept(complication.getDatumVisitor(),0);
                    complication.getDatumVisitor();
                }
                ClassWriter classWriter = new ClassWriter(classReader, 0);
            }
            catch (IOException io) {

            }
        }
    }

    @SuppressWarnings("unchecked")
    public <DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>, E extends Envoy<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E>> E add(Class<E> envoyClass, DATUM datum,P progenitor) {
        try {
            Resource<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E> resource = (Resource<Y,DATUM,D, F, O, I, X, B, P, NP, PP, E>) this.resourceMap.get(((D) datum).getClass());
            return (E) this.getOperational().getSupplier().get(envoyClass,datum,(ReferenceQueue<DATUM>)resource.getReferenceQueue(),progenitor);
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
        int isZero = this.primogenitor.compareTo(that.primogenitor);
        if (isZero == 0) {
            return this.uuid.compareTo(that.uuid);
        }
        return isZero;
    }

}
