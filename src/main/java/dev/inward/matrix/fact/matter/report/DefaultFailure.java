package dev.inward.matrix.fact.matter.report;

import dev.inward.matrix.domain.InternetClass;
import dev.inward.matrix.fact.authoritative.Governance;
import dev.inward.matrix.fact.authoritative.Identity;

import java.time.Instant;
import java.util.Map;

public class DefaultFailure extends Report<DefaultFailure, Identity.Ego, Governance.Ethereal> {

    public DefaultFailure(Identity.Ghost ghost, Identity.Ego ego, Instant createInstant, String locus, InternetClass internetClass, Map<String, Object> details) {
        super(ghost, ego, createInstant, locus, internetClass,details);
    }
}
