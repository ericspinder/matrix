package dev.inward.matrix.dns;

import dev.inward.matrix.Domain;
import dev.inward.matrix.Terrene;
import dev.inward.matrix.Scheme;

import java.net.URI;

public class Scheme_ofDNS extends Scheme<Scheme_ofDNS,Library_ofDNS,Path_ofDNS> {

    public static final Scheme_ofDNS EARTH_SCHEME_OF_DNS = new Scheme_ofDNS(Terrene.Earth);
    public static final Scheme_ofDNS LUNA_SCHEME_OF_DNS = new Scheme_ofDNS(Terrene.Luna);
    public static final Scheme_ofDNS MARS_SCHEME_OF_DNS = new Scheme_ofDNS(Terrene.Mars);
    public static final Scheme_ofDNS CHAOSNET_SCHEME_OF_DNS = new Scheme_ofDNS(Terrene.Chaosnet);
    protected Scheme_ofDNS(Terrene terrene) {
        super(terrene,Protocol.DNS);
    }

    @Override
    public Library_ofDNS buildNewLibrary(URI uri) {
        return new Library_ofDNS(this, Domain.getInstance(this.terrene, uri.getHost()));
    }

    @Override
    public int compareTo(Scheme_ofDNS that) {
        return this.terrene.compareTo(that.terrene);
    }
}
