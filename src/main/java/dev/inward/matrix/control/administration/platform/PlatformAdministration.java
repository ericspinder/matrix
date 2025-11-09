/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.administration.platform;

import dev.inward.matrix.control.administration.Administration;

public abstract class PlatformAdministration<AC extends PlatformAdministration<AC,AV,AM>,AV extends PlatformAdministrationView<AC,AV,AM>,AM extends PlatformAdministrationModel<AC,AV,AM>> extends Administration<AC,AV,AM> {
    public PlatformAdministration(String name, boolean readOnly, AM fileAdministrationModel) {
        super(name, readOnly, fileAdministrationModel);
    }
}
