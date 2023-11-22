package dev.inward.matrix.fact.authoritative.notion.connection;

import dev.inward.matrix.authority.dns.resourceRecord.ServerRecord;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.Context;

public class Connection extends Notion<Connection, ServerRecord, Context.Demarc,Line> {

    public Connection(ServerRecord id) {
        super(id);
    }


}
