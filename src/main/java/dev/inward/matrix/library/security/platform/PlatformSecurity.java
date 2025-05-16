/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.library.security.platform;

import dev.inward.matrix.library.security.Security;

public abstract class PlatformSecurity<SC extends PlatformSecurity<SC,SV,SM>,SV extends PlatformSecurityView<SC,SV,SM>,SM extends PlatformSecurityModel<SC,SV,SM>> extends Security<SC,SV,SM> {
    public PlatformSecurity(String name, boolean readOnly, SM model) {
        super(name, readOnly, model);
    }
}
