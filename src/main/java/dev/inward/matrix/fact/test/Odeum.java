package dev.inward.matrix.fact.test;

import dev.inward.matrix.fact.Bus;
import dev.inward.matrix.fact.authoritative.notion.advisor.Manager;

public class Odeum<T extends Test<T,?,?,?,?,?,?,?>,O extends Odeum<T,O>> extends Bus<T,O> {

    public Odeum(Manager management) {
        super(management);
    }
}
