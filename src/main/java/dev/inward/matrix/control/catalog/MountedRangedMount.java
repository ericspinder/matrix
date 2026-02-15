/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.catalog;

import dev.inward.matrix.RangedMount;

public class MountedRangedMount<PATH extends Comparable<PATH>> extends RangedMount<PATH> {


    private Mount[] mounts;
    public static class Mounted<PATH extends Comparable<PATH>> extends MountedRangedMount<PATH> {

        public Mounted() {
            super();
        }
    }

    public MountedRangedMount(RootMountedRange<PATH> rootMount, PATH path) {
        this.rootMount = rootMount;
        this.path = path;
    }


}
