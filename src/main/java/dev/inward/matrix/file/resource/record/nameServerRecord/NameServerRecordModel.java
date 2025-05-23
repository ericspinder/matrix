/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.resource.record.nameServerRecord;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.file.resource.record.RRModel;

public class NameServerRecordModel extends RRModel<NameServerRecord,NameServerRecordKey,NameServerRecordView,NameServerRecordModel,NameServerRecordReference,NameServerRecordLibrarian> {
    public NameServerRecordModel(Aspect[] labeledAspects) {
        super(NameServerRecord.class, labeledAspects);
    }
}
