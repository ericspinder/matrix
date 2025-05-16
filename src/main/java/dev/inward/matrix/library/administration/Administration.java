/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.library.administration;

import dev.inward.matrix.library.Library;

public abstract class Administration<AC extends Administration<AC,AV,AM>,AV extends AdministrationView<AC,AV,AM>,AM extends AdministrationModel<AC,AV,AM>> extends Library<AC,AV,AM> {
    public Administration(String name, boolean readOnly, AM model) {
        super(name, readOnly, model);
    }
}
