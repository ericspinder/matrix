/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.catalog.security.platform.windows;

import dev.inward.matrix.control.catalog.security.platform.PlatformSecurity;

public abstract class WindowsSecurity extends PlatformSecurity<WindowsSecurity, WindowsSecurityView, WindowsSecurityModel> {

    public WindowsSecurity(String name, boolean readOnly, WindowsSecurityModel model) {
        super(name, readOnly, model);
    }
}
