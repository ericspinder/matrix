/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.concept.fact;

import java.net.URL;
import java.security.CodeSigner;
import java.security.CodeSource;

public class Variant extends CodeSource {


    public static Variant of(URL url, CodeSigner[] codeSigners) {


        return new Variant(url, codeSigners);
    }

    private Variant(URL url, CodeSigner[] codeSigners) {
        super(url, codeSigners);

    }

}