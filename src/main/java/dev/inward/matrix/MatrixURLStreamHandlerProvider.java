package dev.inward.matrix;

import dev.inward.matrix.code.Scheme_ofCode;
import dev.inward.matrix.dns.Scheme_ofDNS;
import dev.inward.matrix.http.Scheme_ofHttp;
import dev.inward.matrix.https.Scheme_ofHttps;
import dev.inward.matrix.info.Scheme_ofInfo;
import dev.inward.matrix.log.Scheme_ofLog;
import dev.inward.matrix.realm.Scheme_ofRealm;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URLStreamHandler;
import java.net.spi.URLStreamHandlerProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MatrixURLStreamHandlerProvider extends URLStreamHandlerProvider {

    private static final Map<String,URLStreamHandler> protocolUrlStreamHandlers = new ConcurrentHashMap<>();

    protected static final Map<String,Scheme<?,?,?>> ALL_KNOWN_SCHEMES = new HashMap<>();

    public static Scheme<?,?,?> findSchemeByString(String scheme_s) {
        Scheme<?,?,?> scheme = ALL_KNOWN_SCHEMES.get(scheme_s);
        if (scheme == null && scheme_s.indexOf('.') == -1) {
            findSchemeByString(Terrene.Earth.toString() + '.' + scheme_s);
        }
        else {
            synchronized (ALL_KNOWN_SCHEMES) {
                scheme = ALL_KNOWN_SCHEMES.get(scheme_s);
                if (scheme == null) {
                    Terrene terrene = Terrene.Parse(scheme_s);
                    for (Protocol protocol: Protocol.values()) {
                        if (protocol.getLabel().equals(scheme_s.substring(scheme_s.lastIndexOf('.')))) {
                            try {
                                scheme = protocol.schemeClass.getConstructor(Terrene.class).newInstance(terrene);
                                ALL_KNOWN_SCHEMES.put(scheme_s,scheme);
                            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException |
                                     InvocationTargetException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        }
        return scheme;
    }

    static {
        protocolUrlStreamHandlers.put("dns", Scheme_ofDNS.EARTH_SCHEME_OF_DNS);
        protocolUrlStreamHandlers.put("earth.dns", Scheme_ofDNS.EARTH_SCHEME_OF_DNS);
        protocolUrlStreamHandlers.put(Scheme_ofDNS.CHAOSNET_SCHEME_OF_DNS.scheme, Scheme_ofDNS.CHAOSNET_SCHEME_OF_DNS);
    }
    @Override
    public URLStreamHandler createURLStreamHandler(String scheme) {
        return findSchemeByString(scheme);
    }

    public enum Protocol implements Meta_I {
        CODE("code","Code Repository",8, Scheme_ofCode.class),
        DNS("dns","Domain Name System",53, Scheme_ofDNS.class),
        INFO("info", "Information about personas", 12, Scheme_ofInfo.class),
        HTTP("http","Unsecure File Service", 80, Scheme_ofHttp.class),
        HTTPS("https","Secure File Service",443, Scheme_ofHttps.class),
        LOG("log","Completed Matters",10, Scheme_ofLog.class),
        REALM("realm", "Secure login Service", 6, Scheme_ofRealm.class)
        ;
        private final String label;
        private final String description;
        private final int defaultPort;

        private final Class<? extends Scheme<?,?,?>> schemeClass;
        Protocol(final String label, final String description, int defaultPort,Class<? extends Scheme<?,?,?>> schemeClass) {
            this.label = label;
            this.description = description;
            this.defaultPort = defaultPort;
            this.schemeClass = schemeClass;
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

        public Class<? extends Scheme<?, ?, ?>> getSchemeClass() {
            return schemeClass;
        }
    }
}
