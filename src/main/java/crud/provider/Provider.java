package crud.provider;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.Bus;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.fact.Model;
import dev.inward.matrix.fact.Operational;

import java.io.Serializable;

public abstract class Provider<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<Y,D,F,O,I,X,B,P>,F extends Fact<Y,F,O,I,X,B,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Model<Y,F,O,I,X,B,P>,V extends Provider<Y,D,F,O,I,X,B,P,V>> implements Comparable<V>, Serializable {

    public Provider() {
    }

}
