package dev.inward.matrix.matter.report;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public class DefaultWarning extends Report<DefaultWarning,Identity.Ego, Context.Demarc> {
    public DefaultWarning(UUID uuid, Identity.Ego cid, Instant createInstant, String locus, Map<String,Object> details) {
        super(uuid,cid,createInstant, locus,details);
    }
}
