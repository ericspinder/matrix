/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.concept.fact.addressed.dns.catalogRecord;

import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.concept.fact.addressed.dns.ResourceRecord;

import java.util.concurrent.TimeUnit;

public class CatalogRecord extends ResourceRecord<CatalogRecord, CatalogRecordKey, CatalogRecordView, CatalogRecordModel, CatalogRecordReference, CatalogRecordLibrarian> {

    protected final String target;
    protected final String startPath;
    protected final String endPath;
    protected final Zone zone;
    protected final String protocol;
    protected final int priority;
    protected final int weight;
    protected final int port;
    protected final long syncAmount;
    protected final TimeUnit syncUnit;
    public CatalogRecord(CatalogRecordKey identity, String target, String startPath, String endPath, Zone zone, String protocol, int priority, int weight, int port, long syncAmount, TimeUnit syncUnit, int ttl) {
        super(identity, ttl);
        this.target = target;
        this.startPath = startPath;
        this.endPath = endPath;
        this.zone = zone;
        this.protocol = protocol;
        this.priority = priority;
        this.weight = weight;
        this.port = port;
        this.syncAmount = syncAmount;
        this.syncUnit = syncUnit;
    }

    public String getStartPath() {
        return startPath;
    }

    public String getEndPath() {
        return endPath;
    }

    public Zone getZone() {
        return zone;
    }

    public String getProtocol() {
        return protocol;
    }

    public int getPriority() {
        return priority;
    }

    public int getWeight() {
        return weight;
    }

    public int getPort() {
        return port;
    }

    public long getSyncAmount() {
        return syncAmount;
    }

    public TimeUnit getSyncUnit() {
        return syncUnit;
    }

    public String getTarget() {
        return target;
    }

}
