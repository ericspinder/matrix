package dev.inward.matrix.datum.fact.matter.report;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public class DefaultWarning extends Report<DefaultWarning,Identity.Ego, Context.Ethereal> {
    public DefaultWarning(Identity.Ego cid, Instant createInstant, String locus, Map<String,Object> details) {
        super(cid,cid,createInstant, locus,details);
    }
}
