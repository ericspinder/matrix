/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.file.addressed.depot.DepotScheme;
import dev.inward.matrix.file.addressed.dns.DnsScheme;
import dev.inward.matrix.file.addressed.http.HttpScheme;
import dev.inward.matrix.file.addressed.https.HttpsScheme;
import dev.inward.matrix.file.user.InfoScheme;
import dev.inward.matrix.file.addressed.log.LogScheme;

import java.lang.reflect.InvocationTargetException;
import java.net.URLStreamHandler;
import java.net.spi.URLStreamHandlerProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MatrixURLStreamHandlerProvider extends URLStreamHandlerProvider {


    protected static final Map<String, Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>> ALL_KNOWN_SCHEMES = new HashMap<>();


    public static Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> findSchemeForProtocolHost(Protocol protocol, Terrene terrene) {
        if (uri.getScheme().indexOf('.') == -1) {
            return findSchemeByString(Terrene.Earth.toString() + '.' + protocol.label);
        }
        else {
            return findSchemeByString( uri.getScheme().substring(0,uri.getScheme().lastIndexOf('.'))+ '.' + protocol.label);
        }
    }
    public static Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> findSchemeByString(String scheme_s) {
        String lowerCaseScheme = scheme_s.toLowerCase();
        Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> scheme = ALL_KNOWN_SCHEMES.get(lowerCaseScheme);
        if (scheme == null && lowerCaseScheme.indexOf('.') == -1) {
            findSchemeByString(Terrene.Earth.toString() + '.' + lowerCaseScheme);
        }
        else {
            synchronized (ALL_KNOWN_SCHEMES) {
                scheme = ALL_KNOWN_SCHEMES.get(lowerCaseScheme);
                if (scheme == null) {
                    Terrene terrene = Terrene.Parse(lowerCaseScheme.substring(0,lowerCaseScheme.lastIndexOf('.')));
                    String protocol_s = lowerCaseScheme.substring(lowerCaseScheme.lastIndexOf('.'));
                    for (Protocol protocol: Protocol.values()) {
                        if (protocol.getLabel().equals(protocol_s)) {
                            try {
                                scheme = protocol.getSchemeClass().getConstructor(Terrene.class).newInstance(terrene);
                                ALL_KNOWN_SCHEMES.put(lowerCaseScheme,scheme);
                                return scheme;
                            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException |
                                     InvocationTargetException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    throw new RuntimeException("Protocol not found" + protocol_s);
                }
            }
        }
        return scheme;
    }

    @Override
    public URLStreamHandler createURLStreamHandler(String scheme) {
        return findSchemeByString(scheme);
    }

    public enum Protocol implements Meta_I {
        DEPOT("depot","Code Repository",8, DepotScheme.class),
        DNS("dns","Domain Name System",53, DnsScheme.class),
        INFO("user", "Information about personas", 12, InfoScheme.class),
        HTTP("http","Unsecure File Service", 80, HttpScheme.class),
        HTTPS("https","Secure File Service",443, HttpsScheme.class),
        LOG("log","Completed Matters",10, LogScheme.class),
        //REALM("realm", "Secure login Service", 6, RealmScheme.class)
        ;
        private final String label;
        private final String description;
        private final int defaultPort;
        private final Class<? extends Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>> schemeClass;
        private final String separator;

        Protocol(final String label, final String description, int defaultPort,Class<? extends Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>> schemeClass) {
            this(label,description,defaultPort,schemeClass,null);
        }
        Protocol(final String label, final String description, int defaultPort,Class<? extends Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>> schemeClass, String separator) {
            this.label = label;
            this.description = description;
            this.defaultPort = defaultPort;
            this.schemeClass = schemeClass;
            this.separator = Objects.requireNonNullElse(separator,"/");
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

        public Class<? extends Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>> getSchemeClass() {
            return schemeClass;
        }

        public String getSeparator() {
            return separator;
        }
    }
}
