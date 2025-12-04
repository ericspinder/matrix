/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.catalog.security.platform.windows;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.concept.catalog.security.platform.PlatformSecurityModel;

public abstract class WindowsSecurityModel extends PlatformSecurityModel<WindowsSecurity, WindowsSecurityView, WindowsSecurityModel> {
    public WindowsSecurityModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
