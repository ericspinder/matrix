/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file;

import dev.inward.matrix.DatumLibrarian;
import dev.inward.matrix.control.catalog.Catalog;
import dev.inward.matrix.file.directory.*;

import java.security.Principal;
import java.security.ProtectionDomain;

public class Context<DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends ProtectionDomain {

    protected final Catalog<DF,DK,DV,DM,DR,DL,PATH> catalog;
    protected final DatumLibrarian<?,?,?,?,?> librarian;
    public Context(Variant variant, Personality personality, Factory<DF,DK,DV,DM,DR,DL,PATH> factory, Catalog<DF,DK,DV,DM,DR,DL,PATH> catalog, DatumLibrarian<?,?,?,?,?> datumLibrarian) {
        super(variant,personality,factory,null);
        this.catalog = catalog;
        this.librarian = datumLibrarian
    }

    @SuppressWarnings("unchecked")
    public Variant getVariant() {
        return (Variant) this.getCodeSource();
    }
    @SuppressWarnings("unchecked")
    public Personality getPersonality() {
        return (Personality)this.getPermissions();
    }
    @SuppressWarnings("unchecked")
    public Factory<DF,DK,DV,DM,DR,DL,PATH> getFactory() {
        return (Factory<DF,DK,DV,DM,DR,DL,PATH>) this.getClassLoader();
    }

    public DatumLibrarian<?, ?, ?, ?, ?> getLibrarian() {
        return librarian;
    }

    public Catalog<DF, DK, DV, DM, DR, DL, PATH> getCatalog() {
        return catalog;
    }
}
