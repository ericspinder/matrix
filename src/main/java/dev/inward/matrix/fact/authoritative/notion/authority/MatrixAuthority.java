package dev.inward.matrix.fact.authoritative.notion.authority;

import dev.inward.matrix.authority.Authority;
import dev.inward.matrix.authority.InternetClass;
import dev.inward.matrix.authority.ResourceRecord;
import dev.inward.matrix.authority.ResourceRecordType;
import dev.inward.matrix.fact.authoritative.Identity;

import java.time.Instant;

public class MatrixAuthority extends Authority<String, Instant,Controller.Matrix> {

    public MatrixAuthority(Identity.Ghost id, Controller.Matrix controller, InternetClass[] internetClasses) {
        super(id, controller, internetClasses);
    }




    @Override
    public ResourceRecord[] getResourceRecords(String servername, ResourceRecordType[] resourceRecordTypes) {
        return new ResourceRecord[0];
    }
}
