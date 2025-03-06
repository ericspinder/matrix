/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serverRecord;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.file.addressed.dns.RRModel;

public class ServerRecordModel<K extends ServerRecordKey<K,F,R,A,RESOURCE,M>,F extends ServerRecord<K,F,R,A,RESOURCE,M>,R extends ServerRecordReference<K,F,R,A,RESOURCE,M>,A extends ServerRecordAttributes<K,F,R,A,RESOURCE,M>,RESOURCE extends ServerRecordResource<K,F,R,A,RESOURCE,M>,M extends ServerRecordModel<K,F,R,A,RESOURCE,M>> extends RRModel<K, F, R, A, RESOURCE, M> {
    public ServerRecordModel(Aspect[] labeledAspects, long warnOnTotal, long hardLimit) {
        super(labeledAspects, warnOnTotal, hardLimit);
    }
}
