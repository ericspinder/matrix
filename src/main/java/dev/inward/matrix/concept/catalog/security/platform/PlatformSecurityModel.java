/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.catalog.security.platform;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.concept.catalog.security.SecurityModel;

public abstract class PlatformSecurityModel<SC extends PlatformSecurity<SC,SV,SM>,SV extends PlatformSecurityView<SC,SV,SM>,SM extends PlatformSecurityModel<SC,SV,SM>> extends SecurityModel<SC,SV,SM> {
    public PlatformSecurityModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
