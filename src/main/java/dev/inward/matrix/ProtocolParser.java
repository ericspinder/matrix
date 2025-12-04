/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.dns.DnsPath;
import dev.inward.matrix.concept.file.addressed.depot.DepotPath;
import dev.inward.matrix.concept.file.addressed.dns.ResourceRecordType;
import dev.inward.matrix.concept.file.addressed.log.LogPath;

import java.util.StringTokenizer;

public abstract class ProtocolParser<PATH extends Comparable<PATH>> {

    public static class Instances {
        public static final ProtocolParser<String> HTTP = new Http();
        public static final ProtocolParser<String> HTTPS = new Https();
    }

    protected final MatrixURLStreamHandlerProvider.Protocol protocol;

    protected ProtocolParser(MatrixURLStreamHandlerProvider.Protocol protocol) {
        this.protocol = protocol;
    }

    public abstract PATH parsePath(String rawPath);

    public MatrixURLStreamHandlerProvider.Protocol getProtocol() {
        return protocol;
    }

    public static class Http extends ProtocolParser<String> {

        private Http() {
            super(MatrixURLStreamHandlerProvider.Protocol.HTTP);
        }

        @Override
        public String parsePath(String rawPath) {
            return rawPath;
        }
    }
    public static class Https extends ProtocolParser<String> {

        private Https() {
            super(MatrixURLStreamHandlerProvider.Protocol.HTTPS);
        }

        @Override
        public String parsePath(String rawPath) {
            return rawPath;
        }
    }
    public static class Dns extends ProtocolParser<DnsPath> {

        private Dns() {
            super(MatrixURLStreamHandlerProvider.Protocol.DNS);
        }

        @Override
        public DnsPath  parsePath(String rawPath) {
            StringTokenizer stringTokenizer = new StringTokenizer(rawPath, protocol.getSeparator());
            switch (stringTokenizer.countTokens()) {
                case 1:
                    return new DnsPath(stringTokenizer.nextToken(), null);
                case 2:
                    String domain_part = stringTokenizer.nextToken();
                    ResourceRecordType rrType = ResourceRecordType.valueOf(stringTokenizer.nextToken());
                    return new DnsPath(domain_part,rrType);
                default:
                    throw new RuntimeException("dns path must be no more than ['domain name', '.in-addr.arpa' or '']/[resource record type]");
            }
        }
    }
    public static class Depot extends ProtocolParser<DepotPath> {
        public Depot() {
            super(MatrixURLStreamHandlerProvider.Protocol.DEPOT);
        }

        public DepotPath parsePath(String rawPath) {
            String[] path = rawPath.split(protocol.getSeparator());
            if (path.length > 1) {
                String[] packageName = new String[path.length - 1];
                System.arraycopy(path, 1, packageName, 0, path.length - 1);
                return new DepotPath(path[0], packageName);
            }
            if (path.length == 1) {
                return new DepotPath(path[0]);
            }
            return null;
        }
    }
    public static class Log extends ProtocolParser<LogPath> {

        public Log() {
            super(MatrixURLStreamHandlerProvider.Protocol.LOG);
        }

        @Override
        public LogPath parsePath(String rawPath) {
            String[] path = rawPath.split(protocol.getSeparator());
            return new LogPath(path[0], path[1], path[2], path[3]);
        }
    }
}
