/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.dns.catalogRecord;

import dev.inward.matrix.file.userInfo.record.DnsDirectoryKey;
import dev.inward.matrix.concept.fact.addressed.dns.ResourceRecordParser;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public abstract class CatalogRecordParser extends ResourceRecordParser<CatalogRecord, CatalogRecordKey, CatalogRecordView, CatalogRecordModel, CatalogRecordReference, CatalogRecordLibrarian> {

    public CatalogRecordParser(DnsDirectoryKey directoryKey) {
        super(directoryKey);
    }

    public CatalogRecord getNew(CatalogRecordKey identity, String target, String startPath, String endPath, Zone zone, String protocol, int priority, int weight, int port, long syncAmount, TimeUnit syncUnit, int ttl) {
        return new CatalogRecord(identity,target, startPath, endPath, zone, protocol, priority, weight, port, syncAmount, syncUnit,ttl);
    }

    @Override
    public CatalogRecord parse(String[] parts) {
        UUID uuid = UUID.fromString(parts[0]);;
        CatalogRecordKey catalogRecordKey = newRRKeyBuilder().setDirectoryKey(dnsDirectoryKey).setId(uuid).setDirectoryKey(dnsDirectoryKey).buildMatrixKey();
        return getNew(catalogRecordKey,parts[1],parts[2],parts[3], Zone.valueOf(parts[4]),parts[5],Integer.parseInt(parts[6]),Integer.parseInt(parts[7]),Integer.parseInt(parts[8]),Long.parseLong(parts[9]),TimeUnit.valueOf(parts[10]),Integer.parseInt(parts[11]));
    }
}
