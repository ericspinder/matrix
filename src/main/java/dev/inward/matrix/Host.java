/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.depot.indica.IndiciaKey;
import dev.inward.matrix.file.addressed.log.Matter;

import java.util.Arrays;
import java.util.Map;

public abstract class Host<S extends SocketAddress> implements Comparable<Host<S>> {

    protected final Map<S, HostExperience> socketAddresses;

    public Host(String target, S[] socketAddresses) {
        this.socketAddresses = socketAddresses;
    }

    public S[] getSocketAddresses() {
        return socketAddresses;
    }

    public static class Remote extends Host<SocketAddress.Remote> {

        public Remote(String target, final SocketAddress.Remote[] remoteSockets) {
            super(target, remoteSockets);
        }
    }
    public static class LocalHost extends Host<SocketAddress.LocalHost> {

        public LocalHost(String target, final SocketAddress.LocalHost[] localHostSockets) {
            super(target, localHostSockets);
        }
    }
    @Override
    public int compareTo(Host that) {
        int isZero = this.library.compareTo(that.library);
        if (isZero == 0) {
            isZero = this.target.compareTo(that.target);
            if (isZero == 0) {
                isZero = Arrays.compare(this.socketAddresses,that.socketAddresses);
                if (isZero == 0) {
                    return isZero;
                }
                throw new MatrixException(MatrixException.Type.Host_Target_Match_Array_Mismatch,"Host CompareTo", IndiciaKey.Focus.Assembly, Matter.Severity.Critical,new Exception("stack trace..."));
            }
        }
        return isZero;
    }
}
