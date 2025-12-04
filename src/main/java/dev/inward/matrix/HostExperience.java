/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.time.Instant;

public abstract class HostExperience<S extends SocketAddress> {

    protected final S socketAddress;
    protected Instant lastUpdate = Instant.now();

    public HostExperience(S socketAddress) {
        this.socketAddress = socketAddress;
    }
    public Instant getLastUpdate() {
        return lastUpdate;
    }
    public void resetLastUpdate() {
        this.lastUpdate = Instant.now();
    }

    public static class Server extends HostExperience<SocketAddress.LocalHost> {

        public Server(SocketAddress.LocalHost localHostSocketAddress) {
            super(localHostSocketAddress);
        }

    }
    public static class Client extends HostExperience<SocketAddress.Remote> {

        public Client(SocketAddress.Remote inetAddress) {
            super(inetAddress);
        }

    }

}
