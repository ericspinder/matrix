package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.datum.fact.Bus;

public class Omnibus<N extends Notion<N,?,?,?>,O extends Omnibus<N,O>> extends Bus<N,O> {

    public Omnibus(Supervisor supervisors) {
        super(supervisors);
    }
}
