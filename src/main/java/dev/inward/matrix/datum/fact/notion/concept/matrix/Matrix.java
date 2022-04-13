package dev.inward.matrix.datum.fact.notion.concept.matrix;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Context;

/**
 * Source Control
 */
public final class Matrix extends Concept<Matrix, Context.Service,Architect> {

    public Matrix(Identity.SuperEgo<Context.Service> id) {
        super(id);
    }
}
