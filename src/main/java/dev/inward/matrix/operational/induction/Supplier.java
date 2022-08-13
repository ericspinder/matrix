package dev.inward.matrix.operational.induction;

import dev.inward.matrix.advisor.NotionStartupException;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.operational.Engine;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.datum.fact.*;
import dev.inward.matrix.datum.fact.notion.concept.*;
import dev.inward.matrix.factory.Factory;
import dev.inward.matrix.matter.Indicia;
import dev.inward.matrix.rubric.Envoy;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

@SuppressWarnings("unchecked")
public abstract class Supplier<Y extends Factory<Y,F,O,I,X,B,R,IC,XC>,F extends Fact<F,I,X,R,IC,XC>,O extends Operational<Y,F,O,I,X,B,R,IC,XC>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,R,IC,XC>,R extends Representative<F,I,X,R,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>> {
    public final Class<Y> factoryClass = ((Class<Y>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    public final Class<F> factClass = ((Class<F>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
    public final Class<O> operationalClass = ((Class<O>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[2]);
    public final Class<B> busClass = ((Class<B>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[5]);



    public <DATUM,D extends Datum<DATUM,D,V,IC,XC>,V extends Envoy<DATUM,D,V,IC,XC>> V buildEnvoy(D datum,Y factory) {
        Induction<Y,DATUM,D,V,F,I,X,P> induction = (Induction<Y,DATUM,D,V,F,I,X,P>) inductionMap.get(datum.datumClass);
        return induction.createEnvoy(datum,factory);
    }

    public Engine<Y,F,O,I,X,B,R> buildEngine(O operational) {
        return new Engine<Y,F,O,I,X,B,P>(operational);
    }
    public Y buildFactory(M mortal, Map<Specification<F,I,X>, Resource<Y,?,?,?,F,O,I,X,B,P>> resourceMap) {
        try {
            return factoryClass.getDeclaredConstructor(mortalClass, Map.class)
                    .newInstance(mortal,resourceMap);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Exceptional,e);
        }
    }
    public B buildBus(O operation) {
        try {
            return busClass.getDeclaredConstructor(operationalClass).newInstance(operation);
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Exceptional,e);
        }
    }
    public P buildDiplomat(F fact, ReferenceQueue<F> referenceQueue, B bus, O operational) {
        try {
            return diplomatClass.getDeclaredConstructor(factClass,referenceQueue.getClass(),busClass,operationalClass).newInstance(fact,referenceQueue,bus,operational);
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Exceptional,e);
        }
    }
}