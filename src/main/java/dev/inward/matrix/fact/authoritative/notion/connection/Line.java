package dev.inward.matrix.fact.authoritative.notion.connection;

import dev.inward.matrix.authority.ServerRecord;
import dev.inward.matrix.fact.authoritative.notion.Agent;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.resources.MatrixProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Line extends Agent<Connection, ServerRecord, Context.Demarc,Line> {

    public Line(Connection notion, ReferenceQueue<Connection> referenceQueue, ServerRecord containerId, MatrixProtectionDomain matrixProtectionDomain) {
        super(notion, referenceQueue, containerId, matrixProtectionDomain);
    }
}
