/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.catalog.platform.unix;

import dev.inward.matrix.concept.catalog.platform.PlatformBureauView;

public abstract class UnixBureauView<BC extends UnixBureau<BC,BV,BM>,BV extends UnixBureauView<BC,BV,BM>,BM extends UnixBureauModel<BC,BV,BM>> extends PlatformBureauView<BC,BV,BM> {
    public UnixBureauView(String name, BC unixBureau) {
        super(name, unixBureau);
    }
}
