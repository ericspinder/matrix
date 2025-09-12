/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.catalog.security.platform.unix;

import dev.inward.matrix.catalog.security.platform.PlatformSecurity;

public abstract class UnixSecurity<SC extends UnixSecurity<SC,SV,SM>,SV extends UnixSecurityView<SC,SV,SM>,SM extends UnixSecurityModel<SC,SV,SM>> extends PlatformSecurity<SC,SV,SM> {
    public UnixSecurity(String name, boolean readOnly, SM model) {
        super(name, readOnly, model);
    }
}
