package dev.inward.matrix.factory;

import dev.inward.matrix.advisor.NotionStartupException;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.operational.induction.Resource;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Representative;
import dev.inward.matrix.operational.induction.Resources;
import dev.inward.matrix.datum.fact.notion.concept.*;
import dev.inward.matrix.datum.fact.notion.concept.boot.BootLoader;
import dev.inward.matrix.matter.Indicia;
import dev.inward.matrix.standard.Standard;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.operational.Engine;
import dev.inward.matrix.rubric.Criteria;
import dev.inward.matrix.rubric.Envoy;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.locks.StampedLock;

public abstract class Factory<Y extends Factory<Y,F,O,I,X,B,R,IC,XC>,F extends Fact<F,I,X,R,IC,XC>,O extends Operational<Y,F,O,I,X,B,R,IC,XC>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,R,IC,XC>,R extends Representative<F,I,X,R,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>> extends ClassLoader implements Comparable<Y>, Serializable {

    protected final UUID uuid = UUID.randomUUID();
    private Engine<Y,F,O,I,X,B,R,IC,XC> engine = null;
    protected StampedLock gate = new StampedLock();
    final ThreadLocal<R> localRepresentative = new ThreadLocal<>();

    public Factory(Resources<Y,F,O,I,X,B,R,IC,XC> resources) {
    }
    @SuppressWarnings("unchecked")
    public void installEngine(O operational) {
        long writeLock = gate.writeLock();
        try {
            boolean isNew = (this.engine == null); // Editions cannot be rolled
            this.engine = operational.supplier().buildEngine(operational);
            for (Standard<?,F,I,X> standard: operational.options()) {
                this.init(standard.getObjectClassName());
            }
            gate.unlockWrite(writeLock);
         }
        finally {
        }
    }

    public Engine<Y,F,O,I,X,B,P> getEngine() {
        long readLock = gate.readLock();
        try {
            return this.engine;
        }
        finally {
            gate.unlockRead(readLock);
        }
    }
    public <DATUM,D extends Datum<DATUM,D,E,I,X>,E extends Envoy<DATUM,D,E,I,X>> Resource<Y,DATUM,D,E,F,O,I,X,B,P> getResources(D datum) {
        Supplier<Resource<Y,DATUM,D,E,F,O,I,X,B,P>> supplier = () -> {return new Resource(engine.getStorage());};
        return this.getEngine().get(datum.datumClass,supplier);
    }

    @SuppressWarnings("unchecked")
    public <DATUM,D extends Datum<DATUM,D,E,I,X>,E extends Envoy<DATUM,D,E,I,X>> void init(String datumClassName) {
        Criteria<DATUM,D,E,I,X> criteria = this.getEngine().getOperational().getSupplier().gainCriteria(datumClassName);
        if (criteria != null) {
            try {
                ClassReader classReader = new ClassReader(this.getResourceAsStream(datumClassName));
                classReader.accept(criteria.visitor(),0);
                ClassWriter classWriter = new ClassWriter(classReader, 0);
                byte[] array = this.parent.get().id.getContext().getEdition().defineClass(datumClassName);
                Class<F> factClass = this.library.add(this.defineClass(datumClassName,array,0,array.length,this.library));
            }
            catch (IOException io) {
                throw new NotionStartupException(NotionStartupException.Type.VisitorFailed, this.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Exceptional,io);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public <DATUM,D extends Datum<DATUM,D,E,I,X>, E extends Envoy<DATUM,D,E,I,X>> E add(DATUM datum) {
        try {
            Resource<DATUM,D,E,F,I,X,B,IC,XC> resource = (Resource<DATUM,D,E,F,I,X,B,IC,XC>) this.producer.get(((D) datum).getClass());
            return this.defineClass()add(datum,this);
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
