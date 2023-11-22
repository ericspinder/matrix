package dev.inward.matrix.fact.threshold;

import dev.inward.matrix.MatrixException;
import dev.inward.matrix.fact.matter.Indicia;
import dev.inward.matrix.resources.LocalSystemNetworking;

import java.math.BigInteger;
import java.net.*;

public abstract class SocketAddress extends InetSocketAddress implements Comparable<SocketAddress> {

    protected final BigInteger bytes;

    public SocketAddress(InetAddress inetAddress, int port) {
        super(inetAddress,port);
        this.bytes = new BigInteger(1,inetAddress.getAddress());

    }
    public static class Local extends SocketAddress {

        protected final LocalSystemNetworking.NetworkMapping networkMapping;

        public Local(LocalSystemNetworking.NetworkMapping networkMapping, int port) {
            super(networkMapping.getInterfaceAddress().getAddress(), port);
            this.networkMapping = networkMapping;
        }

        public final boolean isUp() {
            try {
                boolean result = this.networkMapping.getNetworkInterface().isUp();
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
                throw new MatrixException(MatrixException.Type.NetworkUnavailable_No_Return, this.getClass(), Indicia.Focus.Assembly, Indicia.Severity.Exceptional, se);
            }
        }
    }
    public static class Remote extends SocketAddress {

        public Remote(InetAddress inetAddress, int port) {
            super(inetAddress, port);
        }
    }


    @Override
    public int compareTo(SocketAddress that) {
        int isZero = this.bytes.compareTo(that.bytes);
        if (isZero == 0) {
            return this.getPort() - that.getPort();
        }
        return isZero;
    }
}
