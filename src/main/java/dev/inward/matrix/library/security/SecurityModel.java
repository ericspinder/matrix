/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.library.security;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.library.LibraryModel;

public abstract class SecurityModel<SC extends Security<SC,SV,SM>,SV extends SecurityView<SC,SV,SM>,SM extends SecurityModel<SC,SV,SM>> extends LibraryModel<SC,SV,SM> {
    public SecurityModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
