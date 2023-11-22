package dev.inward.matrix.authority.dns.resourceRecord;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.dns.Terrene;

public class StartOfAuthority extends ResourceRecord<StartOfAuthority> {

    protected final String responsibleEmailAddress;
    protected final int serial;
    protected final int refresh;
    protected final int retry;
    protected final int expire;

    public StartOfAuthority(Terrene terrene, Domain domain, int ttl, String responsibleEmailAddress, int serial, int refresh, int retry, int expire) {
        super(domain, ResourceRecordType.StartOfAuthority, terrene);
        this.ttl = ttl;
        this.responsibleEmailAddress = responsibleEmailAddress;
        this.serial = serial;
        this.refresh = refresh;
        this.retry = retry;
        this.expire = expire;
    }

    @Override
    protected String rData() {
        return null;
    }

    @Override
    public String toString() {
        return
                "ttl=" + ttl +
                ", responsibleEmailAddress='" + responsibleEmailAddress + '\'' +
                ", serial=" + serial +
                ", refresh=" + refresh +
                ", retry=" + retry +
                ", expire=" + expire;
    }
}
