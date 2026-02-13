/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.catalog;

import dev.inward.matrix.Range;

public class Mount<PATH extends Comparable<PATH>> {

    protected final RootMount rootMount;
    protected final Range<PATH> path;

    public static class RootMount<PATH extends Comparable<PATH>> extends Mount<PATH> {

        public RootMount() {
            super(null, new Range.AllPaths<>());
        }
    }
    public static class AllMount<PATH extends Comparable<PATH>> extends Mount<PATH> {

        public AllMount() {
            super(null, new Range.AllPaths<>());
        }
    }

    public Mount(RootMount rootMount, Range<PATH> path) {
        this.rootMount = rootMount;
        this.path = path;
    }


}
