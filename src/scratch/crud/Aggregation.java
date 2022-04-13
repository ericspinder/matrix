package crud;

import dev.inward.matrix.datum.fact.notion.Path;
import dev.inward.matrix.rubric.aggregation.Timer;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Id;
import dev.inward.matrix.operational.Operational;

import java.lang.reflect.Method;
import java.util.Map;

public abstract class Aggregation<Y extends Factory<Y,F,O,I,X,B,?>,D extends Datum<Y,D,F,O,I,X,B,?>,F extends Fact<Y,F,O,I,X,B,?>,O extends Operational<Y,F,O,I,X,B,?>,I extends Id<Y,I,X>,X extends Path<Y,X>,B extends Bus<F,B>> {

    @SuppressWarnings("unchecked")
    public Aggregation(O options, G aggregator) {

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
