package dev.inward.matrix.datum.fact.notion.concept.reporter;

import dev.inward.matrix.datum.fact.notion.Omnibus;
import dev.inward.matrix.datum.fact.notion.Supervisor;

public class Journal<E extends Reporter<E,?,?>,J extends Journal<E,J>> extends Omnibus<E,J> {
    public Journal(Supervisor supervisors) {
        super(supervisors);
    }
}
