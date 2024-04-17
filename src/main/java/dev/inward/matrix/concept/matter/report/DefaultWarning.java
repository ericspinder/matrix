package dev.inward.matrix.concept.matter.report;

import dev.inward.matrix.Context;
import dev.inward.matrix.Identity;

import java.time.Instant;
import java.util.Map;

public class DefaultWarning extends Report<DefaultWarning,Identity.Ego, Context.Ethereal> {
    public DefaultWarning(Identity.Ego cid, Instant createInstant, String locus, Map<String,Object> details) {
        super(cid,cid,createInstant, locus,details);
    }
}
