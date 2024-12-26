package dev.inward.matrix.dns.resourceRecord;

import dev.inward.matrix.Domain;
import dev.inward.matrix.Range;
import dev.inward.matrix.Terrene;

public class IndexRecord<PATH extends Comparable<PATH>> extends ResourceRecord<IndexRecord<PATH>> {

    protected final String indexName;
    protected final String protocol;
    protected final int priority;
    protected final int weight;
    protected final int port;

    protected final Range<PATH> range;
    protected final String target;
    public IndexRecord(Terrene terrene, Domain domain,int ttl,String indexName, String protocol, int priority, int weight, int port, Range<PATH> range, String target) {
        super(terrene, domain,ResourceRecordType.indexRecord,ttl);
        this.indexName = indexName;
        this.protocol = protocol;
        this.priority = priority;
        this.weight = weight;
        this.port = port;
        this.range = range;
        this.target = target;
    }

    public String getIndexName() {
        return indexName;
    }

    public int getPriority() {
        return priority;
    }

    public int getWeight() {
        return weight;
    }

    public int getPort() {
        return port;
    }

    public Range<PATH> getRange() {
        return range;
    }

    public String getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "terrene = " + this.terrene + ", domain = " + this.domain+ ", ttl = " + this.ttl+ ", indexName = " + this.indexName+ ", priority = " + this.priority + ", weight = " + this.weight + ", range = " + this.range + ", target = " + this.target;
    }
}
