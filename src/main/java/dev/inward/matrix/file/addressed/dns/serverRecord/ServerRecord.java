/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.dns.serverRecord;

import dev.inward.matrix.file.addressed.dns.*;

import java.math.BigInteger;
import java.net.InetAddress;

public abstract class ServerRecord<K extends ServerRecordKey<K,F,R,A,RESOURCE,M>,F extends ServerRecord<K,F,R,A,RESOURCE,M>,R extends ServerRecordReference<K,F,R,A,RESOURCE,M>,A extends ServerRecordAttributes<K,F,R,A,RESOURCE,M>,RESOURCE extends ServerRecordResource<K,F,R,A,RESOURCE,M>,M extends ServerRecordModel<K,F,R,A,RESOURCE,M>> extends ResourceRecord<K,F,R,A,RESOURCE,M> {

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
