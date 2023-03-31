package dev.inward.matrix.authority;

public class StartOfAuthority extends ResourceRecord<StartOfAuthority> {

    protected final int ttl;
    protected final String responsibleEmailAddress;
    protected final int serial;
    protected final int refresh;
    protected final int retry;
    protected final int expire;




    public StartOfAuthority(InternetClass internetClass, Domain domain, int ttl, String responsibleEmailAddress, int serial, int refresh, int retry, int expire) {
        super(domain,ResourceRecordType.StartOfAuthority, internetClass);
        this.ttl = ttl;
        this.responsibleEmailAddress = responsibleEmailAddress;
        this.serial = serial;
        this.refresh = refresh;
        this.retry = retry;
        this.expire = expire;
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
