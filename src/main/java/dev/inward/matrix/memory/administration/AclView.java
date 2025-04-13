/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.bureau;

import dev.inward.matrix.*;
import dev.inward.matrix.file.*;

import java.io.IOException;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;

public abstract class AclView<K extends MatrixKey<K,I,V,M,R, G>,I extends MatrixItem<K,I,V,M,R,G>,V extends View<I,M>,M extends Model<I>,R extends Reference<I,V,M,R,G>,G extends Gestalt<I,V,M,R,G>> extends View<I,M> implements AclFileAttributeView {
    public AclView(String name, I item, M model) {
        super(name, item, model);
    }

    @Override
    public List<AclEntry> getAcl() throws IOException {
        return null;
    }

    @Override
    public void setAcl(List<AclEntry> acl) throws IOException {

    }

    @Override
    public UserPrincipal getOwner() throws IOException {
        return null;
    }

    @Override
    public void setOwner(UserPrincipal owner) throws IOException {

    }
}
