/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.dns.serverRecord;

import dev.inward.matrix.Aspect;

public class Ip4ServerRecordModel extends ServerRecordModel<Ip4ServerRecord,Ip4ServerRecordKey,Ip4ServerRecordView,Ip4ServerRecordModel, Ip4ServerRecordReference, Ip4ServerRecordLibrarian> {
    public Ip4ServerRecordModel(Aspect[] labeledAspects) {
        super(Ip4ServerRecord.class, labeledAspects);
    }
}
