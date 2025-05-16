/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.library.bureau;

import dev.inward.matrix.Hosts;
import dev.inward.matrix.SocketAddress;

import java.sql.Connection;
import java.util.concurrent.locks.StampedLock;

public abstract class Clerk<B extends Bureau<B,W>,W extends Clerk<B,W>> {

    protected final B bureau;
    protected final StampedLock gate = new StampedLock();

    public Clerk(B bureau) {
        this.bureau = bureau;
    }

    public static class File extends Clerk<Bureau.File,File> {

        public File(Bureau.File bureau) {
            super(bureau);
        }
    }

    public static class Jdbc extends Clerk<Bureau.Jdbc,Jdbc> {

        protected final Connection connection;

        public Jdbc(Bureau.Jdbc bureau, Connection connection) {
            super(bureau);
            this.connection = connection;
        }

        public Connection getConnection() {
            return connection;
        }
    }

    public abstract static class Network<B extends Bureau.Network<B,C,H,S>,C extends Network<B,C,H,S>,H extends Hosts<S>,S extends SocketAddress> extends Clerk<B,C> {

        protected final H source;

        public Network(B bureau, H source) {
            super(bureau);
            this.source = source;
        }

        public static class NioClient extends Network<Bureau.Network.NioClient,NioClient, Hosts.Remote,SocketAddress.Remote> {

            public NioClient(Bureau.Network.NioClient bureau, Hosts.Remote source) {
                super(bureau, source);
            }
        }
        public static class NioServer extends Network<Bureau.Network.NioServer, NioServer, Hosts.LocalHost, SocketAddress.LocalHost> {

            public NioServer(Bureau.Network.NioServer bureau, Hosts.LocalHost source) {
                super(bureau, source);
            }
        }
        public H getSource() {
            return source;
        }
    }
}
