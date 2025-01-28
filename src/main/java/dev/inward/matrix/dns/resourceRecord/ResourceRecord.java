package dev.inward.matrix.dns.resourceRecord;

import dev.inward.matrix.*;
import dev.inward.matrix.dns.Path_ofDNS;
import dev.inward.matrix.Addressed;
import dev.inward.matrix.predictable.Predictable;

import java.io.IOException;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.FileTime;
import java.util.Properties;
import java.util.UUID;

public abstract class ResourceRecord<RR extends ResourceRecord<RR>> extends Addressed<Path_ofDNS,UUID,ResourceRecord.Identity<RR>,RR,ResourceRecord.Representative<RR>,ResourceRecord.DNSAttributes<RR>> {

    protected int ttl;

    public ResourceRecord(Identity<RR> identity, int ttl) {
        super(identity);
        this.ttl = ttl;
    }

    public static class Identity<RR extends ResourceRecord<RR>> extends dev.inward.matrix.Identity<Path_ofDNS,UUID,Identity<RR>,RR, Representative<RR>,DNSAttributes<RR>> {

        @SafeVarargs
        public Identity(UUID uuid, Index<Path_ofDNS>... indexes) {
            super(uuid,null,indexes);
        }



        @Override
        public Predictable<Path_ofDNS, Identity<RR>, RR, DNSAttributes<RR>> newWatchService() {
            return null;
        }
    }


    public static class Representative<RR extends ResourceRecord<RR>> extends dev.inward.matrix.Representative<Path_ofDNS,UUID,Identity<RR>,RR, Representative<RR>,DNSAttributes<RR>> {

        public Representative(RR addressed, Resource<Path_ofDNS, UUID, Identity<RR>, RR, Representative<RR>,DNSAttributes<RR>> resource, DNSAttributes<RR> properties) {
            super(addressed, resource);
        }
    }
    public static class DNSAttributes<RR extends ResourceRecord<RR>> extends FileAttributes<Path_ofDNS,UUID,Identity<RR>,RR,Representative<RR>,DNSAttributes<RR>> {

        public DNSAttributes(Properties properties, long size) {
            super(properties, size);
        }
    }

    @Override
    public int compareTo(RR that) {
        return this.getFileKey().compareTo(that.getFileKey());
    }
    //    public ByteBuffer getRData() {
//        return StandardCharsets.UTF_8.encode(rData());
//    }


}
