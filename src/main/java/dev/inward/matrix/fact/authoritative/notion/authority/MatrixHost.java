package dev.inward.matrix.fact.authoritative.notion.authority;

import dev.inward.matrix.Host;
import dev.inward.matrix.Terrene;
import dev.inward.matrix.dns.resourceRecord.ResourceRecord;
import dev.inward.matrix.dns.resourceRecord.ResourceRecordType;

import java.time.Instant;

public class MatrixHost extends Host<String, Instant,Controller.Matrix> {

    public MatrixHost(Identity.Ghost id, Controller.Matrix controller, Terrene[] terrenes) {
        super(id, controller, terrenes);
    }




    @Override
    public ResourceRecord[] getResourceRecords(String servername, ResourceRecordType[] resourceRecordTypes) {
        return new ResourceRecord[0];
    }
}
