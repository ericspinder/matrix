package dev.inward.matrix.fact.matter.report;

import dev.inward.matrix.authority.InternetClass;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.Identity;

import java.time.Instant;
import java.util.Map;

public class DefaultFailure extends Report<DefaultFailure, Identity.Ego, Context.Ethereal> {

    public DefaultFailure(Identity.Ghost ghost, Identity.Ego ego, Instant createInstant, String locus, InternetClass internetClass, Map<String, Object> details) {
        super(ghost, ego, createInstant, locus, internetClass,details);
    }
}
