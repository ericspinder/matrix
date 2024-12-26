package dev.inward.matrix.code;

import dev.inward.matrix.*;
import dev.inward.matrix.memory.Memory;

import java.util.regex.Pattern;

public class Library_ofCode extends Library<Scheme_ofCode, Library_ofCode, Path_ofCode> {

    public Library_ofCode(Scheme_ofCode scheme, Domain domain, String branch, String structure, String packaging) {
        super(scheme, domain);
        this.branch = branch;
        this.structure = structure;
        this.packaging = packaging;
    }

}
