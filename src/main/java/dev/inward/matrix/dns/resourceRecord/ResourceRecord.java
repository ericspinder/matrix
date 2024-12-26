package dev.inward.matrix.dns.resourceRecord;

import dev.inward.matrix.*;
import dev.inward.matrix.dns.Path_ofDNS;
import dev.inward.matrix.Addressed;

import java.io.IOException;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.FileTime;
import java.util.Properties;
import java.util.UUID;

public abstract class ResourceRecord<RR extends ResourceRecord<RR>> extends Addressed<Path_ofDNS,UUID,ResourceRecord.Identity<RR>,RR,ResourceRecord.Representative<RR>> {

    protected int ttl;

    public ResourceRecord(Identity<RR> identity, int ttl) {
        super(identity);
        this.ttl = ttl;
    }

    public static class Identity<RR extends ResourceRecord<RR>> extends dev.inward.matrix.Identity<Pathway,UUID,Identity<RR>,RR, Representative<RR>> {


        @SafeVarargs
        public Identity(UUID uuid, Index<Pathway, ?>... index) {
            super(uuid,index);
        }

        @Override
        public int compareTo(RR o) {
            return 0;
        }

        @Override
        public WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
            return null;
        }
    }


    public static class Representative<RR extends ResourceRecord<RR>> extends dev.inward.matrix.Representative<Pathway,UUID,Identity<RR>,RR, Representative<RR>> {

        public Representative(RR addressed, Resource<Pathway, UUID, Identity<RR>, RR, Representative<RR>> resource, Properties properties) {
            super(addressed, resource, properties);
        }

        @Override
        public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) throws IOException {

        }
    }
//    public ByteBuffer getRData() {
//        return StandardCharsets.UTF_8.encode(rData());
//    }


    @Override
    public int compareTo(RR that) {
        return this.identity.compareTo(that.identity);
    }

}
