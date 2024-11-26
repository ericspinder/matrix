package dev.inward.matrix.dns.resourceRecord;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.Addressed;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.Properties;
import java.util.UUID;

public abstract class ResourceRecord<RR extends ResourceRecord<RR>> extends Addressed<ResourceRecord.Pathway, UUID, ResourceRecord.Identity<RR>,RR, ResourceRecord.Representitive<RR>> {

    protected int ttl;

    public ResourceRecord(Identity<RR> identity, int ttl) {
        super(identity);
        this.ttl = ttl;
    }

    public static class Identity<RR extends ResourceRecord<RR>> extends dev.inward.matrix.Identity<Pathway,UUID,Identity<RR>,RR, Representitive<RR>> {


        @SafeVarargs
        public Identity(UUID uuid, Index<Pathway, ?>... index) {
            super(uuid,index);
        }
    }

    public static class Pathway implements Comparable<Pathway> {

        protected final Terrene terrene;
        protected final Domain domain;
        protected final ResourceRecordType type;

        public Pathway(Terrene terrene, Domain domain, ResourceRecordType type) {
            this.terrene = terrene;
            this.domain = domain;
            this.type = type;
        }

        @Override
        public int compareTo(Pathway that) {
            int isZero = this.terrene.compareTo(that.terrene);
            if (isZero == 0) {
                isZero = this.domain.compareTo(that.domain);
                if (isZero == 0) {
                    return this.type.compareTo(that.type);
                }
            }
            return isZero;
        }
    }
    public static class Representitive<RR extends ResourceRecord<RR>> extends dev.inward.matrix.Representitive<Pathway,UUID,Identity<RR>,RR, Representitive<RR>> {

        public Representitive(RR addressed, Resource<Pathway, UUID, Identity<RR>, RR, Representitive<RR>> resource, Addressed<Pathway,?,?,?,?> parent, boolean hold, Properties properties) {
            super(addressed, resource, parent, hold, properties);
        }

        @Override
        public Instant lastSync() {
            return null;
        }

        @Override
        public BasicFileAttributes readAttributes() throws IOException {
            return null;
        }

        @Override
        public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) throws IOException {

        }
    }

    public ByteBuffer getRData() {
        return StandardCharsets.UTF_8.encode(rData());
    }


    @Override
    public int compareTo(RR that) {
        return this.identity.compareTo(that.identity);
    }

}
