package dev.inward.matrix.fact.authoritative.notion.connection;

import dev.inward.matrix.domain.Server;
import dev.inward.matrix.fact.authoritative.notion.Agent;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.resources.MatrixProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Line extends Agent<Connection, Server, Context.Demarc,Line> {

    public Line(Connection notion, ReferenceQueue<Connection> referenceQueue, Server containerId, MatrixProtectionDomain matrixProtectionDomain) {
        super(notion, referenceQueue, containerId, matrixProtectionDomain);
    }
}
