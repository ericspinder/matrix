/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.scheme;

import dev.inward.matrix.Protocol;
import dev.inward.matrix.concept.fact.addressed.http.HttpProtocolParser;
import dev.inward.matrix.concept.fact.addressed.https.Https;
import dev.inward.matrix.concept.fact.addressed.dns.DnsPath;
import dev.inward.matrix.concept.fact.addressed.depot.DepotPath;
import dev.inward.matrix.concept.fact.addressed.dns.ResourceRecordType;
import dev.inward.matrix.concept.fact.addressed.ldap.LdapProtocolParser;
import dev.inward.matrix.item.datum.log.LogPath;
import dev.inward.matrix.control.terrene.Terrene;

import java.util.StringTokenizer;
import java.util.function.Function;

public abstract class ProtocolParser<PATH extends Comparable<PATH>> implements Function<String, PATH> {

    public static class Instances {
        public static final HttpProtocolParser HTTP = new HttpProtocolParser();
        public static final Https HTTPS = new Https();
        public static final Log LOG = new Log();
        public static final Dns DNS = new Dns();
        public static final LdapProtocolParser LDAP = new LdapProtocolParser();
        public static final Depot DEPOT = new Depot();
        public static final ProtocolParser<?>[] ALL = new ProtocolParser<?>[]{Instances.HTTP, Instances.HTTPS, Instances.LOG, Instances.DNS, Instances.LDAP, Instances.DEPOT};
    }

    protected final Protocol protocol;

    protected ProtocolParser(Protocol protocol) {
        this.protocol = protocol;
    }
    public abstract Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> newScheme(Terrene terrene);

    public abstract PATH apply(String rawPath);

    public Protocol getProtocol() {
        return protocol;
    }

    public static class Dns extends ProtocolParser<DnsPath> {

        private Dns() {
            super(Protocol.DNS);
        }

        @Override
        public DnsPath apply(String rawPath) {
            StringTokenizer stringTokenizer = new StringTokenizer(rawPath, protocol.getSeparator());
            switch (stringTokenizer.countTokens()) {
                case 1:
                    return new DnsPath(stringTokenizer.nextToken(), null);
                case 2:
                    String domain_part = stringTokenizer.nextToken();
                    ResourceRecordType rrType = ResourceRecordType.valueOf(stringTokenizer.nextToken());
                    return new DnsPath(domain_part,rrType);
                default:
                    throw new RuntimeException("dns path must be no more than ['domainName name', '.in-addr.arpa' or '']/[resource record type]");
            }
        }
    }
    public static class Depot extends ProtocolParser<DepotPath> {

        public Depot() {
            super(Protocol.DEPOT);
        }

        public DepotPath apply(String rawPath) {
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

        private Log() {
            super(Protocol.LOG);
        }

        @Override
        public LogPath apply(String rawPath) {
            String[] path = rawPath.split(protocol.getSeparator());
            return new LogPath(path[0], path[1], path[2], path[3]);
        }
    }
}
