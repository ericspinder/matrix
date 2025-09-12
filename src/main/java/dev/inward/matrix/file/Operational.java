/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file;

import dev.inward.matrix.Model;
import dev.inward.matrix.Concept;
import dev.inward.matrix._WeakReference;
import dev.inward.matrix.View;
import dev.inward.matrix.file.addressed.depot.specification.Specification;

import java.security.cert.CertPath;
import java.util.Properties;

public abstract class Operational<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET>,R extends _WeakReference<TARGET,V,M,R,O>,O extends Operational<TARGET,V,M,R,O>> extends Concept<TARGET,V,M,O> {

    protected final Properties properties;
    public Operational(Specification specification) {
        specification.getOptions()
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
