package dev.inward.matrix.datum.fact.notion.concept;

import dev.inward.matrix.datum.fact.notion.Omnibus;
import dev.inward.matrix.datum.fact.notion.Supervisor;

public class Volume<C extends Concept<C,?,?>,V extends Volume<C,V>> extends Omnibus<C,V> {
    public Volume(Supervisor supervisors) {
        super(supervisors);
    }
}
