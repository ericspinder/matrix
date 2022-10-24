package dev.inward.matrix.matter.report;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.matter.Indicia;
import dev.inward.matrix.matter.Matter;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public abstract class Report<R extends Report<R,CI,CX>,CI extends Identity<CI,CX>,CX extends Context<CX>> extends Matter<R,CI,CX> {

    protected final Map<String,Object> details;

    public Report(UUID uuid, CI containerId, Instant createInstant, String locus, Map<String,Object> details) {
        super(uuid, containerId, createInstant, new Indicia(locus, Indicia.Focus.Monitory, Indicia.Severity.Capacity));
        this.details = details;
    }
}
