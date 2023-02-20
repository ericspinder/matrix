package dev.inward.matrix.fact.authoritative.notion.connection;

import dev.inward.matrix.domain.Server;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.fact.authoritative.notion.Aspect;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.resources.Supplier;

public class Operated extends Aspect<Telecomm,Connection, Operated, Server, Context.Demarc,Switchboard,Line> {

    public Operated(Zone zone, Specification<Connection, Server, Context.Demarc> specification, Supplier<Telecomm, Connection, Operated, Server, Context.Demarc, Switchboard, Line, Connection, Server, Context.Demarc, Line> supplier) {
        super(zone, specification, supplier);
    }
}

