/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.resource.record.nameServerRecord;

import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.addressed.depot.standard.Standard;
import dev.inward.matrix.file.resource.record.RRLibrarian;

public class NameServerRecordLibrarian extends RRLibrarian<NameServerRecord,NameServerRecordKey,NameServerRecordView,NameServerRecordModel,NameServerRecordReference,NameServerRecordLibrarian> {

    public NameServerRecordLibrarian(Standard standard) {
        super(standard);
    }
}
