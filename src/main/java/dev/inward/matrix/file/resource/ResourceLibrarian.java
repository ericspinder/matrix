/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.resource;

import dev.inward.matrix.file.FileLibrarian;
import dev.inward.matrix.file.addressed.depot.standard.Standard;
import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.ControlModel;
import dev.inward.matrix.control.ControlView;

public class ResourceLibrarian<F extends Resource<F,K,V,M,R,L>,K extends ResourceKey<F,K,V,M,R,L>,V extends ResourceView<F,K,V,M,R,L>,M extends ResourceModel<F,K,V,M,R,L>,R extends ResourceReference<F,K,V,M,R,L>,L extends ResourceLibrarian<F,K,V,M,R,L,LB,LV,LM>,LB extends Control<LB,LV,LM>,LV extends ControlView<LB,LV,LM>,LM extends ControlModel<LB,LV,LM>> extends FileLibrarian<F,K,V,M,R,L,LB,LV,LM> {
    public ResourceLibrarian(Standard standard) {
        super(standard);
    }
}
