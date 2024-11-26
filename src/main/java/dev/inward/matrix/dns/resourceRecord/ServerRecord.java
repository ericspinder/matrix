package dev.inward.matrix.dns.resourceRecord;

import dev.inward.matrix.Domain;
import dev.inward.matrix.Terrene;

import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;

public class ServerRecord extends ResourceRecord<ServerRecord> {

    protected final InetAddress inetAddress;
    protected transient final BigInteger asBytes;

    public ServerRecord(Terrene terrene, Domain domain, InetAddress inetAddress,int ttl) {
        super(terrene,domain,(inetAddress instanceof Inet4Address)? ResourceRecordType.ipV4Address:ResourceRecordType.ipV6Address,ttl);
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

    @Override
    public int compareTo(ServerRecord that) {
        int isZero = super.compareTo(that);
        if (isZero == 0) {
            return this.asBytes.compareTo(that.asBytes);
        }
        return isZero;
    }
}
