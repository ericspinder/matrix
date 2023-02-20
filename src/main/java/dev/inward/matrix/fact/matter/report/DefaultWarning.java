package dev.inward.matrix.fact.matter.report;

import dev.inward.matrix.fact.authoritative.Governance;
import dev.inward.matrix.fact.authoritative.Identity;

import java.time.Instant;
import java.util.Map;

public class DefaultWarning extends Report<DefaultWarning,Identity.Ego, Governance.Ethereal> {
    public DefaultWarning(Identity.Ego cid, Instant createInstant, String locus, Map<String,Object> details) {
        super(cid,cid,createInstant, locus,details);
    }
}
