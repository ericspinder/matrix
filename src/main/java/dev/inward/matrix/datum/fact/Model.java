package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.matter.Matter;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.phenomenon.Tolerances;


public abstract class Model<F extends Fact<F,I,X>,I extends Identity<I,X>,X extends Context<X>,O extends Operational<F,I,X,O,N,NI,NX,M,T>,B extends Bus<F,I,X,O,B,N,NI,NX,M,T>,D extends Model<F,I,X,O,B,D,M,T>,M extends Matter<M,I,X>,T extends Tolerances<M,T>> implements Comparable<D> {

    public Model() {

    }

    public abstract B ticket(Representative representative);
}
