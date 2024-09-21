package dev.inward.matrix;

import dev.inward.matrix.route.Dispatch;
import dev.inward.matrix.route.Driver;
import dev.inward.matrix.route.Road;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.*;
import java.util.WeakHashMap;
import java.util.concurrent.locks.StampedLock;

public abstract class Clerk<DISPATCH extends Dispatch<DISPATCH,R,D, REMOTE>,R extends Road<DISPATCH,R,D, REMOTE>,D extends Driver<DISPATCH,R,D, REMOTE>, REMOTE extends Closeable,C extends Clerk<DISPATCH,R,D, REMOTE,C>> implements Comparable<C> {


    protected final StampedLock gate = new StampedLock();
    protected transient WeakHashMap<REMOTE,  D> engagedRiders;

    protected abstract R getRoad();

    public Clerk() {
    }

    public abstract REMOTE makeConnection() throws IOException;

    public abstract static class File extends Clerk<Dispatch.Editor,Road.Concrete,Driver.Scribe,AsynchronousFileChannel,File> {

        public File(Road.Concrete road) {

        }
    }

    public static class JDBC extends Clerk<Dispatch.SQL> {

    }

    public abstract static class Network<H extends Host, RIDER extends AsynchronousChannel,N extends Network<H, RIDER,N>> extends Clerk<Dispatch.Controller<RIDER>,Road.Way<RIDER>,Driver.Pilot<RIDER>,RIDER,N> {

        protected final H host;

        @SuppressWarnings("ReassignedVariable")
        public Network(H host) {
            this.host = host;
        }



        public static class Client extends Network<Host.Remote,AsynchronousSocketChannel,Client> {

            public Host.Principal localSocket;
            public Client(Road.Way<AsynchronousSocketChannel> road,Host.Remote remoteHost, Host.Principal localSocket) {
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
                        return this.localSocket.compareTo(that.localSocket);
                    }
                }
                return isZero;

            }

            public static class NameServer extends Client {

                public NameServer(Road.Way road, Host.Remote remoteHost, Host.Principal localSocket) {
                    super(road, remoteHost, localSocket);
                }
            }
        }
        public static class Server extends Network<Host.Principal,AsynchronousServerSocketChannel,Server> {

            private SelectionKey selectionKey;

            public Server(Road.Way<AsynchronousServerSocketChannel> road, Host.Principal principalHost) {
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
