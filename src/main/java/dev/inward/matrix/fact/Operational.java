package dev.inward.matrix.fact;

import dev.inward.matrix.*;

import java.security.cert.CertPath;
import java.util.Properties;
import java.util.function.Supplier;

public abstract class Operational<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,PR>,A extends Addressed<PATH,ID,I,A,R,PR>,R extends Representitive<PATH,ID,I,A,R,PR>,PR extends Representitive<PATH,?,?,?,PR,?>> {

    protected final CertPath[] certPaths;

    protected final Specification specification;
    // protected final Options
    protected final Properties properties;
    public Operational(CertPath[] certPaths, Properties properties) {
        this.certPaths = certPaths;
        this.properties = properties;
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
            specification
        }
    }

}
