package dev.inward.matrix;

import java.io.IOException;
import java.net.URLConnection;
import java.nio.channels.*;
import java.util.UUID;
import java.util.concurrent.locks.StampedLock;

public abstract class Clerk<S extends Scheme<S,L>,L extends Library<S,L>,CHANNEL extends AsynchronousChannel,C extends Clerk<S,L,CHANNEL,C>> extends URLConnection implements Comparable<C> {

    protected final StampedLock gate = new StampedLock();
    protected final L library;
    protected final transient CHANNEL channel;

    public Clerk(L library ,CHANNEL channel) {
        super(library.domain.getUrl());
        this.library = library;
        this.channel = channel;
    }
    public final L getLibrary() {
        return library;
    }



    public abstract static class Network<S extends Scheme<S,L>,L extends Library<S,L>,H extends Host<H>,CHANNEL extends NetworkChannel & AsynchronousChannel,N extends Network<S,L,H,CHANNEL,N>> extends Clerk<S,L,CHANNEL,N> {

        protected final H host;

        public Network(L library,CHANNEL channel,H host) {
            super(library,channel);
            this.host = host;
        }

        public static class Client<S extends Scheme<S,L>,L extends Library<S,L>> extends Network<S,L,Host.Remote, AsynchronousSocketChannel,Client<S,L>> {

            public Client(L library, AsynchronousSocketChannel channel,Host.Remote remoteHost) {
                super(library,channel,remoteHost);
            }

            @Override
            public void connect() throws IOException {

            }

        }
        public static class Server<S extends Scheme<S,L>,L extends Library<S,L>> extends Network<S,L,Host.Principal, AsynchronousServerSocketChannel,Server<S,L>> {

            public Server(L library,AsynchronousServerSocketChannel channel, Host.Principal principalHost) {
                super(library,channel,principalHost);
            }

            @Override
            public void connect() throws IOException {

            }

        }
        public H getHost() {
            return host;
        }
    }
    public boolean hardClosed() throws CheckedException {
        if (this.closed) {
            throw new CheckedException(UUID.randomUUID(),this.getClass().getModule()Context<S,L,>)
        }
    }
    public boolean isOpen() {
        return this.channel.isOpen();
    }

    protected CHANNEL getChannel() {
        return channel;
    }

    @Override
    public int compareTo(C that) {
        int isZero = this.library.domain.compareTo(that.library.domain);

    }
}
