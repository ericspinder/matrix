package dev.inward.matrix.authority;

import dev.inward.matrix.MatrixException;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.authoritative.notion.authority.Clerk;
import dev.inward.matrix.fact.matter.Indicia;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URL;
import java.nio.channels.*;
import java.nio.file.FileSystem;
import java.security.CodeSigner;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Authority<Z extends Zone<Z>,CHANNEL extends AsynchronousChannel,A extends Authority<Z,CHANNEL,A>> extends Domain<Z,CHANNEL,A,A> {

    protected final InternetClass internetClass;

    public Authority(Z zone, A parent, String name, InternetClass internetClass) {
        super(zone, parent, name);
        this.internetClass = internetClass;
    }

    public final URL getURL(Domain domain) {
        if (domain == null) {
            return this.zone.createUrl(this);
        }
        if (domain.parent.equals(this)) {
            return this.zone.createUrl(domain);
        }
        return null;
    }

    protected CodeSigner[] getCodeSigners(Domain domain) {
        if (domain == null) {
            return
        }
        if(this.domainLogMap.containsKey(domain)) {

        }
        throw new MatrixException(MatrixException.Type.CodeSigners_not_initialized,this.getClass(), Indicia.Focus.Assembly, Indicia.Severity.Critical,new Exception("StackTrace, should be calling getCodeSigner() only after calling getUrl()"));
    }
    @Override
    public L getFileSystem() {
        return this.library;
    }
    public static class Remote extends Authority<AsynchronousSocketChannel,Remote> {

        protected final AsynchronousChannelGroup group;
        protected final Map<ServerRecord, Clerk.Network.Client> nameServerClientMap = new ConcurrentHashMap<>();

        public Remote(InternetClass internetClass, Authority<?,?> parent, String name, AsynchronousChannelGroup group,  ServerRecord[] nameServerRecords) {
            super(internetClass,parent,name);
            this.group = group;
            for (ServerRecord serverRecord : nameServerRecords) {
                try {
                    this.nameServerClientMap.put(serverRecord, new Clerk.Network.Client(this, AsynchronousSocketChannel.open(group), new InetSocketAddress(serverRecord.getInetAddress(),)));
                } catch (IOException ioe) {
                    System.out.println("Cannot create Channel to " +serverRecord.toString());
                }
            }
        }
    }
    public static class Host extends Authority<AsynchronousServerSocketChannel,Host> {

        public Host(InternetClass internetClass, Authority parent, String name) {
            super(internetClass, parent, name);
        }
    }
    public static class Local<FILESYSTEM extends FileSystem> extends Authority<FILESYSTEM,AsynchronousFileChannel,Local<FILESYSTEM>> {

        public Local(FILESYSTEM filesystem) {
            super(null,"localhost",filesystem, InternetClass.Aforementioned);
        }
    }

    public record ResourceRecordCache(ResourceRecord resourceRecord, Instant lastUpdate) {

    }
    protected Map<Domain, ResourceRecordCache[]> domainRecords = new ConcurrentHashMap<>();

    public List<ResourceRecord> getByTypeForDomain(Domain domain, ResourceRecordType resourceRecordType) {
        if (!domainRecords.containsKey(domain)) {

        }
        return null;
    }
}
