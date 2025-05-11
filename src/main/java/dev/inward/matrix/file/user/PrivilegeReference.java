/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.user;

import dev.inward.matrix.file.FileReference;
import dev.inward.matrix.file.addressed.AddressedReference;

public class PrivilegeReference<F extends Privilege<F,K,V,M,R,L>,K extends PrivilegeKey<F,K,V,M,R,L>,V extends PrivilegeView<F,K,V,M,R,L>,M extends PrivilegeModel<F,K,V,M,R,L>,R extends PrivilegeReference<F,K,V,M,R,L>,L extends PrivilegeLibrarian<F,K,V,M,R,L>> extends FileReference<F,K,V,M,R,L> {

    public PrivilegeReference(F referent, L librarian) {
        super(referent, librarian);
    }
}
