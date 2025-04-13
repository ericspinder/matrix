/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.addressed.Addressed;
import dev.inward.matrix.file.addressed.AddressedView;
import dev.inward.matrix.file.addressed.AddressedKey;
import dev.inward.matrix.file.addressed.AddressedReference;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.security.cert.CertPath;
import java.util.Properties;
import java.util.function.Supplier;

public abstract class Operational<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends AddressedKey<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends AddressedReference<PATH,ID,I,A,R,F>,F extends AddressedView<PATH,ID,I,A,R,F>> {

    protected final CertPath[] certPaths;

    protected final Specification specification;
    // protected final Options
    protected final Properties properties;
    public Operational(CertPath[] certPaths, Properties properties, Specification specification) {
        this.certPaths = certPaths;
        this.properties = properties;
        this.specification = specification;
    }

    public CertPath[] getCertPaths() {
        return certPaths;
    }

    public Properties getProperties() {
        return properties;
    }

    @SuppressWarnings("unchecked")
    public java.util.function.Supplier<A> getNewSupplier() {
        Supplier<A> supplier = (Supplier<A>) this.properties.get("AddressedSupplier");
        if (supplier == null) {
            //specification
        }
        return null;
    }

}
