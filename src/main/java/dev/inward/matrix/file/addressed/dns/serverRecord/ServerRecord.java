/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.dns.serverRecord;

import dev.inward.matrix.file.addressed.dns.ResourceRecord;

import java.math.BigInteger;
import java.net.InetAddress;

public abstract class ServerRecord<LB extends ServerRecordLibrarian<LB,K,F,V,M,R,G>, K extends ServerRecordKey<LB,K,F,V,M,R,G>,F extends ServerRecord<LB,K,F,V,M,R,G>,V extends ServerRecordView<LB,K,F,V,M,R,G>,M extends ServerRecordModel<LB,K,F,V,M,R,G>,R extends ServerRecordReference<LB,K,F,V,M,R,G>,G extends ServerRecordSteward<LB,K,F,V,M,R,G>> extends ResourceRecord<LB,K,F,V,M,R,G> {

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
