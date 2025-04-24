/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

import dev.inward.matrix.engine.Zone;

import java.util.concurrent.TimeUnit;

public class DepotCatalogRecord extends CatalogRecord<DepotCatalogRecordKey,DepotCatalogRecord,DepotCatalogRecordView,DepotCatalogRecordModel,DepotCatalogRecordReference, DepotCatalogRecordLibrarian> {
    public DepotCatalogRecord(DepotCatalogRecordKey identity, String target, String startPath, String endPath, Zone zone, String protocol, int priority, int weight, int port, long syncAmount, TimeUnit syncUnit, int ttl) {
        super(identity, target, startPath, endPath, zone, protocol, priority, weight, port, syncAmount, syncUnit,ttl);
    }
}
