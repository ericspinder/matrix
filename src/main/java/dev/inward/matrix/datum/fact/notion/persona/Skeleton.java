package dev.inward.matrix.datum.fact.notion.persona;

import dev.inward.matrix.datum.fact.notion.Omnibus;
import dev.inward.matrix.datum.fact.notion.Supervisor;

public final class Skeleton extends Omnibus<Persona,Skeleton> {

    public Skeleton(Supervisor supervisors) {
        super(supervisors);
    }
}
