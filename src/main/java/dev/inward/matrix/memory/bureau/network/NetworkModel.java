/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.network;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.memory.bureau.BureauModel;

public class NetworkModel<K extends NetworkKey<K,I,V,M,R,G>,I extends Network<K,I,V,M,R,G>,V extends NetworkView<K,I,V,M,R,G>,M extends NetworkModel<K,I,V,M,R,G>,R extends NetworkReference<K,I,V,M,R,G>,G extends NeworkSteward<K,I,V,M,R,G>> extends BureauModel<K,I,V,M,R,G> {
    public NetworkModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
