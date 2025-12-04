/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.file.addressed.dns.nameServerRecord;

import dev.inward.matrix.concept.file.addressed.dns.RRReference;

public class NameServerRecordReference extends RRReference<NameServerRecord,NameServerRecordKey,NameServerRecordView,NameServerRecordModel, NameServerRecordReference, NameServerRecordLibrarian> {
    public NameServerRecordReference(NameServerRecord addressed, NameServerRecordLibrarian resource) {
        super(addressed, resource);
    }
}
