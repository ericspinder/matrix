package dev.inward.matrix.datum;

import dev.inward.matrix.advisor.NotionStartupException;
import dev.inward.matrix.matter.Subject;
import dev.inward.matrix.rubric.Envoy;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;


public abstract class Datum<DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,?,?,?,?,?,?>> implements Serializable {

    @SuppressWarnings("unchecked")
    public final Class<DATUM> DATUMClass = ((Class<DATUM>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    @SuppressWarnings("unchecked")
    public final Class<D> datumClass = ((Class<D>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
    @SuppressWarnings("unchecked")
    public final Class<E> envoyClass = ((Class<E>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[2]);

    protected Tracking<DATUM,D,E> tracking = new Tracking(this);

    public E get(ReferenceQueue<DATUM> referenceQueue) {
        try {
            return envoyClass.getDeclaredConstructor(datumClass, referenceQueue.getClass()).newInstance(this,referenceQueue);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new NotionStartupException(NotionStartupException.Type.ReflectiveOperationFailed,this.getClass(), Subject.Focus.Admonitory, Subject.Severity.Exceptional,e);
        }
    }
}
