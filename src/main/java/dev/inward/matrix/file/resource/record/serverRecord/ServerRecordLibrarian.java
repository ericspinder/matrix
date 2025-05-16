/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.resource.record.serverRecord;

import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.addressed.depot.standard.Standard;
import dev.inward.matrix.file.resource.record.RRLibrarian;

public class ServerRecordLibrarian<F extends ServerRecord<F,K,V,M,R,L>,K extends ServerRecordKey<F,K,V,M,R,L>,V extends ServerRecordView<F,K,V,M,R,L>,M extends ServerRecordModel<F,K,V,M,R,L>,R extends ServerRecordReference<F,K,V,M,R,L>,L extends ServerRecordLibrarian<F,K,V,M,R,L>> extends RRLibrarian<F,K,V,M,R,L> {

    public ServerRecordLibrarian(Standard standard) {
        super(standard);
    }
}
