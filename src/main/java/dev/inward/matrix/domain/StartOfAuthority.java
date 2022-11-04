package dev.inward.matrix.domain;

public class StartOfAuthority extends ResourceRecord<StartOfAuthority> {

    protected final int ttl;

    public StartOfAuthority(Domain domain, int ttl, InternetClass internetClass) {
        super(domain,ResourceRecordType.StartOfAuthority, internetClass);
        this.ttl = ttl;

    }

    public String getOrigin() {
        return this.domain.name;
    }

    @Override
    public int compareTo(StartOfAuthority that) {
        int isZero = this.domain.compareTo(that.domain);
        if (isZero == 0) {
            return this.internetClass.authorityCode - that.internetClass.authorityCode;
        }
        return isZero;
    }
}
