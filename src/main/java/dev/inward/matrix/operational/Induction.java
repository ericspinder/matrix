package dev.inward.matrix.operational;

import dev.inward.matrix.advisor.NotionStartupException;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.*;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.Subject;
import dev.inward.matrix.rubric.Criteria;
import dev.inward.matrix.rubric.Envoy;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;

public abstract class Induction<Y extends Factory<Y,F,?,I,X,?,P,?,?>,DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>,F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<Y,F,?,I,X,?,P,?,?>> {

    public E createEnvoy(D datum, Y factory)  {
        ReferenceQueue<DATUM> referenceQueue = factory.getResources(datum).getReferenceQueue();
        try {
            return datum.envoyClass.getDeclaredConstructor(datum.DATUMClass, ReferenceQueue.class).newInstance(datum, referenceQueue);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass(), Subject.Focus.Admonitory, Subject.Severity.Exceptional,e);
        }
    }
}
