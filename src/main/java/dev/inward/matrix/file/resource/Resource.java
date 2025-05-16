/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.resource;

import dev.inward.matrix.file.File;
import dev.inward.matrix.file.FileKey;

public class Resource<F extends Resource<F,K,V,M,R,L>,K extends ResourceKey<F,K,V,M,R,L>,V extends ResourceView<F,K,V,M,R,L>,M extends ResourceModel<F,K,V,M,R,L>,R extends ResourceReference<F,K,V,M,R,L>,L extends ResourceLibrarian<F,K,V,M,R,L>> extends File<F,K,V,M,R,L> {
    protected Resource(K key) {
        super(key);
    }
}
