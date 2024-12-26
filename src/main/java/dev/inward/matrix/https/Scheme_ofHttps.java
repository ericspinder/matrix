package dev.inward.matrix.https;

import dev.inward.matrix.Domain;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.Terrene;

import java.net.URI;

public class Scheme_ofHttps extends Scheme<Scheme_ofHttps, Library_ofHttps, String> {

    public static final Scheme_ofHttps EARTH_SCHEME_OF_HTTPS = new Scheme_ofHttps(Terrene.Earth);
    public static final Scheme_ofHttps LUNA_SCHEME_OF_HTTPS = new Scheme_ofHttps(Terrene.Luna);
    public static final Scheme_ofHttps MARS_SCHEME_OF_HTTPS = new Scheme_ofHttps(Terrene.Mars);
    public static final Scheme_ofHttps CHAOSNET_SCHEME_OF_HTTPS = new Scheme_ofHttps(Terrene.Chaosnet);


    protected Scheme_ofHttps(Terrene terrene) {
        super(terrene,Protocol.HTTPS);
    }

    @Override
    public Library_ofHttps buildNewLibrary(URI uri) {
        return new Library_ofHttps(this, Domain.getInstance(terrene,uri.getHost()));
    }

    @Override
    public int compareTo(Scheme_ofHttps that) {
        return 0;
    }
}
