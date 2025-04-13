/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.nameServerRecord;

import dev.inward.matrix.file.addressed.dns.RRReference;

public class NameServerRecordReference extends RRReference<NameServerRecordLibrarian,NameServerRecordKey,NameServerRecord,NameServerRecordView,NameServerRecordModel,NameServerRecordReference, NameServerRecordSteward> {
    public NameServerRecordReference(NameServerRecord addressed, NameServerRecordSteward resource) {
        super(addressed, resource);
    }
}
