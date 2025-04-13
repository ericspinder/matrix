/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serverRecord;

import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.util.function.Function;

public class Ip4ServerRecordGestalt extends ServerRecordGestalt<Ip4ServerRecordKey,Ip4ServerRecord,Ip4ServerRecordReference, Ip4ServerRecordView, Ip4ServerRecordGestalt,Ip4ServerRecordModel> {
    public Ip4ServerRecordGestalt(Function<Ip4ServerRecordReference, Ip4ServerRecordReference> graveDigger, Ip4ServerRecordModel model, Class<Ip4ServerRecordView> viewClass, Specification specification) {
        super(graveDigger, model, viewClass, specification);
    }
}
