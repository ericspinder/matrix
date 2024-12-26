package dev.inward.matrix;

import dev.inward.matrix.dns.Scheme_ofDNS;

import java.net.URLStreamHandler;
import java.net.spi.URLStreamHandlerProvider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MatrixURLStreamHandlerProvider extends URLStreamHandlerProvider {

    private static final Map<String,URLStreamHandler> protocolUrlStreamHandlers = new ConcurrentHashMap<>();

    static {
        Terrene terrene = System.getenv().get("m_enable");
        protocolUrlStreamHandlers.put("dns", Scheme_ofDNS.Instance());
    }
    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
        Scheme
    }
}
