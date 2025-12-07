/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.dns.serverRecord;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.concept.fact.addressed.dns.RRModel;

public class ServerRecordModel<F extends ServerRecord<F,K,V,M,R,L>,K extends ServerRecordKey<F,K,V,M,R,L>,V extends ServerRecordView<F,K,V,M,R,L>,M extends ServerRecordModel<F,K,V,M,R,L>,R extends ServerRecordReference<F,K,V,M,R,L>,L extends ServerRecordLibrarian<F,K,V,M,R,L>> extends RRModel<F,K,V,M,R,L> {
    public ServerRecordModel(Class<F> serverRecordClass, Aspect[] labeledAspects) {
        super(serverRecordClass, labeledAspects);
    }
}
