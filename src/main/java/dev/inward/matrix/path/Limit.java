package dev.inward.matrix.path;

import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.factory.Factory;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.rubric.*;

public class Limit<Y extends Factory<Y,F,O,I,X,B,P,N,A>,DATUM,D extends Datum<DATUM,D,E>,E extends Envoy<DATUM,D,E,F,I,X,P,N,A>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,N,A>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,N,A>,P extends Diplomat<Y,F,O,I,X,B,P,N,A>,N extends Notion<N,I,X,A>,A extends Diplomat<?, N, ?, I, X, ?, A>> extends Complication<Y,DATUM,D,E,F,O,I,X,B,P,N,A,Criterion.Limiter<DATUM,D,E,F,I,X,P,N,A>, Predictor.Limited<Y,DATUM,D,E,F,O,I,X,B,P,N,A>,Limit<Y,DATUM,D,E,F,O,I,X,B,P,N,A>> {


    public Limit(Criteria) {
        super(datumVisitor, methodHandle_s);
    }

    @Override
    public <CRIT extends Criterion<DATUM, D, E, F, I, X, P, N, A, CRIT>, PRE extends Predictor<Y, DATUM, D, E, F, O, I, X, B, P, N, A, CRIT, PRE>> void engage(PRE predictor) {

    }

    @Override
    public boolean engage(E envoy, Position position) {
        return false;
    }

    @Override
    public int compareTo(Criterion.Limiter<DATUM, D, E, F, I, X, P, N, A> o) {
        return 0;
    }
}
