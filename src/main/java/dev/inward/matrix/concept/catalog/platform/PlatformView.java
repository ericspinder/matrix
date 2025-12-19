/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.catalog.platform;

import dev.inward.matrix.concept.catalog.CatalogView;
import dev.inward.matrix.control.administration.BureauView;

public class PlatformView<BC extends Platform<BC,BV,BM>,BV extends PlatformView<BC,BV,BM>,BM extends PlatformModel<BC,BV,BM>> extends CatalogView<BC,BV,BM> {

    public PlatformView(String name, BC bureau) {
        super(name, bureau);
    }
}
