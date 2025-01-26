package dev.inward.matrix.realm;

import dev.inward.matrix.Scheme;
import dev.inward.matrix.Terrene;

import java.net.URI;

public class Scheme_ofRealm extends Scheme<Scheme_ofRealm, Library_ofRealm,String> {
    protected Scheme_ofRealm(Terrene terrene) {
        super(terrene,Protocol.REALM);
    }

    @Override
    public Library_ofRealm buildNewLibrary(URI uri) {
        return null;
    }

    @Override
    public int compareTo(Scheme_ofRealm o) {
        return 0;
    }
}
