package dev.inward.matrix.domain;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Arrays;

public class Server extends ResourceRecord<Server> {

    protected final InetAddress inetAddress;

    public Server(Domain domain, InetAddress inetAddress, InternetClass internetClass) {
        super(domain,(inetAddress instanceof Inet4Address)?ResourceRecordType.ipV4Address:ResourceRecordType.ipV6Address, internetClass);
        this.inetAddress = inetAddress;
    }

    public Domain getDomain() {
        return domain;
    }
    public InetAddress getInetAddress() {
        return this.inetAddress;
    }

    @Override
    public int compareTo(Server that) {
        int isZero = this.domain.compareTo(that.domain);
        if (isZero == 0) {
            isZero = this.internetClass.authorityCode - that.internetClass.authorityCode;
            if (isZero == 0) {
                return Arrays.compare(this.inetAddress.getAddress(),that.inetAddress.getAddress());
            }
        }
        return isZero;
    }
}
