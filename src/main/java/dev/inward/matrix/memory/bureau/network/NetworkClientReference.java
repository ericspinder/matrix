/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.network;

import dev.inward.matrix.memory.bureau.BureauReference;

public class NetworkClientReference<BD extends NetworkClient<BD,BV,BM,BR,BB>,BV extends NetworkClientView<BD,BV,BM,BR,BB>,BM extends NetworkClientModel<BD,BV,BM,BR,BB>,BR extends NetworkClientReference<BD,BV,BM,BR,BB>,BB extends NetworkClientLibrarian<BD,BV,BM,BR,BB>>  extends BureauReference<BD,BV,BM,BR,BB> {

    public NetworkClientReference(BD referent, BB librarian) {
        super(referent, librarian);
    }
}
