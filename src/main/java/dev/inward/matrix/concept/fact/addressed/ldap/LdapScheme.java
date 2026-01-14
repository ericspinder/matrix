/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.ldap;

import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.scheme.ProtocolParser;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.control.terrene.Terrene;

import java.time.Instant;
import java.util.UUID;

public class LdapScheme extends Scheme<LdapScheme,LdapSchemeView,LdapSchemeModel,LdapLibrary,LdapLibraryView,LdapLibraryModel,LdapAuthority,LdapAuthorityView,LdapAuthorityModel,Ldap,LdapKey,LdapView,LdapModel, LdapLibrarian,LdapContext,LdapPath> {

    public LdapScheme(Terrene terrene) {
        super(terrene, ProtocolParser.Instances.LDAP);
    }

    @Override
    protected LdapSchemeModel createSchemeModel() {
        return null;
    }

    @Override
    protected LdapLibrary createNewLibrary(Domain domain, int port) {
        return null;
    }

    @Override
    public int compareTo(Terrene that) {
        return 0;
    }

    @Override
    public UUID getUuid() {
        return null;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public Instant getCreateInstant() {
        return null;
    }
}
