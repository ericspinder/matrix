package dev.inward.matrix.fact.notion.connection;

import dev.inward.matrix.fact.notion.Agent;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.domain.Server;
import dev.inward.matrix.resources.NotionProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Line extends Agent<Connection, Server, Context.Demarc,Line> {

    public Line(Connection notion, ReferenceQueue<Connection> referenceQueue, Server containerId, NotionProtectionDomain notionProtectionDomain) {
        super(notion, referenceQueue, containerId, notionProtectionDomain);
    }
}
