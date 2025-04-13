/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau.file.unix;

import dev.inward.matrix.bureau.file.FileBureauKey;

import java.net.URI;

public abstract class UnixBureauKey<K extends UnixBureauKey<K,I,V,M,R,G>,I extends UnixBureau<K,I,V,M,R,G>,V extends UnixBureauView<K,I,V,M,R,G>,M extends UnixBureauModel<K,I,V,M,R,G>,R extends UnixBureauReference<K,I,V,M,R,G>,G extends UnixBureauGestalt<K,I,V,M,R,G>> extends FileBureauKey<K,I,V,M,R,G> {
    protected UnixBureauKey(URI uri) {
        super(uri);
    }
}
