package dev.inward.matrix.datum.fact;

import dev.inward.matrix.Agent.Edition;
import dev.inward.matrix.advisor.NotionStartupException;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.boot.BootLoader;
import dev.inward.matrix.datum.fact.notion.persona.Persona;
import dev.inward.matrix.matter.Subject;
import dev.inward.matrix.meta.Standard;
import dev.inward.matrix.operational.Guard;
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
import java.util.function.Supplier;

public abstract class Factory<Y extends Factory<Y,F,O,I,X,B,P>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>> extends ClassLoader implements Comparable<Y>, Serializable {

    protected final UUID uuid = UUID.randomUUID();
    private Engine<Y,F,O,I,X,B,P> engine = null;
    protected StampedLock gate = new StampedLock();
    final ThreadLocal<P> progenitorInThread = new ThreadLocal<>();
    protected final Producer<Y,F,O,I,X,B,P,N,A> producer;

    public Factory(A parent, Producer<Y,F,O,I,X,B,P,N,A> producer) {
        this.producer = producer;
        this.parent = parent;
    }
    @SuppressWarnings("unchecked")
    public void installEngine(Guard guard, Persona[] personas, O operational) {
        long writeLock = gate.writeLock();
        try {
            boolean isNew = (this.engine == null); // Editions cannot be rolled
            this.engine = operational.getSupplier().buildEngine(parent.get().getId().getContext().getEdition(), guard,(Y)this,personas,operational);
            for (Standard<?,F,I,X> standard:  ) {
                this.init(standard.getObjectClassName());
            }
        }
        finally {
            gate.unlockWrite(writeLock);
        }
    }

    public Engine<Y,F,O,I,X,B,P,N,A> getEngine() {
        long readLock = gate.readLock();
        try {
            return this.engine;
        }
        finally {
            gate.unlockRead(readLock);
        }
    }
    public <DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>> Resources<Y,DATUM,D,E,F,O,I,X,B,P> getResources(D datum) {
        Supplier<Resources<Y,DATUM,D,E,F,O,I,X,B,P>> supplier = () -> {return new Resources(engine.getStorage());};
        return this.getEngine().get(datum.datumClass,supplier);
    }

    @SuppressWarnings("unchecked")
    public <DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>> void init(String datumClassName) {
        Criteria<DATUM,D,E,F,I,X,P,N,A,?> criteria = this.getEngine().getOperational().getSupplier().gainCriteria(datumClassName);
        if (criteria != null) {
            try {
                ClassReader classReader = new ClassReader(this.getResourceAsStream(datumClassName));
                classReader.accept(criteria.visitor(),0);
                ClassWriter classWriter = new ClassWriter(classReader, 0);
                byte[] array = this.parent.get().id.getContext().getEdition().defineClass(datumClassName);
                Class<F> factClass = this.library.add(this.defineClass(datumClassName,array,0,array.length,this.library));
            }
            catch (IOException io) {
                throw new NotionStartupException(NotionStartupException.Type.VisitorFailed, this.getClass(), Subject.Focus.Admonitory, Subject.Severity.Exceptional,io);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public <DATUM,D extends Datum<DATUM,D,E,F,I,X,P>, E extends Envoy<DATUM,D,E,F,I,X,P>> E add(DATUM datum) {
        try {
            Resources<Y,DATUM,D,E,F,O,I,X,B,P> resources = (Resources<Y,DATUM,D,E,F,O,I,X,B,P>) this.producer.get(((D) datum).getClass());
            return this.engine.getStorage().add(datum,this);
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
