package dev.inward.matrix.fact.matter.report;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.fact.matter.Matter;

import java.time.Instant;
import java.util.Map;

public abstract class Report<R extends Report<R,CI,CX>,CI extends Identity<CI,CX>,CX extends Context<CX>> extends Matter<R,CI,CX> {

    protected final Map<String,Object> details;

    public Report(Identity.Ghost ghost, CI containerId, Instant createInstant, String locus, char testCode, Map<String,Object> details) {
        super(ghost, containerId, createInstant, new Indicia(locus, Indicia.Focus.Monitory, Indicia.Severity.Capacity,testCode));
        this.details = details;
    }
}
