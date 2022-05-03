package dev.inward.matrix.operational;

import dev.inward.matrix.advisor.NotionStartupException;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.*;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.Subject;
import dev.inward.matrix.rubric.Complication;
import dev.inward.matrix.rubric.Envoy;
import dev.inward.matrix.rubric.Predictor;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public abstract class Supplier<Y extends Factory<Y,F,O,I,X,B,P,NP,PP>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,NP,PP>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,NP,PP>,P extends Progenitor<Y,F,O,I,X,B,P,NP,PP>,NP extends Notion<NP,I,X,PP>,PP extends Primogenitor<?,NP,?,I,X,?,PP>> {
    public final Class<Y> factoryClass = ((Class<Y>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    public final Class<F> factClass = ((Class<F>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
    public final Class<O> operationalClass = ((Class<O>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[2]);
    public final Class<B> busClass = ((Class<B>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[5]);
    public final Class<P> progenitorClass = ((Class<P>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[6]);

    private final Map<Class<?>,Resource<Y,?,?,F,O,I,X,B,P,NP,PP,?>> resources = new HashMap<>();

    public Supplier() {
    }

    public <DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,E extends Envoy<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E>> List<Complication<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E,?,?>> introduceComplications(String datumClassName) {
        return null;
    }
    public <DATUM,D extends Datum<DATUM,D,F,I,X,P,NP,PP,E>,E extends Envoy<Y,DATUM,D,F,O,I,X,B,P,NP,PP,E>> E get(Class<E> envoyClass,DATUM datum,ReferenceQueue<DATUM> referenceQueue,P progenitor) {
        try {
            return envoyClass.getDeclaredConstructor(datum.getClass(), referenceQueue.getClass(), progenitor.getClass()).newInstance(datum,referenceQueue,progenitor);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass(), Subject.Focus.Admonitory, Subject.Severity.Exceptional,e);
        }
    }

    public Y get(O operational, Map<Class<?>, List<Predictor<Y,?,?,F,O,I,X,B,P,NP,PP,?,?,?>>> predictorMap) {
        try {
            return factoryClass.getDeclaredConstructor(operationalClass, Map.class)
                    .newInstance(operational, predictorMap);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass(), Subject.Focus.Admonitory, Subject.Severity.Exceptional,e);
        }
    }
    public B get(O operation) {
        try {
            return busClass.getDeclaredConstructor(operationalClass).newInstance(operation);
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass(), Subject.Focus.Admonitory, Subject.Severity.Exceptional,e);
        }
    }
    public P getProgenitor(F fact, ReferenceQueue<F> referenceQueue, B bus, O operational) {
        try {
            return progenitorClass.getDeclaredConstructor(factClass,referenceQueue.getClass(),busClass,operationalClass).newInstance(fact,referenceQueue,bus,operational);
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass(), Subject.Focus.Admonitory, Subject.Severity.Exceptional,e);
        }
    }
}