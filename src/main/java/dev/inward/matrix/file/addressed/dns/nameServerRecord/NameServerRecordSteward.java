/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.nameServerRecord;

import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.addressed.dns.RRSteward;

import java.util.function.Function;

public class NameServerRecordSteward extends RRSteward<NameServerRecordLibrarian,NameServerRecordKey,NameServerRecord,NameServerRecordView,NameServerRecordModel,NameServerRecordReference, NameServerRecordSteward> {
    public NameServerRecordSteward(Function<NameServerRecordReference, NameServerRecordReference> graveDigger, NameServerRecordModel model, Class<NameServerRecordView> viewClass, Specification specification) {
        super(graveDigger, model, viewClass, specification);
    }
}
