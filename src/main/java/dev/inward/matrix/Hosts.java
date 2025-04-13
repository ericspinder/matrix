/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.depot.indica.IndicaKey;
import dev.inward.matrix.file.addressed.log.Matter;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Hosts<S extends SocketAddress> implements Comparable<Hosts<S>> {

    protected final Map<S, HostExperience> socketAddresses;

    public Hosts(String target, S[] socketAddresses) {
        this.socketAddresses = new ConcurrentHashMap<>();
        for (S socketAddress: socketAddresses) {
            this.socketAddresses.put(socketAddresses, new HostExperience() {
            };
        }
    }
    protected abstract Map<S, HostExperience> initSocketAddresses(S[] socketAddresses);

    public Map<S, HostExperience> getSocketAddresses() {
        return socketAddresses;
    }

    public static class Remote extends Hosts<SocketAddress.Remote> {

        public Remote(String target, final SocketAddress.Remote[] remoteSockets) {
            super(target, remoteSockets);
        }
    }
    public static class LocalHost extends Hosts<SocketAddress.LocalHost> {

        public LocalHost(String target, final SocketAddress.LocalHost[] localHostSockets) {
            super(target, localHostSockets);
        }
    }
    @Override
    public int compareTo(Hosts that) {
        int isZero = this.library.compareTo(that.library);
        if (isZero == 0) {
            isZero = this.target.compareTo(that.target);
            if (isZero == 0) {
                isZero = Arrays.compare(this.socketAddresses,that.socketAddresses);
                if (isZero == 0) {
                    return isZero;
                }
                throw new MatrixException(MatrixException.Type.Host_Target_Match_Array_Mismatch,"Host CompareTo", IndicaKey.Focus.Assembly, Matter.Severity.Critical,new Exception("stack trace..."));
            }
        }
        return isZero;
    }
}
