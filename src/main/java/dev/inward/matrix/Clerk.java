package dev.inward.matrix;

import dev.inward.matrix.fact.authoritative.notion.authority.source.ziggurat.Ziggurat;
import dev.inward.matrix.route.Road;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketOption;
import java.net.URI;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.StampedLock;

public abstract class Clerk {

    protected final Library<?,?,?> library;

    protected final StampedLock gate = new StampedLock();

    public Clerk(Library<?,?,?> library) {
        this.library = library;
    }

    public abstract static class File extends Clerk {

        public File(Library<?,?,?> library) {
            super(library);
        }
    }

    public abstract static class JDBC extends Clerk {

        protected final Connection connection;

        public JDBC(Library<?,?,?> library, Connection connection) {
            super(library);
            this.connection = connection;
        }

        public Connection getConnection() {
            return connection;
        }
    }

    public abstract static class Network<H extends Host<S>,S extends SocketAddress,C extends AsynchronousChannel & NetworkChannel> extends Clerk {

        protected final H source;
        protected final C channel;
        protected final Charset charset;
        public Network(Library<?,?,?> library, H source, C channel, Map<SocketOption<Object>,Object> socketOptions,Charset charset) throws IOException {
            super(library);
            this.source = source;
            this.channel = channel;
            for (SocketOption<Object> socketOption: socketOptions.keySet()) {
                this.channel.setOption(socketOption,socketOptions.get(socketOption));
            }
            this.charset = charset;
        }

        public Charset getCharset() {
            return charset;
        }

        public static class Client extends Network<Host.Remote,SocketAddress.Remote,AsynchronousSocketChannel> {

            public Client(Library<?,?,?> library, Host.Remote remoteHost, AsynchronousChannelGroup group, SocketAddress socketAddress, Map<SocketOption<Object>,Object> socketOptions, Charset charset, URI uri) throws IOException, ExecutionException, InterruptedException {
                super(library, remoteHost,AsynchronousSocketChannel.open(group),socketOptions,charset);
                (this.channel.connect(socketAddress.inetSocketAddress)).get();
                uri.get
            }

            public OutputStream getOutputStream() throws IOException {
                this.channel.write(outputStream,(int) source.properties.getOrDefault("timeout_value",5),);
            }

            public InputStream getInputStream() throws IOException {
                return null;
            }

            public static class Request {

                protected final Library library;
                protected final Host.Remote remote;
                public Request(URI uri) {
                    Ziggurat.Instance().

                }
            }

        }
        public static class Server extends Network<Host.LocalHost, SocketAddress.Local,AsynchronousServerSocketChannel> {

            private SelectionKey selectionKey;

            public Server(Library<?,?,?> library, Host.LocalHost localHost, Road.Network<?> network, Map<SocketOption<Object>,Object> socketOptions, Charset charset, int backlog) throws IOException {
                super(library,localHost,AsynchronousServerSocketChannel.open(network.getGroup()),socketOptions,charset);
                this.channel.bind(localHost.socketAddresses.inetSocketAddress,backlog);
                this.channel.
            }
        }
        public H getSource() {
            return source;
        }
        public C getChannel() {
            return channel;
        }
    }
}
