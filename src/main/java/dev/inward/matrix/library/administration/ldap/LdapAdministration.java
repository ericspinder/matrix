/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.library.administration.ldap;

import dev.inward.matrix.library.administration.Administration;

public abstract class LdapAdministration<AC extends LdapAdministration<AC,AV,AM>,AV extends LdapAdministrationView<AC,AV,AM>,AM extends LdapAdministrationModel<AC,AV,AM>> extends Administration<AC,AV,AM> {
    public LdapAdministration(String name, boolean readOnly, AM model) {
        super(name, readOnly, model);
    }
}
