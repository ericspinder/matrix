package dev.inward.matrix.fact;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.Matter;
import dev.inward.matrix.phenomenon.Phenomenon;
import dev.inward.matrix.phenomenon.Tolerances;
import dev.inward.matrix.route.Route;

import java.util.concurrent.ConcurrentLinkedDeque;


public abstract class Model<F extends Fact<F,I,X>,I extends Identity<I,X>,X extends Context<X>,O extends Operational<F,I,X,O>,B extends Bus<F,I,X,B,R>,R extends Representative<F,I,X,R,?,?>,M extends Matter<M,I,X>,T extends Tolerances<M,T>,P extends Phenomenon<M,T,P>,D extends Model<F,I,X,O,B,R,M,T,P,D>> extends Route<F,I,X,O,B,R,M,T,P> {

    protected final ConcurrentLinkedDeque<B> buses = new ConcurrentLinkedDeque<>();
    public Model() {

    }


    @Override
    public int compareTo(D o) {
        return 0;
    }

    public O getOperational() {
        return operational;
    }

    public Route<F,I,X,O,B,R,M,T,P> getRoute() {
        return route;
    }
}