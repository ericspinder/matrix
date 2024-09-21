package dev.inward.matrix;

import java.net.URLStreamHandler;
import java.net.spi.URLStreamHandlerProvider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MatrixURLStreamHandlerProvider extends URLStreamHandlerProvider {

    private static final Map<String,URLStreamHandler> protocolUrlStreamHandler = new ConcurrentHashMap<>();

    static {
        String enables = System.getenv().get("m_enable");
        if
        protocolUrlStreamHandler.put("")
    }
    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {

    }
}
