package dev.inward.matrix.fact.authoritative.notion.connection;

import dev.inward.matrix.dns.resourceRecord.ServerRecord;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.Aspect;
import dev.inward.matrix.Context;
import dev.inward.matrix.resources.Supplier;

public class Operated extends Aspect<Telecomm,Connection, Operated, ServerRecord, Context.Demarc,Switchboard,Line> {

    public Operated(Zone zone, Specification<Connection, ServerRecord, Context.Demarc> specification, Supplier<Telecomm, Connection, Operated, ServerRecord, Context.Demarc, Switchboard, Line, Connection, ServerRecord, Context.Demarc, Line> supplier) {
        super(zone, specification, supplier);
    }
}

