package dev.inward.matrix.resources;

import dev.inward.matrix.MatrixException;
import dev.inward.matrix.Representitive;
import dev.inward.matrix.fact.*;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.Notion;
import dev.inward.matrix.Context;
import dev.inward.matrix.phenomenon.Phenomenon;
import dev.inward.matrix.phenomenon.Tolerant;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

@SuppressWarnings("unchecked")
public class Supplier<F extends Fact<F,I,ID,X>,I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<X>,O extends Operational<F,I,X,O,?,?>,B extends Bus<F,I,ID,VERSION,X,R,?>,R extends Representitive<F,I,ID,VERSION,X,R,NI>,N extends Notion<N,NI,NX,?,?,?>,NI extends Identity<NI,>,NX extends Context<NX>,M extends Matter<M,I,X>,T extends Tolerant<M,T>,P extends Phenomenon<M,T,P>> {

    public final Class<Y> factoryClass = ((Class<Y>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    public final Class<F> factClass = ((Class<F>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
    public final Class<I> identityClass = ((Class<I>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[2]);
    public final Class<R> representativeClass = ((Class<R>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[6]);


    public B buildBus(O operational) {
        try {
            return busClass.getDeclaredConstructor(operationalClass).newInstance(operational);
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new MatrixException(MatrixException.Type.ReflectiveOperationFailed,this.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Exceptional,e);
        }
    }
    public R buildRepresentative(F fact, NI containerId, ReferenceQueue<F> referenceQueue) {
        try {
            return representativeClass.getDeclaredConstructor(factClass,referenceQueue.getClass(),busClass,operationalClass).newInstance(fact,referenceQueue,bus,operational);
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new MatrixException(MatrixException.Type.ReflectiveOperationFailed,this.getClass(), Indicia.Focus.Admonitory, Indicia.Severity.Exceptional,e);
        }
    }
}