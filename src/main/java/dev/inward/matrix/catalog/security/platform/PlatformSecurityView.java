/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.catalog.security.platform;

import dev.inward.matrix.catalog.security.SecurityView;

public class PlatformSecurityView<SC extends PlatformSecurity<SC,SV,SM>,SV extends PlatformSecurityView<SC,SV,SM>,SM extends PlatformSecurityModel<SC,SV,SM>> extends SecurityView<SC, SV, SM> {
    public PlatformSecurityView(String name, SC memory) {
        super(name, memory);
    }
}
