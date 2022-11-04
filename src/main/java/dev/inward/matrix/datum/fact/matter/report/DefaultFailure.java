package dev.inward.matrix.datum.fact.matter.report;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public class DefaultFailure extends Report<DefaultFailure, Identity.Ego, Context.Ethereal> {

    public DefaultFailure(UUID uuid, Identity.Ego containerId, Instant createInstant, String locus, Map<String, Object> details) {
        super(uuid, containerId, createInstant, locus, details);
    }
}
