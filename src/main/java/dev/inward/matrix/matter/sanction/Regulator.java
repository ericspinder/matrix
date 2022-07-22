package dev.inward.matrix.matter.sanction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Bus;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.fact.Diplomat;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.path.Path;

public class Regulator<Y extends Factory<Y,F,O,I,X,B,P>,F extends Fact<Y,F,O,I,X,B,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>,XX extends Path<XX>> extends Fact<Y,F,O,I,X,B,P> {
    public Regulator(I id,XX) {
        super(id);
    }
}
