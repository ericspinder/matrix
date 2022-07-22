package dev.inward.matrix.fact.notion.concept.matrix;

import dev.inward.matrix.agent.Edition;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.domain.Registrar;
import dev.inward.matrix.fact.notion.concept.Concept;

import java.util.Map;

/**
 * Source Control
 */
public final class Matrix extends Concept<Matrix,Architect> {

    protected final Map<Edition, Registrar> editionRegistrarMap;

    public Matrix(Identity.Ego id, Map<Edition, Registrar> editionRegistrarMap) {
        super(id);
        this.editionRegistrarMap = editionRegistrarMap;
    }


}
