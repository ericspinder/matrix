package dev.inward.matrix.fact.matter.report;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;

import java.time.Instant;
import java.util.Map;

public class DefaultWarning extends Report<DefaultWarning,Identity.Ego, Context.Ethereal> {
    public DefaultWarning(Identity.Ego cid, Instant createInstant, String locus, Map<String,Object> details) {
        super(cid,cid,createInstant, locus,details);
    }
}
