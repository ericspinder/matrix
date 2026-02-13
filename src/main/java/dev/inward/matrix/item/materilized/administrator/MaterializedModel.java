/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item.materilized.administrator;

import dev.inward.matrix.item.datum.standard.Standard;
import dev.inward.matrix.control.ControlModel;

public class MaterializedModel<A extends Materialized<A,V,M>,V extends MaterializedView<A,V,M>,M extends MaterializedModel<A,V,M>> extends ControlModel<A,V,M> {
    public MaterializedModel(Standard standard) {
        super(standard);
    }
}
