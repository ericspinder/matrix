/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.memory.administration.platform;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.control.memory.administration.AdministrationModel;

public abstract class PlatformAdministrationModel<AC extends PlatformAdministration<AC,AV,AM>,AV extends PlatformAdministrationView<AC,AV,AM>,AM extends PlatformAdministrationModel<AC,AV,AM>> extends AdministrationModel<AC,AV,AM> {
    public PlatformAdministrationModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
