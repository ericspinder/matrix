package dev.inward.matrix.fact.authoritative.notion.authority;

import dev.inward.matrix.domain.InternetClass;
import dev.inward.matrix.domain.ResourceRecord;
import dev.inward.matrix.domain.ResourceRecordType;
import dev.inward.matrix.domain.Server;
import dev.inward.matrix.fact.tracked.Controller;
import dev.inward.matrix.fact.authoritative.Identity;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class ObservedAuthority extends Authority {

    public ObservedAuthority() {
        super(nameservers);
    }

    @Override
    public ResourceRecord[] getResourceRecords(String servername, ResourceRecordType[] resourceRecordTypes) {
        return new ResourceRecord[0];
    }
}
