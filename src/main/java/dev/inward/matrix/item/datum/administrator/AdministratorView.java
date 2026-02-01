/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.item.datum.administrator;

import dev.inward.matrix.control.ControlView;

public class AdministratorView<A extends Administrator<A,V,M>,V extends AdministratorView<A,V,M>,M extends AdministratorModel<A,V,M>> extends ControlView<A,V,M> {

    public AdministratorView(String name, D datum) {
        super(name, datum);
    }
}
