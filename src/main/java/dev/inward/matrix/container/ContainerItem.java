/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.container;

import dev.inward.matrix.MatrixItem;

public interface ContainerItem<K extends ContainerKey<K,I,V,M,R,G>,I extends ContainerItem<K,I,V,M,R,G>,V extends ContainerView<K,I,V,M,R,G>,M extends ContainerModel<K,I,V,M,R,G>,R extends ContainerReference<K,I,V,M,R,G>,G extends ContainerSteward<K,I,V,M,R,G>> extends MatrixItem<K,I,V,M,R,G> {
}
