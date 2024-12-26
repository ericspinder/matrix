package dev.inward.matrix;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.Specification;

import java.security.cert.CertPath;
import java.util.Properties;
import java.util.function.Supplier;

public abstract class Operational<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends Representative<PATH,ID,I,A,R,F>,F extends Addressed.FileAttributes<PATH,ID,I,A,R,F>> {

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
