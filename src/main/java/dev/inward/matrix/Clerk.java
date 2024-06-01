package dev.inward.matrix;

import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.route.Dispatch;
import dev.inward.matrix.route.Driver;
import dev.inward.matrix.route.Road;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.*;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.locks.StampedLock;

public abstract class Clerk<DISPATCH extends Dispatch<DISPATCH,R,D,RIDER>,R extends Road<DISPATCH,R,D,RIDER>,D extends Driver<DISPATCH,R,D,RIDER>,RIDER extends Closeable,C extends Clerk<DISPATCH,R,D,RIDER,C>> implements Comparable<C> {

    protected final StampedLock gate = new StampedLock();
    protected final R road;
    protected transient WeakHashMap<RIDER,  D> engagedRiders;


    public Clerk(R road) {
        this.road = road;
    }

    public abstract RIDER makeConnection() throws IOException;
    public R getRoad() {
        return road;
    }

    public abstract static class File extends Clerk<Dispatch.Editor,Road.Concrete,Driver.Scribe,AsynchronousFileChannel,File> {

        public File(Road.Concrete road) {
            super(road);
        }
    }



    public abstract static class Network<H extends Host, RIDER extends AsynchronousChannel,N extends Network<H, RIDER,N>> extends Clerk<Dispatch.Controller,Road.Way,Driver.Pilot,RIDER,N> {

        protected final H host;

        public Network(Road.Way road, H host) {
            super(road);
            this.host = host;
        }



        public static class Client extends Network<Host.Remote,AsynchronousSocketChannel,Client> {

            public Host.Principal localSocket;
            public Client(Road.Way road,Host.Remote remoteHost, Host.Principal localSocket) {
                super(road,remoteHost);

            }

            @Override
            public AsynchronousSocketChannel makeConnection() throws IOException {
                return null;
            }

            @Override
            public int compareTo(Client that) {
                int isZero = this.road.compareTo(that.road);
                if (isZero == 0) {
                    isZero = this.host.compareTo(that.host);
                    if (isZero == 0) {
                        return
                    }
                }

            }
        }
        public static class Server extends Network<Host.Principal,AsynchronousServerSocketChannel,Server> {

            private SelectionKey selectionKey;

            public Server(Road.Way road, Host.Principal principalHost) {
                super(road,principalHost);
            }

            @Override
            public AsynchronousServerSocketChannel makeConnection() throws IOException {
                return null;
            }

            @Override
            public int compareTo(Server o) {
                return 0;
            }
        }
        public H getHost() {
            return host;
        }
    }
}
