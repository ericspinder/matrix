/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.file;

import dev.inward.matrix.memory.bureau.BureauSteward;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class FileBureauSteward<K extends FileBureauKey<K,I,V,M,R,G>,I extends FileBureau<K,I,V,M,R,G>,V extends FileBureauView<K,I,V,M,R,G>,M extends FileBureauModel<K,I,V,M,R,G>,R extends FileBureauReference<K,I,V,M,R,G>,G extends FileBureauSteward<K,I,V,M,R,G>> extends BureauSteward<K,I,V,M,R,G> {
    public FileBureauSteward(Standard standard) {
        super(standard);
    }
}
