/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.memory.bureau.platform.unix;

import dev.inward.matrix.Aspect;

public final class DefaultUnixBureauModel extends UnixBureauModel<DefaultUnixBureau,DefaultUnixBureauView,DefaultUnixBureauModel> {
    public DefaultUnixBureauModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }

    @Override
    public int getDatumGenericPosition() {
        return 0;
    }
}
