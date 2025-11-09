/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.catalog.network;

import dev.inward.matrix.control.bureau.BureauView;

public class NetworkClientView<BC extends NetworkClient<BC,BV,BM>,BV extends NetworkClientView<BC,BV,BM>,BM extends NetworkClientModel<BC,BV,BM>> extends BureauView<BC,BV,BM> {

    public NetworkClientView(String name, BC bureau) {
        super(name, bureau);
    }
}
