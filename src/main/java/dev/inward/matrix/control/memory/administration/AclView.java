/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.memory.administration;

import dev.inward.matrix.*;

import java.nio.file.attribute.AclFileAttributeView;

public abstract class AclView<K extends MatrixKey<K,I,V,M,R,G>,I extends MatrixItem<K,I,V,M,R,G>,V extends View<I,M>,M extends Model<I>,R extends Reference<I,V,M,R,G>,G extends Librarian<I,V,M,R,G>> extends View<I,V,M> implements AclFileAttributeView {
    public AclView(String name, I item) {
        super(name, item);
    }

}
