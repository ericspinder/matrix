/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.ldap;

import dev.inward.matrix.engine.Factory;
import dev.inward.matrix.concept.fact.Variant;
import dev.inward.matrix.concept.fact.directory.DirectoryContext;
import dev.inward.matrix.item.materilized.administrator.agent.Agent;

public class LdapContext extends DirectoryContext<LdapScheme,LdapSchemeView,LdapSchemeModel,LdapLibrary,LdapLibraryView,LdapLibraryModel,LdapAuthority,LdapAuthorityView,LdapAuthorityModel,Ldap,LdapKey,LdapView,LdapModel, LdapLibrarian,LdapContext,LdapPath> {
    public LdapContext(Variant variant, LdapLibrarian directoryLibrarian, Factory<LdapScheme, LdapScheme, LdapScheme, LdapLibrary, LdapLibraryView, LdapLibraryModel, LdapAuthority, LdapAuthorityView, LdapAuthorityModel, Ldap, LdapKey, LdapView, LdapModel, LdapLibarian, LdapContext, LdapPath> factory, Agent[] agents) {
        super(variant, directoryLibrarian, factory, agents);
    }
}
