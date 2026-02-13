/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.catalog.ldap;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.control.catalog.CatalogModel;

public abstract class LdapCatalogModel<LC extends LdapCatalog<LC,LV,LM>,LV extends LdapCatalogView<LC,LV,LM>,LM extends LdapCatalogModel<LC,LV,LM>> extends CatalogModel<LC,LV,LM> {
    public LdapCatalogModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
