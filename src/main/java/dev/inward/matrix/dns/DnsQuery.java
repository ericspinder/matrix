package dev.inward.matrix.dns;

public class DnsQuery extends DnsFlags {


    public DnsQuery(boolean reply, boolean authoritative, boolean truncated, boolean recursion, boolean recursionAvailable, ZeroCode zeroCode, MessageResponseCode messageResponseCode) {
        super(OPCode.QUERY, reply, authoritative, truncated, recursion, recursionAvailable, zeroCode, messageResponseCode);
    }

}
