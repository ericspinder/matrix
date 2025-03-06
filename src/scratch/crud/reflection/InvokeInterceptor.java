/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud.reflection;

import dev.inward.crud.Aggregation;
import dev.inward.crud.InvokeAggregator;
import dev.inward.crud.NotionExceptionWrapper;
import dev.inward.crud.Container;
import dev.inward.matrix.rubric.aggregation.Timer;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.operational.Operational;

import java.lang.reflect.Method;
import java.time.Instant;

public abstract class InvokeInterceptor<N,O extends Operational<N,W,T>,W extends Datum<N,O,T>,T extends Container<N,O,W>,G extends InvokeAggregator> extends  {

    public static class Default<N,O extends Operational<N,W,T>, W extends Datum<N,O,T>, T extends Container<N,O,W>, G extends InvokeAggregator> extends InvokeInterceptor<N,O,W,T,G> {

        public Default(O options, Aggregation<O,G> aggregation) {
            super(options, aggregation);
        }
        @Override
        public Timer startInvoke(Method m, Object[] args) {
//            m.getModifiers()
//            if (m.getName().matches(options.getString(Aggregation_Method_REGEX.getI18n()))) {
//                return  aggregation.newInvokeAccounting();
//            }
            return null;
        }

        @Override
        public void exception(NotionExceptionWrapper notionExceptionWrapper, String description, Method method, Timer timer) {
            aggregation.populateException(notionExceptionWrapper, description, method, timer);
        }

        @Override
        public void endInvoke(Method m, String description, Timer timer) {
            timer.finish(Instant.now());
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
