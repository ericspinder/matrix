/*
 *  Pinder's Matrix © 2026. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.catalog;

import java.util.Map;

public class Supplied extends Catalog<Supplied,SuppliedView,SuppliedModel> {

    private Supplied(final MountedRangedMount mountedRange, String name, boolean readOnly, Map<String,Object> attributes) {
        super(mountedRange,name,readOnly,attributes);
    }
}
