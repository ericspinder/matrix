/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.dns.serverRecord.ServerRecord;
import dev.inward.matrix.file.addressed.dns.serverRecord.ServerRecordKey;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.InterfaceAddress;
import java.net.SocketException;

public abstract class SocketAddress implements Comparable<SocketAddress> {

    protected final BigInteger bytes;
    protected final InetSocketAddress inetSocketAddress;

    public SocketAddress(InetAddress inetAddress, int port) {
        this.inetSocketAddress = new InetSocketAddress(inetAddress,port);
        this.bytes = new BigInteger(1,inetAddress.getAddress());
    }
    public static class LocalHost extends SocketAddress {

        protected final LocalSystemNetworking.NetworkMapping networkMapping;

        public LocalHost(InetAddress inetAddress, int port) {
            super(inetAddress, port);
            LocalSystemNetworking.NetworkMapping mapping = null;
            for (LocalSystemNetworking.NetworkMapping networkMapping: LocalSystemNetworking.getInstance().getExternalActiveInterfaces().keySet()) {
                if (networkMapping.getInterfaceAddress().getAddress().equals(inetAddress)) {
                    mapping = networkMapping;
                }
            }
            this.networkMapping = mapping;
        }

        public final boolean isUp() {
            try {
                boolean result = networkMapping.getNetworkInterface().isUp();
                if (result) {
                    for (InterfaceAddress interfaceAddress:networkMapping.getNetworkInterface().getInterfaceAddresses()) {
                        BigInteger checkBytes = new BigInteger(1,interfaceAddress.getAddress().getAddress());
                        if (checkBytes.equals(this.bytes) && interfaceAddress.getAddress().isAnyLocalAddress()) {
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

        public Remote(InetAddress inetAddress, int port) {
            super(inetAddress, port);
        }
    }


    @Override
    public int compareTo(SocketAddress that) {
        int isZero = this.bytes.compareTo(that.bytes);
        if (isZero == 0) {
            return this.inetSocketAddress.getPort() - that.inetSocketAddress.getPort();
        }
        return isZero;
    }
}
