/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.dns.serverRecord;

import dev.inward.matrix.dns.DnsDirectoryKey;
import dev.inward.matrix.concept.fact.addressed.dns.RRKey;

import java.net.URI;
import java.util.UUID;

public class ServerRecordKey<F extends ServerRecord<F,K,V,M,R,L>,K extends ServerRecordKey<F,K,V,M,R,L>,V extends ServerRecordView<F,K,V,M,R,L>,M extends ServerRecordModel<F,K,V,M,R,L>,R extends ServerRecordReference<F,K,V,M,R,L>,L extends ServerRecordLibrarian<F,K,V,M,R,L>> extends RRKey<F,K,V,M,R,L> {
    protected ServerRecordKey(URI uri, UUID uuid, DnsDirectoryKey directoryKey, boolean randomUUID) {
        super(uri, uuid, directoryKey,randomUUID);
    }

    public abstract static class Builder<F extends ServerRecord<F,K,V,M,R,L>,K extends ServerRecordKey<F,K,V,M,R,L>,V extends ServerRecordView<F,K,V,M,R,L>,M extends ServerRecordModel<F,K,V,M,R,L>,R extends ServerRecordReference<F,K,V,M,R,L>,L extends ServerRecordLibrarian<F,K,V,M,R,L>> extends RRKey.Builder<F,K,V,M,R,L> {

    }
}
