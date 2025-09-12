/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.catalog.security;

import dev.inward.matrix.catalog.CatalogView;

public class SecurityView<SC extends Security<SC,SV,SM>,SV extends SecurityView<SC,SV,SM>,SM extends SecurityModel<SC,SV,SM>> extends CatalogView<SC,SV,SM> {
    public SecurityView(String name, SC memory) {
        super(name, memory);
    }
}
