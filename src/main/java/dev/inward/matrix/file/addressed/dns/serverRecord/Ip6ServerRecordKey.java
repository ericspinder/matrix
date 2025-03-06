/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serverRecord;

import dev.inward.matrix.file.addressed.dns.DnsDirectoryKey;

import java.net.URI;
import java.util.UUID;

public class Ip6ServerRecordKey extends ServerRecordKey<Ip6ServerRecordKey,Ip6ServerRecord,Ip6ServerRecordReference,Ip6ServerRecordAttributes,Ip6ServerRecordResource,Ip6ServerRecordModel> {
    protected Ip6ServerRecordKey(URI uri, UUID uuid, DnsDirectoryKey directoryKey,boolean randomUUID) {
        super(uri, uuid, directoryKey,randomUUID);
    }

    public static class Builder extends ServerRecordKey.Builder<Ip6ServerRecordKey,Ip6ServerRecord,Ip6ServerRecordReference,Ip6ServerRecordAttributes,Ip6ServerRecordResource,Ip6ServerRecordModel> {

        @Override
        protected Ip6ServerRecordKey newFileKey() {
            return new Ip6ServerRecordKey(this.uri,this.id,this.directoryKey,this.randomUUID);
        }
    }
}
