/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serverRecord;

import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.function.Function;

public class Ip6ServerRecordResource extends ServerRecordResource<Ip6ServerRecordKey,Ip6ServerRecord,Ip6ServerRecordReference,Ip6ServerRecordAttributes,Ip6ServerRecordResource,Ip6ServerRecordModel> {
    public Ip6ServerRecordResource(Function<Ip6ServerRecordReference, Ip6ServerRecordReference> graveDigger, Ip6ServerRecordModel model, Specification specification) {
        super(graveDigger, model, specification);
    }
}
