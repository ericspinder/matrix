/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.dns.serverRecord;

import dev.inward.matrix.file.addressed.dns.ResourceRecord;

import java.math.BigInteger;
import java.net.InetAddress;

public abstract class ServerRecord<F extends ServerRecord<F,K,V,M,R,L>,K extends ServerRecordKey<F,K,V,M,R,L>,V extends ServerRecordView<F,K,V,M,R,L>,M extends ServerRecordModel<F,K,V,M,R,L>,R extends ServerRecordReference<F,K,V,M,R,L>,L extends ServerRecordLibrarian<F,K,V,M,R,L>> extends ResourceRecord<F,K,V,M,R,L> {

    protected final InetAddress inetAddress;
    protected transient final BigInteger asBytes;

    public ServerRecord(K key, InetAddress inetAddress, int ttl) {
        super(key,ttl);
        this.inetAddress = inetAddress;
        this.asBytes = new BigInteger(1,this.inetAddress.getAddress());
    }

    public InetAddress getInetAddress() {
        return this.inetAddress;
    }

    @Override
    public String toString() {
        return null;
    }

}
