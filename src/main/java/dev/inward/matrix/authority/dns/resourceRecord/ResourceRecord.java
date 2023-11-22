package dev.inward.matrix.authority.dns.resourceRecord;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.Office;
import dev.inward.matrix.authority.dns.Question;
import dev.inward.matrix.authority.dns.Terrene;
import dev.inward.matrix.fact.Concept;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.locks.StampedLock;

public abstract class ResourceRecord<ID extends Comparable<ID>,RR extends ResourceRecord<ID,RR>> extends Concept<DNS, Office<ID,RR>,Question,ID,Answer,ResourceRecord<ID,RR>> implements Comparable<RR> {

    protected StampedLock gate = new StampedLock();
    protected int ttl;

    public ResourceRecord(Domain domain, ResourceRecordType type, Terrene terrene) {
        super(domain,type,terrene);
    }

    public ByteBuffer getRData() {
        return StandardCharsets.UTF_8.encode(rData());
    }

    protected abstract String rData();

    public int getTtl() {
        long readLock = gate.readLock();
        try {
            return ttl;
        }
        finally {
            gate.unlockRead(readLock);
        }
    }

    public void setTtl(int ttl) {
        long writeLock = gate.writeLock();
        try {
            this.ttl = ttl;
        }
        finally {
            gate.unlockWrite(writeLock);
        }
    }

    @Override
    public String toString() {
        return "ResourceRecord{" +
                "domain=" + domain +
                ", type=" + type +
                ", terrene=" + terrene +
                ", ttl=" + ttl +
                "," + rData() +
                '}';
    }

    @Override
    public int compareTo(RR that) {
        int isZero = this.terrene.compareTo(that.terrene);
        if (isZero == 0) {
            return this.domain.compareTo(that.domain);
        }
        return isZero;
    }
}
