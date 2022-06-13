package dev.inward.matrix.operational;

import dev.inward.matrix.Agent.Edition;
import dev.inward.matrix.advisor.NotionStartupException;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.*;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.persona.Persona;
import dev.inward.matrix.library.Storage;
import dev.inward.matrix.matter.Subject;
import dev.inward.matrix.meta.Specification;
import dev.inward.matrix.rubric.Criteria;
import dev.inward.matrix.rubric.Envoy;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

@SuppressWarnings("unchecked")
public abstract class Supplier<Y extends Factory<Y,F,O,I,X,B,P>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>> {
    public final Class<Y> factoryClass = ((Class<Y>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    public final Class<F> factClass = ((Class<F>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
    public final Class<O> operationalClass = ((Class<O>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[2]);
    public final Class<B> busClass = ((Class<B>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[5]);
    public final Class<P> progenitorClass = ((Class<P>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[6]);

    protected InductionMap<F,I,X,P> inductionMap;

    public <DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>> E buildEnvoy(D datum,Y factory) {
        Induction<Y,DATUM,D,E,F,I,X,P> induction = inductionMap.get(datum.datumClass);
        return induction.createEnvoy(datum,factory);
    }
    public <DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>> Storage<Y,F,O,I,X,B,P> buildStorage(Edition<?> edition, Guard guard, Y factory, Persona[] principals) {
        return new Storage<>(edition,guard,factory,principals);
    }
    public Engine<Y,F,O,I,X,B,P,N,A> buildEngine(Edition<?> edition, Guard guard, Y factory, Persona[] personas, O operational) {
        return new Engine<>(edition,guard,factory,personas,operational);
    }
    public Y buildFactory(A parent, Map<Specification<?,F,I,X>, Resources<Y,?,?,?,F,O,I,X,B,P>> resourceMap) {
        try {
            return factoryClass.getDeclaredConstructor(ambassadorClass, Map.class)
                    .newInstance(parent,resourceMap);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass(), Subject.Focus.Admonitory, Subject.Severity.Exceptional,e);
        }
    }
    public B buildBus(O operation) {
        try {
            return busClass.getDeclaredConstructor(operationalClass).newInstance(operation);
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass(), Subject.Focus.Admonitory, Subject.Severity.Exceptional,e);
        }
    }
    public P buildDiplomat(F fact, ReferenceQueue<F> referenceQueue, B bus, O operational) {
        try {
            return progenitorClass.getDeclaredConstructor(factClass,referenceQueue.getClass(),busClass,operationalClass).newInstance(fact,referenceQueue,bus,operational);
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass(), Subject.Focus.Admonitory, Subject.Severity.Exceptional,e);
        }
    }
}