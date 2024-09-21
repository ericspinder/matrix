package dev.inward.matrix.concept.matter.report;

import dev.inward.matrix.Terrene;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.Context;

import java.time.Instant;
import java.util.Map;

public abstract class Report<R extends Report<R,CI,CX>,CI extends Identity<CI,CX>,CX extends Context<CX>> extends Matter<R,CI,CX> {



    public Report(Identity.Ghost ghost, CI containerId, Instant createInstant, String locus, Terrene terrene, Map<String,Object> details) {
        super(ghost, containerId, createInstant, new Indicia(locus, Indicia.Focus.Monitory, Indicia.Severity.Capacity, terrene));
        this.details = details;
    }
}
