/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.catalog.platform.unix;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.control.catalog.platform.PlatformModel;

public abstract class UnixBureauModel<BC extends Unix<BC,BV,BM>,BV extends UnixView<BC,BV,BM>,BM extends UnixBureauModel<BC,BV,BM>> extends PlatformModel<BC,BV,BM> {
    public UnixBureauModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
