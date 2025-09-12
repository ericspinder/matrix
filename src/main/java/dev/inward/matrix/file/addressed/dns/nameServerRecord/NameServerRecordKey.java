/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.nameServerRecord;

import dev.inward.matrix.file.userInfo.record.DnsDirectoryKey;
import dev.inward.matrix.file.addressed.dns.RRKey;

import java.net.URI;
import java.util.UUID;

public class NameServerRecordKey extends RRKey<NameServerRecord,NameServerRecordKey,NameServerRecordView,NameServerRecordModel, NameServerRecordReference, NameServerRecordLibrarian> {
    protected NameServerRecordKey(URI uri, UUID uuid, DnsDirectoryKey directoryKey,boolean randomUUID) {
        super(uri, uuid, directoryKey,randomUUID);
    }

    public static class Builder extends RRKey.Builder<NameServerRecord,NameServerRecordKey,NameServerRecordView,NameServerRecordModel, NameServerRecordReference, NameServerRecordLibrarian> {

        @Override
        protected NameServerRecordKey newMatrixKey() {
            return new NameServerRecordKey(this.uri,this.id,this.directoryKey,this.randomUUID);
        }
    }
}
