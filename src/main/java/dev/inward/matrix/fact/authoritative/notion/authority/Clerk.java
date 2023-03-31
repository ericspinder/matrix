package dev.inward.matrix.fact.authoritative.notion.authority;

import crud.rubric.Blocker;
import dev.inward.matrix.authority.*;
import dev.inward.matrix.fact.matter.Indicia;

import java.net.*;
import java.nio.channels.AsynchronousChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.time.Instant;

public abstract class Clerk<CHANNEL extends AsynchronousChannel>  {

//    protected final Subject subject = Subject.getSubject(AccessController.getContext());
    protected final Authority authority;
    protected final CHANNEL channel;
    protected final URL url;
    public Clerk(Authority authority, CHANNEL channel, URL url) {
        this.authority = authority;
        this.channel = channel;
        this.url = url;
    }
    public abstract static class Network extends Clerk<AsynchronousSocketChannel> {
        protected final InetSocketAddress local;
        public Network(Authority authority, AsynchronousSocketChannel channel, InetSocketAddress local) {
            super(authority, channel);
            this.local = local;
        }

        public InetSocketAddress getLocal() {
            return local;
        }
        public static class Client extends Network {

            protected final InetSocketAddress remote;

            public Client(Authority authority, AsynchronousSocketChannel channel, InetSocketAddress local, InetSocketAddress remote) {
                super(authority, channel, local);
                this.remote = remote;
            }
            public InetSocketAddress getRemote() {
                return remote;
            }
        }
        public static class Server extends Network {

            public Server(Authority authority, AsynchronousSocketChannel channel, InetSocketAddress local) {
                super(authority, channel, local);
            }
        }
    }
    public record ResourceRecordCache(ResourceRecord resourceRecord, Instant lastUpdate) {

    }

    public Authority getAuthority() {
        return authority;
    }

    private URL getURL() {
        try {
            URL url =  new URL(domain.toString());
            url.openConnection().
            return url;
        }
        catch (MalformedURLException mue) {
            throw new Blocker("url creation", Indicia.Focus.Assembly, Indicia.Severity.Exceptional,mue);
        }

    }

    public CHANNEL getChannel() {
        return channel;
    }
    pu
}
