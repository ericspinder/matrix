package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.operational.Supplier;
import dev.inward.matrix.rubric.Complication;
import dev.inward.matrix.rubric.Criterion;
import dev.inward.matrix.rubric.Envoy;
import dev.inward.matrix.rubric.Predictor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public abstract class Factory<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>> extends ClassLoader implements Comparable<Y>, Serializable {

    protected final PP primogenitor;
    protected Supplier<Y,F,O,I,X,B,P,NP,PP> supplier;
    protected final Map<Class<?>, Resource<Y,?,F,O,I,X,B,P,NP,PP,?>> resourceMap;
//    protected Criteria<Y,F,O,I,X,B,P> criteria;
    protected StampedLock gate = new StampedLock();

    public Factory(PP primogenitor,Map<Class<?>, Resource<Y,?,F,O,I,X,B,P,NP,PP,?>> resourceMap) {
        this.primogenitor = primogenitor;
        this.resourceMap = resourceMap;
    }

    public void init(O operational) {
        long writeLock = gate.writeLock();
        supplier = operational.getSupplier();
        try {
        }
        finally {
            gate.unlockWrite(writeLock);
        }
    }
//    public List<Predictor<Y,?,F,O,I,X,B,P,?,?,?>> close() {
//        return null;
//    }


    @SuppressWarnings("unchecked")
    public <D extends Datum<D,F,I,X,P,E>,E extends Envoy<Y,D,F,O,I,X,B,P,NP,PP,E>> void init(String datumClassName) {
        List<Complication<Y,D,F,O,I,X,B,P,NP,PP,E,?,?>> complications = this.supplier.introduceComplications(datumClassName);
        if (complications != null) {
            ClassReader classReader = new ClassReader(this.)
            for (Complication<Y, D, F, O, I, X, B, P, NP, PP, E, ?, ?> complication : complications) {
                classReader.accept();
                ClassWriter classWriter = new ClassWriter(classReader,0);

                complication.getDatumVisitor();
            }
        }
    }

    public <D extends Datum<D,F,I,X,P,E>, E extends Envoy<Y,D,F,O,I,X,B,P,NP,PP,E>> E add(D datum) {
        Resource<Y,D,F,O,I,X,B,P,NP,PP,E> resource = (Resource<Y, D, F, O, I, X, B, P, NP, PP, E>) this.resourceMap.get(datum.getClass());
        E envoy = (E) this.supplier.;

//        for (Predictor<Y,?,F,O,I,X,B,P,?,?,?> predictor: predictorMap.keySet()) {
//            predictor.registerCriterion()
//        }
        return null;
    }
    @SuppressWarnings("unchecked")
    public <D extends Datum<D,F,I,X,P,E>, E extends Envoy<Y,D,F,O,I,X,B,P,NP,PP,E>,C extends Criterion<Y,D,F,O,I,X,B,P,NP,PP,E,C,PRE>,PRE extends Predictor<Y,D,F,O,I,X,B,P,NP,PP,E,C,PRE>> List<PRE> getPredictor(Class<D> datumClass) {
        return (List<PRE>)this.predictors.get(datumClass);
    }

    @Override
    public int compareTo(Y that) {

    }

}
