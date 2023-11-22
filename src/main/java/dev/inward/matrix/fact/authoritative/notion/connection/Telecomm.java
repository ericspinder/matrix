package dev.inward.matrix.fact.authoritative.notion.connection;

import dev.inward.matrix.authority.dns.resourceRecord.ServerRecord;
import dev.inward.matrix.fact.authoritative.notion.Industry;
import dev.inward.matrix.Context;
import dev.inward.matrix.resources.Storage;


public class Telecomm extends Industry<Telecomm,Connection, Operated, ServerRecord, Context.Demarc,Switchboard,Line> {
    public Telecomm(Storage<Telecomm, Connection, Operated, ServerRecord, Context.Demarc, Switchboard, Line> storage) {
        super(storage);
    }
}
