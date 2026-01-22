/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.administrator;

import dev.inward.matrix.concept.fact.addressed.depot.specification.Specification;
import dev.inward.matrix.concept.fact.addressed.depot.standard.Standard;
import dev.inward.matrix.item.datum.DatumClerk;

public class AdministratorClerk<D extends Administrator<D,V,M,C>,V extends AdministratorView<D,V,M,C>,M extends AdministratorModel<D,V,M,C>,C extends AdministratorClerk<D,V,M,C>> extends DatumClerk<D,V,M,C> {

    public AdministratorClerk(Standard standard, Specification specification) {
        super(standard);
    }
}
