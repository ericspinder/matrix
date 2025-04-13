/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.depot.variant;

import dev.inward.matrix.file.addressed.depot.Depot;

import java.security.CodeSigner;

public class Variant extends Depot<VariantLibrarian,VariantKey,Variant,VariantView,VariantModel,VariantReference, VariantSteward> {

    protected final CodeSigner[] codeSigners;


    public Variant(VariantKey variantKey, CodeSigner[] codeSigners) {
        super(variantKey);
        this.codeSigners = codeSigners;

    }

    public CodeSigner[] getCodeSigners() {
        return codeSigners;
    }
}