/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.catalog.ldap;

import dev.inward.matrix.concept.catalog.Catalog;

public abstract class LdapCatalog<LC extends LdapCatalog<LC,LV,LM>,LV extends LdapCatalogView<LC,LV,LM>,LM extends LdapCatalogModel<LC,LV,LM>> extends Catalog<LC,LV,LM> {
    public LdapCatalog(String name, boolean readOnly, LM model) {
        super(name, readOnly, model);
    }
}
