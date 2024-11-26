package dev.inward.matrix.dns.resourceRecord;

import dev.inward.matrix.Domain;
import dev.inward.matrix.Terrene;

public class ServiceLocationRecord extends ResourceRecord<ServiceLocationRecord> {
    public ServiceLocationRecord(Terrene terrene, Domain domain, int ttl,String service, String proto, int priority, int weight, int port, String target) {
        super(terrene,domain, ResourceRecordType.serviceLocationRecord,ttl);
        this.service = service;
        this.proto = proto;
        this.priority = priority;
        this.weight = weight;
        this.port = port;
        this.target = target;
    }
    public static class Maxtrix extends ServiceLocationRecord {

        public Maxtrix(Domain domain)
    }

    protected final String service;//: the symbolic name of the desired service.
    protected final String proto;//: the transport protocol of the desired service; this is usually either TCP or UDP.
    protected final int priority;//: the priority of the target host, lower value means more preferred.
    protected final int weight;//: A relative weight for records with the same priority, higher value means higher chance of getting picked.
    protected final int port;//: the TCP or UDP port on which the service is to be found.
    protected final String target;//: the canonical hostname of the machine providing the service, ending in a dot.

    @Override
    public String rData() {

        return null;
    }

}
