/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.library.bureau.platform.windows;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.library.bureau.platform.PlatformBureauModel;

public class WindowsBureauModel extends PlatformBureauModel<WindowsBureau,WindowsBureauView,WindowsBureauModel> {
    public WindowsBureauModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }

    @Override
    public int getDatumGenericPosition() {
        return 0;
    }
}
