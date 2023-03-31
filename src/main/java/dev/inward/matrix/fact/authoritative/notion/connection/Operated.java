package dev.inward.matrix.fact.authoritative.notion.connection;

import dev.inward.matrix.authority.ServerRecord;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.fact.authoritative.notion.Aspect;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.resources.Supplier;

public class Operated extends Aspect<Telecomm,Connection, Operated, ServerRecord, Context.Demarc,Switchboard,Line> {

    public Operated(Zone zone, Specification<Connection, ServerRecord, Context.Demarc> specification, Supplier<Telecomm, Connection, Operated, ServerRecord, Context.Demarc, Switchboard, Line, Connection, ServerRecord, Context.Demarc, Line> supplier) {
        super(zone, specification, supplier);
    }
}

