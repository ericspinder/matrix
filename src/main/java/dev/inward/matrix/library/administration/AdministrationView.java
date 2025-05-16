/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.library.administration;

import dev.inward.matrix.library.LibraryView;

public abstract class AdministrationView<AC extends Administration<AC,AV,AM>,AV extends AdministrationView<AC,AV,AM>,AM extends AdministrationModel<AC,AV,AM>> extends LibraryView<AC,AV,AM> {

    public AdministrationView(String name, AC administration) {
        super(name, administration);
    }
}
