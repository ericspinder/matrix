/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.ldap;

import dev.inward.matrix.Protocol;
import dev.inward.matrix.control.scheme.ProtocolParser;
import dev.inward.matrix.control.terrene.Terrene;

public class LdapProtocolParser extends ProtocolParser<LdapPath> {

    public LdapProtocolParser() {
        super(Protocol.LDAP);
    }

    @Override
    public LdapPath parsePath(String rawPath) {
        return null;
    }

    @Override
    public LdapScheme newScheme(Terrene terrene) {
        return new LdapScheme(terrene);
    }
}
