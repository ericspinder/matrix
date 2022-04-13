package dev.inward.matrix.rubric;

import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;
import org.objectweb.asm.ClassVisitor;

public class DatumVisitor<Y extends Factory<Y,F,O,I,X,B,P>,D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P,?,?,?>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<F,B>,P extends Progenitor<Y,F,O,I,X,B,P>,E extends Envoy<Y,D,F,O,I,X,B,P,E>> extends ClassVisitor {

    public DatumVisitor(int api) {
        super(api);
    }
}
