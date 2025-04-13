/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau.file;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.bureau.BureauModel;

public class FileBureauModel<K extends FileBureauKey<K,I,V,M,R,G>,I extends FileBureau<K,I,V,M,R,G>,V extends FileBureauView<K,I,V,M,R,G>,M extends FileBureauModel<K,I,V,M,R,G>,R extends FileBureauReference<K,I,V,M,R,G>,G extends FileBureauGestalt<K,I,V,M,R,G>> extends BureauModel<K,I,V,M,R,G> {
    public FileBureauModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
