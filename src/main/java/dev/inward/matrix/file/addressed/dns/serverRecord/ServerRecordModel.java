/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serverRecord;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.file.addressed.dns.RRModel;

public class ServerRecordModel<K extends ServerRecordKey<K,F,V,M,R,B>,F extends ServerRecord<K,F,V,M,R,B>,V extends ServerRecordView<K,F,V,M,R,B>,M extends ServerRecordModel<K,F,V,M,R,B>,R extends ServerRecordReference<K,F,V,M,R,B>,B extends ServerRecordLibrarian<K,F,V,M,R,B>> extends RRModel<K,F,V,M,R,B> {
    public ServerRecordModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
