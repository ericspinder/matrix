package dev.inward.matrix.operational;

import dev.inward.matrix.advisor.NotionStartupException;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.*;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.Subject;
import dev.inward.matrix.meta.Specification;
import dev.inward.matrix.rubric.Complication;
import dev.inward.matrix.rubric.Criteria;
import dev.inward.matrix.rubric.Envoy;
import dev.inward.matrix.rubric.Predictor;

import java.lang.invoke.MethodHandle;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public abstract class Supplier<Y extends Factory<Y,F,O,I,X,B,P,N,A>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,N,A>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,N,A>,P extends Diplomat<Y,F,O,I,X,B,P,N,A>,N extends Notion<N,I,X,A>,A extends Ambassador<?,N,?,I,X,?,A,?,?>> {
    public final Class<Y> factoryClass = ((Class<Y>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    public final Class<F> factClass = ((Class<F>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
    public final Class<O> operationalClass = ((Class<O>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[2]);
    public final Class<B> busClass = ((Class<B>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[5]);
    public final Class<P> progenitorClass = ((Class<P>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[6]);
    public final Class<N> notionClass = ((Class<N>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[7]);
    public final Class<A> ambassadorClass = ((Class<A>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[8]);

    public <DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P, N, A>> Criteria<DATUM,D,E,F,I,X,P,N,A,?> gainCriteria(String methodName) {
        return null;
    }

    public Y getFactory(A parent, Map<Specification<F,I,X>, Resources<Y,?,?,?,F,O,I,X,B,P,N,A>> resourceMap) {
        try {
            return factoryClass.getDeclaredConstructor(ambassadorClass, Map.class)
                    .newInstance(parent,resourceMap);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass(), Subject.Focus.Admonitory, Subject.Severity.Exceptional,e);
        }
    }
    public B getBus(O operation) {
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