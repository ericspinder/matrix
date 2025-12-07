/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.dns.serviceLocationRecord;

import dev.inward.matrix.file.userInfo.record.DnsDirectoryKey;
import dev.inward.matrix.concept.fact.addressed.dns.RRKey;

import java.net.URI;
import java.util.UUID;

public class ServiceLocationRecordKey extends RRKey<ServiceLocationRecord,ServiceLocationRecordKey,ServiceLocationRecordView,ServiceLocationRecordModel, ServiceLocationRecordReference, ServiceLocationRecordLibrarian> {
    protected ServiceLocationRecordKey(URI uri, UUID uuid, DnsDirectoryKey directoryKey, boolean randomUUID) {
        super(uri, uuid, directoryKey,randomUUID);
    }

    public static class Builder extends RRKey.Builder<ServiceLocationRecord,ServiceLocationRecordKey,ServiceLocationRecordView,ServiceLocationRecordModel, ServiceLocationRecordReference, ServiceLocationRecordLibrarian> {

        @Override
        protected ServiceLocationRecordKey newMatrixKey() {
            return new ServiceLocationRecordKey(this.uri,this.id,this.directoryKey,this.randomUUID);
        }
    }
}
