package dev.inward.matrix.https;

import dev.inward.matrix.Domain;
import dev.inward.matrix.Library;

public class Library_ofHttps extends Library<Scheme_ofHttps, Library_ofHttps, String> {

    public Library_ofHttps(Scheme_ofHttps scheme, Domain domain, int port) {
        super(scheme, domain, port);
    }
}
