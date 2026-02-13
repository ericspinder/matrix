/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.catalog.security;

import dev.inward.matrix.control.catalog.Catalog;

public abstract class Security<SC extends Security<SC,SV,SM>,SV extends SecurityView<SC,SV,SM>,SM extends SecurityModel<SC,SV,SM>> extends Catalog<SC,SV,SM> {
    public Security(String name, boolean readOnly) {
        super(name, readOnly);
    }
}
