/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.memory.security.platform.unix;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.control.memory.security.platform.PlatformSecurityModel;

public abstract class UnixSecurityModel<SC extends UnixSecurity<SC,SV,SM>,SV extends UnixSecurityView<SC,SV,SM>,SM extends UnixSecurityModel<SC,SV,SM>> extends PlatformSecurityModel<SC,SV,SM> {
    public UnixSecurityModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
