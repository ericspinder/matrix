package com.notionds.dataSupplier.aggregation;

import dev.inward.matrix.crud.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import dev.inward.matrix.crud.NotionExceptionWrapper;
import com.notionds.dataSupplier.operational.IntegerOption;
import com.notionds.dataSupplier.operational.Operational;

import java.lang.reflect.Method;
import java.util.Map;

public abstract class Aggregation<D extends Datum<?,D,O,C,I>,O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<D,I,?>,G extends InvokeAggregator> {

    protected final O options;
    //protected final G aggregator;
    protected final Map<String, G> sqlExceptionAggregators;
    protected final Map<String, G> nominalOperationAggregators;

    @SuppressWarnings("unchecked")
    public Aggregation(O options, G aggregator) {
        this.options = options;
        //this.aggregator = aggregator;
        sqlExceptionAggregators = new LowCountEviction<>(options.getInteger(IntegerOption.Advice_Exception_Aggregator_Map_Max_Size.getI18n()));
        nominalOperationAggregators = new LowCountEviction<>(options.getInteger(IntegerOption.Advice_Nominal_Aggregator_Map_Max_Size.getI18n()));
    }

    public final Map getSqlExceptionAggregators() {
        return this.sqlExceptionAggregators;
    }
    public final Map getNominalOperationAggregators() {
        return this.nominalOperationAggregators;
    }


    protected abstract G newInvokeAggregator(Method method, String description);
    protected abstract String makeKey(Method method, String description);
    protected abstract String makeKey(NotionExceptionWrapper notionExceptionWrapper, String description);
    public void populateExecution(Method method, String description, Timer timer) {
        String key = makeKey(method, description);
        G ig;
        if (this.nominalOperationAggregators.containsKey(key)) {
            ig = this.nominalOperationAggregators.get(key);
        }
        else {
            ig = this.newInvokeAggregator(method, description);
            this.nominalOperationAggregators.put(key, ig);
        }
        ig.addInvokeAccounting(timer);
    }
    public void populateException(NotionExceptionWrapper notionExceptionWrapper, String description, Method method, Timer timer) {
        String key = makeKey(notionExceptionWrapper, description);
        G ig;
        if (this.sqlExceptionAggregators.containsKey(key)) {
            ig = this.sqlExceptionAggregators.get(key);
        }
        else {
            ig = this.newInvokeAggregator(method, description);
            this.sqlExceptionAggregators.put(key, ig);
        }
        ig.addInvokeAccounting(timer);
    }
    public  abstract Timer newInvokeAccounting();

}
