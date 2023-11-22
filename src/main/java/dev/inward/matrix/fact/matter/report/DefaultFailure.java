package dev.inward.matrix.fact.matter.report;

import dev.inward.matrix.authority.dns.Terrene;
import dev.inward.matrix.Context;
import dev.inward.matrix.Identity;

import java.time.Instant;
import java.util.Map;

public class DefaultFailure extends Report<DefaultFailure, Identity.Ego, Context.Ethereal> {

    public DefaultFailure(Identity.Ghost ghost, Identity.Ego ego, Instant createInstant, String locus, Terrene terrene, Map<String, Object> details) {
        super(ghost, ego, createInstant, locus, terrene,details);
    }
}
