package dev.inward.matrix.dns.resourceRecord;

import dev.inward.matrix.Domain;
import dev.inward.matrix.Terrene;

import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;

public class ServerRecord extends ResourceRecord<ServerRecord> {

    protected final InetAddress inetAddress;
    protected transient final BigInteger asBytes;

    public ServerRecord(ResourceRecord.Identity<ServerRecord> identity, InetAddress inetAddress,int ttl) {
        super(identity,ttl);
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
