/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.ldap;

import dev.inward.matrix.control.authority.Authority;
import dev.inward.matrix.control.terrene.Terrene;

public class LdapAuthority extends Authority<LdapScheme,LdapSchemeView,LdapSchemeModel,LdapLibrary,LdapLibraryView,LdapLibraryModel,LdapAuthority,LdapAuthorityView,LdapAuthorityModel,Ldap,LdapKey,LdapView,LdapModel, LdapLibrarian,LdapContext,LdapPath> {
    public LdapAuthority(String userInfo, LdapLibrary library) {
        super(userInfo, library);
    }

    @Override
    public int compareTo(Terrene that) {
        return 0;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public LdapAuthorityModel getModel() {
        return null;
    }
}
