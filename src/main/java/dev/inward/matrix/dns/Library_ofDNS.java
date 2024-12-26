package dev.inward.matrix.dns;

import dev.inward.matrix.*;
import dev.inward.matrix.memory.Memory;

import java.util.regex.Pattern;

public class Library_ofDNS extends Library<Scheme_ofDNS,Library_ofDNS,Path_ofDNS> {
    public Library_ofDNS(Scheme_ofDNS scheme, Domain domain) {
        super(scheme, domain);
    }
}
