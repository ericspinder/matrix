/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.dns.serverRecord;

import dev.inward.matrix.file.addressed.dns.ResourceRecord;

import java.math.BigInteger;
import java.net.InetAddress;

public abstract class ServerRecord<K extends ServerRecordKey<K,F,V,M,R,B>,F extends ServerRecord<K,F,V,M,R,B>,V extends ServerRecordView<K,F,V,M,R,B>,M extends ServerRecordModel<K,F,V,M,R,B>,R extends ServerRecordReference<K,F,V,M,R,B>,B extends ServerRecordLibrarian<K,F,V,M,R,B>> extends ResourceRecord<K,F,V,M,R,B> {

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
