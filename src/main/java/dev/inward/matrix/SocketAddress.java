/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.dns.serverRecord.ServerRecord;

import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.net.InterfaceAddress;
import java.net.SocketException;

public abstract class SocketAddress implements Comparable<SocketAddress> {

    protected final BigInteger bytes;
    protected final InetSocketAddress inetSocketAddress;
    protected final ServerRecord<?,?,?,?,?,?> serverRecord;

    public SocketAddress(ServerRecord<?,?,?,?,?,?> serverRecord, int port) {
        this.inetSocketAddress = new InetSocketAddress(serverRecord.getInetAddress(),port);
        this.bytes = new BigInteger(1,serverRecord.getInetAddress().getAddress());
        this.serverRecord = serverRecord;
    }
    public static class Local extends SocketAddress {

        protected final LocalSystemNetworking.NetworkMapping networkMapping;

        public Local(ServerRecord<?,?,?,?,?,?> serverRecord, int port, LocalSystemNetworking.NetworkMapping networkMapping) {
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
                throw new RuntimeException(se);
            }
        }
    }
    public static class Remote extends SocketAddress {

        public Remote(ServerRecord<?,?,?,?,?,?> serverRecord, int port) {
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
