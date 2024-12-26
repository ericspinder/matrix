package dev.inward.matrix;

import dev.inward.matrix.log.Indicia;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.StampedLock;

public abstract class Host<S extends SocketAddress> implements Comparable<Host<S>> {

    protected final Library<?,?,?> library;
    private final StampedLock gate = new StampedLock();
    protected final Map<S,Experience> socketAddresses;

    protected final Properties properties;

    public Host(Library<?,?,?> library, String target, S[] socketAddresses, Properties properties) {
        this.library = library;
        this.socketAddresses = socketAddresses;
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

    public S[] getSocketAddresses() {
        return socketAddresses;
    }

    public static class Remote extends Host<SocketAddress.Remote> {

        public Remote(Library<?,?,?> library, String target, final SocketAddress.Remote[] remoteSockets, Properties properties) {
            super(library, target, remoteSockets, properties);
        }
    }
    public static class LocalHost extends Host<SocketAddress.Local> {

        public LocalHost(Library<?,?,?> library, String target, final SocketAddress.Local[] localSockets, Properties properties) {
            super(library, target, localSockets, properties);
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
                throw new MatrixException(MatrixException.Type.Host_Target_Match_Array_Mismatch,"Host CompareTo", Indicia.Focus.Assembly, Indicia.Severity.Critical,new Exception("stack trace..."));
            }
        }
        return isZero;
    }
}
