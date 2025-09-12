/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serverRecord;

import dev.inward.matrix.file.addressed.dns.RRView;

public class ServerRecordView<F extends ServerRecord<F,K,V,M,R,L>,K extends ServerRecordKey<F,K,V,M,R,L>,V extends ServerRecordView<F,K,V,M,R,L>,M extends ServerRecordModel<F,K,V,M,R,L>,R extends ServerRecordReference<F,K,V,M,R,L>,L extends ServerRecordLibrarian<F,K,V,M,R,L>> extends RRView<F,K,V,M,R,L> {

    public ServerRecordView(String name, F file) {
        super(name, file);
    }
}
