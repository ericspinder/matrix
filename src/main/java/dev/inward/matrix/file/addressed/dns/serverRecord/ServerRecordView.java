/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serverRecord;

import dev.inward.matrix.file.addressed.dns.RRView;

public class ServerRecordView<LB extends ServerRecordLibrarian<LB,K,F,V,M,R,G>, K extends ServerRecordKey<LB,K,F,V,M,R,G>,F extends ServerRecord<LB,K,F,V,M,R,G>,V extends ServerRecordView<LB,K,F,V,M,R,G>,M extends ServerRecordModel<LB,K,F,V,M,R,G>,R extends ServerRecordReference<LB,K,F,V,M,R,G>,G extends ServerRecordSteward<LB,K,F,V,M,R,G>> extends RRView<LB,K,F,V,M,R,G> {
    public ServerRecordView(String name, F serverRecord, M serverRecordModel) {
        super(name,serverRecord,serverRecordModel);
    }
}
