package com.notionds.dataSupplier.notion.reflection;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.NotionStartupException;
import com.notionds.dataSupplier.notion.Notion;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.options.Options;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;

public class WrappedNotion<N,O extends Options<N,W,T>, W extends Datum<N,O,T>,T extends Container<N,O,W>> extends Notion<N,O,W,T> {

    private Constructor<W> wrapperConstructor = null;
    @SuppressWarnings("unchecked")
    public WrappedNotion(O operational, ClassLoader classLoader) {
        super(operational, classLoader);

        try {
            this.wrapperConstructor =  ((Class<W>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[2])
                    .getConstructor(operationalClass, containerClass, delegateClass);
        }
        catch (NoSuchMethodException e) {
            throw new NotionStartupException(NotionStartupException.Type.ConstructorProblem_Reflective, this.getClass());
        }
    }

    @Override
    public W getDelegate(T container, N delegate, Object[] args) {
        try {
            if (args == null || args.length == 0) return this.wrapperConstructor.newInstance(this.operational, container, delegate);
        }
        catch (ReflectiveOperationException e) {
            throw new NotionStartupException(NotionStartupException.Type.ConstructorProblem_Reflective, this.getClass());
        }
        throw new NotionStartupException(NotionStartupException.Type.ConstructorProblem_Reflective, this.getClass());
    }
}
