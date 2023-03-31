package dev.inward.matrix.fact.datum.protocol;

import java.net.SocketImpl;
import java.net.SocketImplFactory;
import java.net.URLStreamHandler;

public class Protocol implements URLStreamHandler {

    protected final
    String getScheme();
    String getSignet();

    public static class Network implements Protocol {

        protected final String getScheme() {

        }

        protected final int defaultPort;
        protected final char defaultPortFail;

        public Network(String scheme, int defaultPort, Character defaultPortFail) {
            this.defaultPort = defaultPort;
            this.defaultPortFail = (defaultPortFail != null)? defaultPortFail :':';
        }
        public int getDefaultPort() {
            return defaultPort;
        }

        public char getDefaultPortFail() {
            return defaultPortFail;
        }
    }
}
