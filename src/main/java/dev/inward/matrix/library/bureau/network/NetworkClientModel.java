/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.library.bureau.network;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.library.bureau.BureauModel;

public abstract class NetworkClientModel<BC extends NetworkClient<BC,BV,BM>,BV extends NetworkClientView<BC,BV,BM>,BM extends NetworkClientModel<BC,BV,BM>> extends BureauModel<BC,BV,BM> {
    public NetworkClientModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
