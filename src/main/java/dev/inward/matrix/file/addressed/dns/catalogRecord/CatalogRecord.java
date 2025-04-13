/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.dns.catalogRecord;

import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.file.addressed.dns.ResourceRecord;

import java.util.concurrent.TimeUnit;

public abstract class CatalogRecord<LB extends CatalogRecordLibrarian<LB,K,F,V,M,R,G>,K extends CatalogRecordKey<LB,K,F,V,M,R,G>,F extends CatalogRecord<LB,K,F,V,M,R,G>,V extends CatalogRecordView<LB,K,F,V,M,R,G>,M extends CatalogRecordModel<LB,K,F,V,M,R,G>,R extends CatalogRecordReference<LB,K,F,V,M,R,G>,G extends CatalogRecordSteward<LB,K,F,V,M,R,G>> extends ResourceRecord<LB,K,F,V,M,R,G> {

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
    public CatalogRecord(K identity, String target, String startPath, String endPath, Zone zone, String protocol, int priority, int weight, int port, long syncAmount, TimeUnit syncUnit, int ttl) {
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
