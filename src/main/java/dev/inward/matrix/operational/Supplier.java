package dev.inward.matrix.operational;

import dev.inward.matrix.advisor.Manager;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.advisor.NotionStartupException;
import dev.inward.matrix.rubric.Predictor;
import dev.inward.matrix.rubric.Roller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

@SuppressWarnings("unchecked")
public abstract class Supplier<Y extends Factory<Y,F,O,I,X,B,P>,F extends Fact<F,I,X,P,?,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>> {
    public final Class<Y> factoryClass = ((Class<Y>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    public final Class<F> factClass = ((Class<F>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
    public final Class<O> operationalClass = ((Class<O>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[2]);
    public final Class<B> busClass = ((Class<B>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[5]);
    public final Class<P> progenitorClass = ((Class<P>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[6]);

    public Y getFactory(Progenitor progenitor, LinkedBlockingDeque<O> operationalDeque, Map<Class<?>, List<Predictor<Y,?,F,O,I,X,B,P,?,?,?>>> predictorMap) throws Roller {
        try {
            return factoryClass.getDeclaredConstructor(Progenitor.class, LinkedBlockingDeque.class, operationalDeque.getClass(), Map.class)
                    .newInstance(progenitor, operationalDeque, predictorMap);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass());
        }
    }
    public B getBus(Manager management) throws Roller {
        try {
            return busClass.getDeclaredConstructor(Manager.class).newInstance(management);
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new NotionStartupException()
        }
    }
}