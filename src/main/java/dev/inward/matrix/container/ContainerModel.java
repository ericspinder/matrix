/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.container;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.Model;

public abstract class ContainerModel<K extends ContainerKey<K,I,V,M,R,G>,I extends ContainerItem<K,I,V,M,R,G>,V extends ContainerView<K,I,V,M,R,G>,M extends ContainerModel<K,I,V,M,R,G>,R extends ContainerReference<K,I,V,M,R,G>,G extends ContainerSteward<K,I,V,M,R,G>> extends Model<I> {
    public ContainerModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
