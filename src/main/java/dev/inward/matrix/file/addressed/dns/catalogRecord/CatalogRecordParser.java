/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.file.userInfo.record.DnsDirectoryKey;
import dev.inward.matrix.file.addressed.dns.ResourceRecordParser;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public abstract class CatalogRecordParser extends ResourceRecordParser<LibraryRecord, LibraryRecordKey, LibraryRecordView, LibraryRecordModel, LibraryRecordReference, LibraryRecordLibrarian> {

    public CatalogRecordParser(DnsDirectoryKey directoryKey) {
        super(directoryKey);
    }

    public LibraryRecord getNew(LibraryRecordKey identity, String target, String startPath, String endPath, Zone zone, String protocol, int priority, int weight, int port, long syncAmount, TimeUnit syncUnit, int ttl) {
        return new LibraryRecord(identity,target, startPath, endPath, zone, protocol, priority, weight, port, syncAmount, syncUnit,ttl);
    }

    @Override
    public LibraryRecord parse(String[] parts) {
        UUID uuid = UUID.fromString(parts[0]);;
        LibraryRecordKey libraryRecordKey = newRRKeyBuilder().setDirectoryKey(dnsDirectoryKey).setId(uuid).setDirectoryKey(dnsDirectoryKey).buildMatrixKey();
        return getNew(libraryRecordKey,parts[1],parts[2],parts[3], Zone.valueOf(parts[4]),parts[5],Integer.parseInt(parts[6]),Integer.parseInt(parts[7]),Integer.parseInt(parts[8]),Long.parseLong(parts[9]),TimeUnit.valueOf(parts[10]),Integer.parseInt(parts[11]));
    }
}
