package dev.inward.matrix.datum.fact.test;

import dev.inward.matrix.advisor.Manager;
import dev.inward.matrix.datum.fact.Bus;

public class Odeum<T extends Test<T,?,?,?,?,?,?,?>,O extends Odeum<T,O>> extends Bus<T,O> {

    public Odeum(Manager management) {
        super(management);
    }
}
