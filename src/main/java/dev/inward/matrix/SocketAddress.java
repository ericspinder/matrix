package dev.inward.matrix;

import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.dns.resourceRecord.ServerRecord;
import dev.inward.matrix.fact.authoritative.notion.authority.source.ziggurat.Ziggurat;
import dev.inward.matrix.resources.LocalSystemNetworking;

import java.math.BigInteger;
import java.net.*;

public abstract class SocketAddress implements Comparable<SocketAddress> {

    protected final BigInteger bytes;
    protected final InetSocketAddress inetSocketAddress;
    protected final ServerRecord serverRecord;

    public SocketAddress(ServerRecord serverRecord, int port) {
        this.inetSocketAddress = new InetSocketAddress(serverRecord.getInetAddress(),port);
        this.bytes = new BigInteger(1,serverRecord.getInetAddress().getAddress());
        this.serverRecord = serverRecord;
    }
    public static class Local extends SocketAddress {

        protected final LocalSystemNetworking.NetworkMapping networkMapping;

        public Local(ServerRecord serverRecord, int port, LocalSystemNetworking.NetworkMapping networkMapping) {
            super(serverRecord, port);
            this.networkMapping = networkMapping;
        }

        public final boolean isUp() {
            try {
                boolean result = networkMapping.getNetworkInterface().isUp();
                if (result) {
                    for (InterfaceAddress interfaceAddress:networkMapping.getNetworkInterface().getInterfaceAddresses()) {
                        BigInteger checkBytes = new BigInteger(1,interfaceAddress.getAddress().getAddress());
                        if (checkBytes.equals(this.bytes)) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (SocketException se) {
                throw new MatrixException(MatrixException.Type.NetworkUnavailable_No_Return, this.getClass().toString(), Indicia.Focus.Assembly, Indicia.Severity.Exceptional, se);
            }
        }
    }
    public static class Remote extends SocketAddress {

        public Remote(ServerRecord serverRecord, int port) {
            super(serverRecord, port);
        }
    }


    @Override
    public int compareTo(SocketAddress that) {
        int isZero = this.bytes.compareTo(that.bytes);
        if (isZero == 0) {
            isZero = this.serverRecord.compareTo(that.serverRecord);
            if (isZero == 0)  {
                return this.bytes.compareTo(that.bytes);
            }
        }
        return isZero;
    }
}
