package dev.inward.matrix;

import java.net.URLStreamHandler;
import java.net.spi.URLStreamHandlerProvider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MatrixURLStreamHandlerProvider extends URLStreamHandlerProvider {

    private static final Map<String,URLStreamHandler> protocolUrlStreamHandlers = new ConcurrentHashMap<>();

    static {
        String enables = System.getenv().get("m_enable");
        if
        protocolUrlStreamHandlers.put("dns", Scheme.DNS.Instance());
    }
    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {

    }
}
