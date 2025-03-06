/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.nameServerRecord;

import dev.inward.matrix.file.addressed.dns.ResourceRecord;

public class NameServerRecord extends ResourceRecord<NameServerRecordKey,NameServerRecord,NameServerRecordReference,NameServerRecordAttributes,NameServerRecordResource,NameServerRecordModel> {

    protected final String target;
    public NameServerRecord(NameServerRecordKey key, String target, int ttl) {
        super(key, ttl);
        this.target = target;
    }

    public String getTarget() {
        return target;
    }
}
