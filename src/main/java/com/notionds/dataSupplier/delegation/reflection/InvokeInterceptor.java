package com.notionds.dataSupplier.delegation.reflection;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.aggregation.Accounting;
import com.notionds.dataSupplier.aggregation.Aggregation;
import com.notionds.dataSupplier.aggregation.InvokeAggregator;
import com.notionds.dataSupplier.delegation.Wrapper;
import com.notionds.dataSupplier.exceptions.NotionExceptionWrapper;
import com.notionds.dataSupplier.operational.Operational;

import java.lang.reflect.Method;
import java.time.Instant;

import static com.notionds.dataSupplier.operational.StringOption.Aggreation_Method_REGEX;

public abstract class InvokeInterceptor<N,O extends Operational<N,W,T>,W extends Wrapper<N,O,T>,T extends Container<N,O,W>,G extends InvokeAggregator> {

    public static class Default<N,O extends Operational<N,W,T>, W extends Wrapper<N,O,T>, T extends Container<N,O,W>, G extends InvokeAggregator> extends InvokeInterceptor<N,O,W,T,G> {

        public Default(O options, Aggregation<O,G> aggregation) {
            super(options, aggregation);
        }
        @Override
        public Accounting startInvoke(Method m, Object[] args) {
            if (m.getName().matches(options.getString(Aggreation_Method_REGEX.getI18n()))) {
                return  aggregation.newInvokeAccounting();
            }
            return null;
        }

        @Override
        public void exception(NotionExceptionWrapper notionExceptionWrapper, String description, Method method, Accounting accounting) {
            aggregation.populateException(notionExceptionWrapper, description, method, accounting);
        }

        @Override
        public void endInvoke(Method m, String description, Accounting accounting) {
            accounting.setFinishTime(Instant.now());
            aggregation.populateExecution(m,  description, accounting);
        }
    }

    protected final O options;
    protected final Aggregation<O,G> aggregation;

    public InvokeInterceptor(O options, Aggregation<O,G> aggregation) {
        this.options = options;
        this.aggregation = aggregation;
    }
    abstract Accounting startInvoke(Method m, Object[] args);

    abstract void exception(NotionExceptionWrapper notionExceptionWrapper, String description, Method m, Accounting accounting);

    abstract void endInvoke(Method m, String description, Accounting accounting);

}
