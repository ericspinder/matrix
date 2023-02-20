package dev.inward.matrix.fact.matter.report;

import dev.inward.matrix.domain.InternetClass;
import dev.inward.matrix.fact.authoritative.Governance;
import dev.inward.matrix.fact.authoritative.Identity;

import java.time.Instant;
import java.util.Map;

public class Haunting extends Report<Haunting, Identity.Ghost, Governance.Ethereal> {

    public Haunting(Identity.Ghost ghost, Identity.Ghost containerId, Instant createInstant, String locus, InternetClass internetClass, Map<String, Object> details) {
        super(ghost, containerId, createInstant, locus, internetClass, details);
    }
}
