/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.memory.bureau.file.unix;

import dev.inward.matrix.Aspect;

public final class DefaultUnixBureauModel extends UnixBureauModel<DefaultUnixBureauKey,DefaultUnixBureau,DefaultUnixBureauView,DefaultUnixBureauModel,DefaultUnixBureauReference, DefaultUnixBureauLibrarian> {
    public DefaultUnixBureauModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
