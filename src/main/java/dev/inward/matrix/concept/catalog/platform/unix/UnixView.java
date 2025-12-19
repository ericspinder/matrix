/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.catalog.platform.unix;

import dev.inward.matrix.concept.catalog.platform.PlatformView;

public abstract class UnixView<BC extends Unix<BC,BV,BM>,BV extends UnixView<BC,BV,BM>,BM extends UnixBureauModel<BC,BV,BM>> extends PlatformView<BC,BV,BM> {
    public UnixView(String name, BC unixBureau) {
        super(name, unixBureau);
    }
}
