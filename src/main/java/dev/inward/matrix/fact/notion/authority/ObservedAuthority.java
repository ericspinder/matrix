package dev.inward.matrix.fact.notion.authority;

import dev.inward.matrix.domain.ResourceRecord;
import dev.inward.matrix.fact.datum.Identity;

public class ObservedAuthority extends Authority {

    public ObservedAuthority(Identity.Ghost ghost, char authorityCode) {
        super(ghost, new char[] {authorityCode});
    }

    @Override
    public ResourceRecord[] getResourceRecords(String servername) {
        return new ResourceRecord[0];
    }
}
