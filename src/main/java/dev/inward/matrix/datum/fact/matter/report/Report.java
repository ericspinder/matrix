package dev.inward.matrix.datum.fact.matter.report;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.matter.Indicia;
import dev.inward.matrix.datum.fact.matter.Matter;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public abstract class Report<R extends Report<R,CI,CX>,CI extends Identity<CI,CX>,CX extends Context<CX>> extends Matter<R,CI,CX> {

    protected final Map<String,Object> details;

    public Report(Identity.Ghost ghost, CI containerId, Instant createInstant, String locus, char testCode, Map<String,Object> details) {
        super(ghost, containerId, createInstant, new Indicia(locus, Indicia.Focus.Monitory, Indicia.Severity.Capacity,testCode));
        this.details = details;
    }
}
