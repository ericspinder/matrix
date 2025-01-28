package dev.inward.matrix.info;

import dev.inward.matrix.Domain;
import dev.inward.matrix.MatrixURLStreamHandlerProvider;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.Terrene;

import java.net.URI;

public class Scheme_ofInfo extends Scheme<Scheme_ofInfo,Library_ofInfo,Path_ofInfo> {
    protected Scheme_ofInfo(Terrene terrene) {
        super(terrene, MatrixURLStreamHandlerProvider.Protocol.INFO);
    }

    @Override
    public int compareTo(Scheme_ofInfo o) {
        return 0;
    }

    @Override
    protected Library_ofInfo buildNewLibrary(Domain domain, int port) {
        return new Library_ofInfo(this,domain, port);
    }
}
