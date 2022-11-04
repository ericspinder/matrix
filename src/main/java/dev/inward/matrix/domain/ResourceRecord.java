package dev.inward.matrix.domain;

public abstract class ResourceRecord<RR extends ResourceRecord<RR>> implements Comparable<RR> {

    protected final InternetClass internetClass;
    protected final Domain domain;
    protected final ResourceRecordType type;

    public ResourceRecord(Domain domain, ResourceRecordType type, InternetClass internetClass) {
        this.domain = domain;
        this.type = type;
        this.internetClass = internetClass;
    }

    public Domain getDomain() {
        return domain;

    }

    public ResourceRecordType getType() {
        return type;
    }
}
