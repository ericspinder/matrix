/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.resource.record.serviceLocationRecord;

import dev.inward.matrix.file.resource.record.ResourceRecord;

public class ServiceLocationRecord extends ResourceRecord<ServiceLocationRecord,ServiceLocationRecordKey,ServiceLocationRecordView,ServiceLocationRecordModel,ServiceLocationRecordReference,ServiceLocationRecordLibrarian> {
    public ServiceLocationRecord(ServiceLocationRecordKey identity, int ttl, String service, String proto, int priority, int weight, int port, String target) {
        super(identity,ttl);
        this.service = service;
        this.proto = proto;
        this.priority = priority;
        this.weight = weight;
        this.port = port;
        this.target = target;
    }

    protected final String service;//: the symbolic name of the desired service.
    protected final String proto;//: the transport protocol of the desired service; this is usually either TCP or UDP.
    protected final int priority;//: the priority of the target host, lower value means more preferred.
    protected final int weight;//: A relative weight for records with the same priority, higher value means higher chance of getting picked.
    protected final int port;//: the TCP or UDP port on which the service is to be found.
    protected final String target;//: the canonical hostname of the machine providing the service, ending in a dot.


}
