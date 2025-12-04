/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.file.addressed.dns.serverRecord;

import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.dns.DnsDirectoryKey;

import java.net.URI;
import java.util.UUID;

public class Ip4ServerRecordKey extends ServerRecordKey<Ip4ServerRecord,Ip4ServerRecordKey,Ip4ServerRecordView,Ip4ServerRecordModel, Ip4ServerRecordReference, Ip4ServerRecordLibrarian> {

    protected Ip4ServerRecordKey(Domain)
    protected Ip4ServerRecordKey(URI uri, UUID uuid, DnsDirectoryKey directoryKey, boolean randomUUID) {
        super(uri, uuid, directoryKey,randomUUID);
    }

    public static class Builder extends ServerRecordKey.Builder<Ip4ServerRecord,Ip4ServerRecordKey,Ip4ServerRecordView,Ip4ServerRecordModel, Ip4ServerRecordReference, Ip4ServerRecordLibrarian> {

        @Override
        protected Ip4ServerRecordKey newMatrixKey() {
            return new Ip4ServerRecordKey(this.uri,this.id,this.directoryKey,this.randomUUID);
        }
    }
}
