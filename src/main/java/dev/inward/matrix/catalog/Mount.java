/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.catalog;

public class Mount {

    protected final RootMount rootMount;
    protected final String path;

    public static class RootMount extends Mount {

        public RootMount() {
            super(null, "/");
        }
    }

    public Mount(RootMount rootMount, String path) {
        this.rootMount = rootMount;
        this.path = path;
    }


}
