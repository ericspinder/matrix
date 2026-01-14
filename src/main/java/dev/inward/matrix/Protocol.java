/*
 *  Pinder's Matrix © 2026. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.concept.fact.addressed.http.HttpProtocolParser;
import dev.inward.matrix.concept.fact.addressed.https.Https;
import dev.inward.matrix.concept.fact.addressed.ldap.LdapProtocolParser;
import dev.inward.matrix.control.scheme.ProtocolParser;

import java.util.Objects;

public enum Protocol implements Meta_I {
    DEPOT("depot", "Code Repository", 8, ProtocolParser.Depot.class),
    DNS("dns", "Domain Name System", 53, ProtocolParser.Dns.class),
    HTTP("http", "Unsecure File Service", 80, HttpProtocolParser.class),
    HTTPS("https", "Secure File Service", 443, Https.class),
    LOG("log", "Completed Matters", 10, ProtocolParser.Log.class),
    LDAP("ldap", "Lightweight Directory Access Protocol", 389, LdapProtocolParser.class)
    //REALM("realm", "Secure login Service", 6, RealmScheme.class)
    ;
    private final String label;
    private final String description;
    private final int defaultPort;
    private final Class<? extends ProtocolParser<?>> parserClass;
    private final String separator;

    Protocol(final String label, final String description, int defaultPort, Class<? extends ProtocolParser<?>> schemeClass) {
        this(label, description, defaultPort, schemeClass, null);
    }

    Protocol(final String label, final String description, int defaultPort, Class<? extends ProtocolParser<?>> parserClass, String separator) {
        this.label = label;
        this.description = description;
        this.defaultPort = defaultPort;
        this.parserClass = parserClass;
        this.separator = Objects.requireNonNullElse(separator, "/");
    }

    Protocol valueOfIgnoreCase(String protocolString) {
        return Protocol.valueOf(protocolString.toUpperCase());
    }

    @Override
    public final String getLabel() {
        return this.label;
    }

    @Override
    public final String getDescription() {
        return this.description;
    }

    public int getDefaultPort() {
        return defaultPort;
    }

    public Class<? extends ProtocolParser<?>> getParserClass() {
        return parserClass;
    }

    public String getSeparator() {
        return separator;
    }
}
