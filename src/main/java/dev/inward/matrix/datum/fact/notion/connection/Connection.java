package dev.inward.matrix.datum.fact.notion.connection;

import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.domain.Server;

public class Connection extends Notion<Connection, Server, Context.Demarc,Line> {

    public Connection(Server id) {
        super(id);
    }


}
