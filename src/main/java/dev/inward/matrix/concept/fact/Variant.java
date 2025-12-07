/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.concept.fact;

import java.security.CodeSigner;
import java.security.CodeSource;

public class Variant extends CodeSource {

    protected final CodeSigner[] codeSigners;


    public Variant(VariantKey variantKey, CodeSigner[] codeSigners) {
        super(variantKey);
        this.codeSigners = codeSigners;

    }

    public CodeSigner[] getCodeSigners() {
        return codeSigners;
    }
}