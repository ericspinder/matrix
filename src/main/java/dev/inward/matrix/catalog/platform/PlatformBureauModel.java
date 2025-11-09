/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.catalog.platform;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.control.bureau.BureauModel;

public abstract class PlatformBureauModel<BC extends PlatformBureau<BC,BV,BM>,BV extends PlatformBureauView<BC,BV,BM>,BM extends PlatformBureauModel<BC,BV,BM>> extends BureauModel<BC,BV,BM> {
    public PlatformBureauModel(Aspect[] labeledAspects) {
        super(labeledAspects);
    }
}
