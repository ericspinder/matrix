/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.file.*;
import dev.inward.matrix.item.datum.DatumClerk;

import java.security.ProtectionDomain;

public class Context<TARGET,V extends View<TARGET,V,M>,M extends Model<TARGET>,C extends Concept<TARGET,V,M>,X extends Context<TARGET,V,M,C,M>> extends ProtectionDomain {

    public Context(Variant variant, M personality, , ) {
        super(variant,personality,factory,null);
    }

    @SuppressWarnings("unchecked")
    public Variant getVariant() {
        return (Variant) this.getCodeSource();
    }
    @SuppressWarnings("unchecked")
    public M getModel() {
        return (M) this.getPermissions();
    }
    @SuppressWarnings("unchecked")
    public Factory<?,?,?,?,?,?,?,?,?,?,?,?> getFactory() {
        return (Factory<DF,DK,DV,DM,DR,DL,PATH>) this.getClassLoader();
    }

    public DatumClerk<?, ?, ?, ?, ?> getLibrarian() {
        return librarian;
    }

    public Library<DF, DK, DV, DM, DR, DL, PATH> getCatalog() {
        return library;
    }
}
