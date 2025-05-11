/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.user;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.file.FileModel;
import dev.inward.matrix.file.addressed.AddressedModel;

public class PrivilegeModel<F extends Privilege<F,K,V,M,R,L>,K extends PrivilegeKey<F,K,V,M,R,L>,V extends PrivilegeView<F,K,V,M,R,L>,M extends PrivilegeModel<F,K,V,M,R,L>,R extends PrivilegeReference<F,K,V,M,R,L>,L extends PrivilegeLibrarian<F,K,V,M,R,L>> extends FileModel<F,K,V,M,R,L> {
    public PrivilegeModel(Class<F> privilegeClass, Aspect[] labeledAspects) {
        super(privilegeClass, labeledAspects);
    }
}
