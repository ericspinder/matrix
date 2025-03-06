/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serverRecord;

import dev.inward.matrix.file.addressed.dns.RRReference;

public class ServerRecordReference<K extends ServerRecordKey<K,F,R,A,RESOURCE,M>,F extends ServerRecord<K,F,R,A,RESOURCE,M>,R extends ServerRecordReference<K,F,R,A,RESOURCE,M>,A extends ServerRecordAttributes<K,F,R,A,RESOURCE,M>,RESOURCE extends ServerRecordResource<K,F,R,A,RESOURCE,M>,M extends ServerRecordModel<K,F,R,A,RESOURCE,M>> extends RRReference<K, F, R, A, RESOURCE, M> {
    public ServerRecordReference(F addressed, RESOURCE resource) {
        super(addressed, resource);
    }
}
