package dev.inward.matrix.phenomenon.producer.communications;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.matter.report.Report;
import dev.inward.matrix.fact.Context;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public class CommReport extends Report<CommReport, Identity.Ego, Context.Demarc> {

    public CommReport(UUID uuid, Identity.Ego containerId, Instant createInstant, String locus, Map<String, Object> details) {
        super(uuid, containerId, createInstant, locus, details);
    }
}
