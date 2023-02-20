package dev.inward.matrix.fact.authoritative.notion.connection;

import dev.inward.matrix.domain.Server;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.Context;

public class Connection extends Notion<Connection, Server, Context.Demarc,Line> {

    public Connection(Server id) {
        super(id);
    }


}
