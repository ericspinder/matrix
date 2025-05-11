/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.depot.DepotPath;
import dev.inward.matrix.file.addressed.dns.DnsPath;
import dev.inward.matrix.file.addressed.dns.ResourceRecordType;

import java.util.StringTokenizer;

public abstract class ProtocolParser<PATH extends Comparable<PATH>> {

    protected final MatrixURLStreamHandlerProvider.Protocol protocol;

    public ProtocolParser(MatrixURLStreamHandlerProvider.Protocol protocol) {
        this.protocol = protocol;
    }

    public abstract PATH parsePath(String rawPath);

    public static class Http extends ProtocolParser<String> {

        public Http() {
            super(MatrixURLStreamHandlerProvider.Protocol.HTTP);
        }

        @Override
        public String parsePath(String rawPath) {
            return rawPath;
        }
    }
    public static class Dns extends ProtocolParser<DnsPath> {
        public Dns() {
            super(MatrixURLStreamHandlerProvider.Protocol.DNS);
        }

        @Override
        public DnsPath parsePath(String rawPath) {
            StringTokenizer stringTokenizer = new StringTokenizer(rawPath, protocol.getSeparator());
            switch (stringTokenizer.countTokens()) {
                case 1:
                    return new DnsPath(stringTokenizer.nextToken(), null);
                case 2:
                    String domainName = stringTokenizer.nextToken();
                    ResourceRecordType rrType = ResourceRecordType.valueOf(stringTokenizer.nextToken());
                    return new DnsPath(domainName,rrType);
                default:
                    throw new RuntimeException("dns path must be at least a domain name, ")
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
}
