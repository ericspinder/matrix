package dev.inward.matrix.operational;

import dev.inward.matrix.Agent.Edition;
import dev.inward.matrix.advisor.NotionStartupException;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.*;
import dev.inward.matrix.datum.fact.notion.*;
import dev.inward.matrix.datum.fact.notion.concept.*;
import dev.inward.matrix.datum.fact.notion.persona.Persona;
import dev.inward.matrix.library.ProtectionDomainStorage;
import dev.inward.matrix.matter.Topic;
import dev.inward.matrix.meta.Specification;
import dev.inward.matrix.rubric.Envoy;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

@SuppressWarnings("unchecked")
public abstract class Supplier<Y extends Factory<Y,F,O,I,X,B,P,FAB,C,E,V,M>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>,FAB extends Fabrication<FAB,C,E,V,M>,C extends Concept<C,M>,E extends Effect<FAB,C,E,V,M>,V extends Volume<FAB,C,E,V,M>,M extends Mortal<FAB,C,E,V,M>> {
    public final Class<Y> factoryClass = ((Class<Y>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    public final Class<F> factClass = ((Class<F>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
    public final Class<O> operationalClass = ((Class<O>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[2]);
    public final Class<B> busClass = ((Class<B>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[5]);
    public final Class<P> diplomatClass = ((Class<P>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[6]);
    public final Class<FAB> fabricationClass = ((Class<FAB>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[7]);
    public final Class<C> conceptClass = ((Class<C>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[8]);
    public final Class<E> effectClass = ((Class<E>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[9]);
    public final Class<V> volumeClass = ((Class<V>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[10]);
    public final Class<M> mortalClass = ((Class<M>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[11]);


    public abstract class IndustrySupplier<Y extends Industry<Y,N,S,I,X,O,A,FAB,C,E,V,M>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Ambassador<Y,N,S,I,X,O,A>,FAB extends Fabrication<FAB,C,E,V,M>,C extends Concept<C,M>,E extends Effect<FAB,C,E,V,M>,V extends Volume<FAB,C,E,V,M>,M extends Mortal<FAB,C,E,V,M>> extends Supplier<Y,N,S,I,X,O,A,FAB,C,E,V,M> {
        public <DATUM,D extends Datum<DATUM,D,E,N,I,X,A>,E extends Envoy<DATUM,D,E,N,I,X,A>> ProtectionDomainStorage<Y,N,S,I,X,O,A> buildStorage(Edition<?> edition, LocationCollection locationCollection, Y industry, Persona[] principals) {
            return new ProtectionDomainStorage<>(edition, locationCollection,industry,principals);
        }

    }

    protected InductionMap<Y,F,O,I,X,B,P> inductionMap;

    public <DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>> E buildEnvoy(D datum,Y factory) {
        Induction<Y,DATUM,D,E,F,I,X,P> induction = (Induction<Y,DATUM,D,E,F,I,X,P>) inductionMap.get(datum.datumClass);
        return induction.createEnvoy(datum,factory);
    }

    public Engine<Y,F,O,I,X,B,P> buildEngine(Edition<?> edition, LocationCollection locationCollection, Y factory, Persona[] personas, O operational) {
        return new Engine<>(edition, locationCollection,factory,personas,operational);
    }
    public Y buildFactory(M mortal, Map<Specification<?,F,I,X>, Resource<Y,?,?,?,F,O,I,X,B,P>> resourceMap) {
        try {
            return factoryClass.getDeclaredConstructor(mortalClass, Map.class)
                    .newInstance(mortal,resourceMap);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass(), Topic.Focus.Admonitory, Topic.Severity.Exceptional,e);
        }
    }
    public B buildBus(O operation) {
        try {
            return busClass.getDeclaredConstructor(operationalClass).newInstance(operation);
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass(), Topic.Focus.Admonitory, Topic.Severity.Exceptional,e);
        }
    }
    public P buildDiplomat(F fact, ReferenceQueue<F> referenceQueue, B bus, O operational) {
        try {
            return diplomatClass.getDeclaredConstructor(factClass,referenceQueue.getClass(),busClass,operationalClass).newInstance(fact,referenceQueue,bus,operational);
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass(), Topic.Focus.Admonitory, Topic.Severity.Exceptional,e);
        }
    }
}