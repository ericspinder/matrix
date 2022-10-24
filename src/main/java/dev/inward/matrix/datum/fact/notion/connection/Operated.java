package dev.inward.matrix.datum.fact.notion.connection;

import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.datum.fact.notion.Aspect;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.domain.Server;
import dev.inward.matrix.resources.Supplier;
import dev.inward.matrix.engine.Zone;

public class Operated extends Aspect<Telecomm,Connection, Operated, Server, Context.Demarc,Switchboard,Line> {

    public Operated(Zone zone, Specification<Connection, Server, Context.Demarc> specification, Supplier<Telecomm, Connection, Operated, Server, Context.Demarc, Switchboard, Line, Connection, Server, Context.Demarc, Line> supplier) {
        super(zone, specification, supplier);
    }
}

