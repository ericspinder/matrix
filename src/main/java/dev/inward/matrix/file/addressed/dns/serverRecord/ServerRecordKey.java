/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serverRecord;

import dev.inward.matrix.file.addressed.dns.DnsDirectoryKey;
import dev.inward.matrix.file.addressed.dns.RRKey;

import java.net.URI;
import java.util.UUID;

public class ServerRecordKey<K extends ServerRecordKey<K,F,V,M,R,B>,F extends ServerRecord<K,F,V,M,R,B>,V extends ServerRecordView<K,F,V,M,R,B>,M extends ServerRecordModel<K,F,V,M,R,B>,R extends ServerRecordReference<K,F,V,M,R,B>,B extends ServerRecordLibrarian<K,F,V,M,R,B>> extends RRKey<K,F,V,M,R,B> {
    protected ServerRecordKey(URI uri, UUID uuid, DnsDirectoryKey directoryKey,boolean randomUUID) {
        super(uri, uuid, directoryKey,randomUUID);
    }

    public abstract static class Builder<K extends ServerRecordKey<K,F,V,M,R,B>,F extends ServerRecord<K,F,V,M,R,B>,V extends ServerRecordView<K,F,V,M,R,B>,M extends ServerRecordModel<K,F,V,M,R,B>,R extends ServerRecordReference<K,F,V,M,R,B>,B extends ServerRecordLibrarian<K,F,V,M,R,B>> extends RRKey.Builder<K,F,V,M,R,B> {

    }
}
