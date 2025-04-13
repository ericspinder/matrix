/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.file.unix;

import dev.inward.matrix.memory.bureau.file.FileBureauSteward;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public abstract class UnixBureauSteward<K extends UnixBureauKey<K,I,V,M,R,G>,I extends UnixBureau<K,I,V,M,R,G>,V extends UnixBureauView<K,I,V,M,R,G>,M extends UnixBureauModel<K,I,V,M,R,G>,R extends UnixBureauReference<K,I,V,M,R,G>,G extends UnixBureauSteward<K,I,V,M,R,G>> extends FileBureauSteward<K,I,V,M,R,G> {
    public UnixBureauSteward(Standard standard) {
        super(standard);
    }
}
