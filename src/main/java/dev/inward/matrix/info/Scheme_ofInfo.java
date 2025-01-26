package dev.inward.matrix.info;

import dev.inward.matrix.Scheme;
import dev.inward.matrix.Terrene;

import java.net.URI;

public class Scheme_ofInfo extends Scheme<Scheme_ofInfo,Library_ofInfo,Path_ofInfo> {
    protected Scheme_ofInfo(Terrene terrene) {
        super(terrene, Protocol.INFO);
    }

    @Override
    public Library_ofInfo buildNewLibrary(URI uri) {
        return null;
    }

    @Override
    public int compareTo(Scheme_ofInfo o) {
        return 0;
    }
}
