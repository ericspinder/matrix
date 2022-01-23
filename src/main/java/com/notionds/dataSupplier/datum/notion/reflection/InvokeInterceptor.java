package com.notionds.dataSupplier.datum.notion.reflection;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.aggregation.Timer;
import com.notionds.dataSupplier.aggregation.Aggregation;
import com.notionds.dataSupplier.aggregation.InvokeAggregator;
import com.notionds.dataSupplier.datum.Datum;
import dev.inward.matrix.crud.NotionExceptionWrapper;
import com.notionds.dataSupplier.operational.Operational;

import java.lang.reflect.Method;
import java.time.Instant;

import static com.notionds.dataSupplier.operational.StringOption.Aggreation_Method_REGEX;

public abstract class InvokeInterceptor<N,O extends Operational<N,W,T>,W extends Datum<N,O,T>,T extends Container<N,O,W>,G extends InvokeAggregator> extends  {

    public static class Default<N,O extends Operational<N,W,T>, W extends Datum<N,O,T>, T extends Container<N,O,W>, G extends InvokeAggregator> extends InvokeInterceptor<N,O,W,T,G> {

        public Default(O options, Aggregation<O,G> aggregation) {
            super(options, aggregation);
        }
        @Override
        public Timer startInvoke(Method m, Object[] args) {
            m.getModifiers()
            if (m.getName().matches(options.getString(Aggreation_Method_REGEX.getI18n()))) {
                return  aggregation.newInvokeAccounting();
            }
            return null;
        }

        @Override
        public void exception(NotionExceptionWrapper notionExceptionWrapper, String description, Method method, Timer timer) {
            aggregation.populateException(notionExceptionWrapper, description, method, timer);
        }

        @Override
        public void endInvoke(Method m, String description, Timer timer) {
            timer.setFinishTime(Instant.now());
            aggregation.populateExecution(m,  description, timer);
        }
    }

    protected final O options;
    protected final Aggregation<O,G> aggregation;

    public InvokeInterceptor(O options, Aggregation<O,G> aggregation) {
        this.options = options;
        this.aggregation = aggregation;
    }
    abstract Timer startInvoke(Method m, Object[] args);

    abstract void exception(NotionExceptionWrapper notionExceptionWrapper, String description, Method m, Timer timer);

    abstract void endInvoke(Method m, String description, Timer timer);

}
