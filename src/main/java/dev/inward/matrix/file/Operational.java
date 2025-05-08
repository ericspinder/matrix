/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file;

import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.directory.*;

import java.security.cert.CertPath;
import java.util.Properties;

public abstract class Operational<PATH extends Comparable<PATH>,DK extends DirectoryKey<PATH,DK,DF,DV,DM,DR,DB>,DF extends Directory<PATH,DK,DF,DV,DM,DR,DB>,DV extends DirectoryView<PATH,DK,DF,DV,DM,DR,DB>,DM extends DirectoryModel<PATH,DK,DF,DV,DM,DR,DB>,DR extends DirectoryReference<PATH,DK,DF,DV,DM,DR,DB>,DB extends DirectoryLibrarian<PATH,DK,DF,DV,DM,DR,DB>,K extends FileKey<PATH,DK,DF,DV,DM,DR,DB,K,F,V,M,R,B>,F extends File<PATH,DK,DF,DV,DM,DR,DB,K,F,V,M,R,B>,V extends FileView<PATH,DK,DF,DV,DM,DR,DB,K,F,V,M,R,B>,M extends FileModel<PATH,DK,DF,DV,DM,DR,DB,K,F,V,M,R,B>,R extends FileReference<PATH,DK,DF,DV,DM,DR,DB,K,F,V,M,R,B>,B extends FileLibrarian<PATH,DK,DF,DV,DM,DR,DB,K,F,V,M,R,B>> {

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
