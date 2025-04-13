/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.administration;

import dev.inward.matrix.MatrixKey;

import java.net.URI;

public class AdministrationKey<K extends AdministrationKey<K,A,V,M,R,G>,A extends Administration<K,A,V,M,R,G>,V extends AdministrationView<K,A,V,M,R,G>,M extends AdministrationModel<K,A,V,M,R,G>,R extends AdministrationReference<K,A,V,M,R,G>,G extends AdministrationGestalt<K,A,V,M,R,G>> extends MatrixKey<K,A,V,M,R,G> {
    protected AdministrationKey(URI uri) {
        super(uri);
    }
}
