/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.catalog.administration.ldap;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.catalog.administration.AdministrationModel;

public abstract class LdapAdministrationModel<AC extends LdapAdministration<AC,AV,AM>,AV extends LdapAdministrationView<AC,AV,AM>,AM extends LdapAdministrationModel<AC,AV,AM>> extends AdministrationModel<AC,AV,AM> {
    public LdapAdministrationModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
