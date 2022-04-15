package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Tracks;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Referenced;
import dev.inward.matrix.rubric.*;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.operational.Operational;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;

public abstract class Factory<Y extends Factory<Y,F,O,I,X,B,P>,F extends Fact<F,I,X,P,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>> extends ClassLoader implements Comparable<Y>, Serializable, Referenced<Context.JVM> {

    protected final UUID uuid = UUID.randomUUID();
    protected Progenitor progenitor;
    protected O operational;
    protected final LinkedBlockingDeque<O> operationalDeque;
    protected final Map<Class<?>,List<Predictor<Y,?,F,O,I,X,B,P,?,?,?>>> predictorMap;
    protected final Class<F> factClass;
    public Factory(Progenitor progenitor, LinkedBlockingDeque<O> operationalDeque,Map<Class<?>,List<Predictor<Y,?,F,O,I,X,B,P,?,?,?>>> predictorMap) {
        this.progenitor = progenitor;
        this.operationalDeque = operationalDeque;
        this.predictorMap = predictorMap;
        this.operational = operationalDeque.remove();
        this.factClass = (Class<F>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        this.preInit(factClass);
    }
    public O getOperational() {
        return this.operational;
    }

    public UUID getUuid() {
        return this.uuid;
    }
    public void preInit(Class<F> factClass) {
        this.operational.getCriteria(factClass);
        DatumVisitor datumVisitor = new DatumVisitor()
    }

    @SuppressWarnings("unchecked")
    public <D extends Datum<D,F,I,X,P,E>, E extends Envoy<Y,D,F,O,I,X,B,P,E>> void init(Class<D> datumClass) {
        List<Complication<Y,D,F,O,I,X,B,P,E,?,?,?>> complications = new ArrayList<>();
        Criterion<Y,D,F,O,I,X,B,P,E,?,?>[] criteria = this.operational.getCriteria(datumClass);
        for (Criterion<Y,D,F,O,I,X,B,P,E,?,?> criterion: criteria) {
            for (Predictor<Y,D,F,O,I,X,B,P,E,?,?> predictor:this.getPredictor(datumClass)) {
                Complication<Y,D,F,O,I,X,B,P,E,?,?,?> comp = predictor.registerCriterion(criterion);
                complications.add(comp);
                    break;
                }
            }
        }
    }

    public <D extends Datum<D,F,I,X,P,E>, E extends Envoy<Y,D,F,O,I,X,B,P,E>,C extends Criterion<Y,D,F,O,I,X,B,P,E,C,PRE>,PRE extends Predictor<Y,D,F,O,I,X,B,P,E,C,PRE>> Map<String, Tracks.Track<Y,D,F,O,I,X,B,P,E>> add(D datum) {
        E envoy = (E) this.getOperational().getSupplierMap().get(datum.getClass()).get();

//        for (Predictor<Y,?,F,O,I,X,B,P,?,?,?> predictor: predictorMap.keySet()) {
//            predictor.registerCriterion()
//        }
        return null;
    }
    @SuppressWarnings("unchecked")
    public <D extends Datum<D,F,I,X,P,E>, E extends Envoy<Y,D,F,O,I,X,B,P,E>,C extends Criterion<Y,D,F,O,I,X,B,P,E,C,PRE>,PRE extends Predictor<Y,D,F,O,I,X,B,P,E,C,PRE>> List<PRE> getPredictor(Class<D> datumClass) {
        return (List<PRE>)this.predictorMap.get(datumClass);
    }
    public Progenitor getProgenitor() {
        return this.progenitor;
    }
}
