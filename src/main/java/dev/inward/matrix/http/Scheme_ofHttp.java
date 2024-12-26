package dev.inward.matrix.http;

import dev.inward.matrix.Domain;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.Terrene;
import dev.inward.matrix.https.Library_ofHttps;

import java.net.URI;

public class Scheme_ofHttp extends Scheme<Scheme_ofHttp, Library_ofHttp, String> {

    public static final Scheme_ofHttp EARTH_SCHEME_OF_HTTP = new Scheme_ofHttp(Terrene.Earth);
    public static final Scheme_ofHttp LUNA_SCHEME_OF_HTTP = new Scheme_ofHttp(Terrene.Luna);
    public static final Scheme_ofHttp MARS_SCHEME_OF_HTTP = new Scheme_ofHttp(Terrene.Mars);
    public static final Scheme_ofHttp CHAOSNET_SCHEME_OF_HTTP = new Scheme_ofHttp(Terrene.Chaosnet);


    protected Scheme_ofHttp(Terrene terrene) {
        super(terrene,Protocol.HTTP);
    }

    @Override
    public Library_ofHttp buildNewLibrary(URI uri) {
        return new Library_ofHttp(this, Domain.getInstance(this.terrene, uri.getHost()));
    }

    @Override
    public int compareTo(Scheme_ofHttp o) {
        return 0;
    }
}
