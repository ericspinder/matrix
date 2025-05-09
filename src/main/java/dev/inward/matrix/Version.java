/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;


public class Version implements Comparable<Version>, Meta_I {

    protected final String name;
    protected final String version;
    protected final String description;

    protected Version(String name, String version, String description) {
        this.name = name;
        this.version = version;
        this.description = description;
    }
    public final String getName() {
        return this.name;
    }

    @Override
    public final String getLabel() {
        return this.name + "_" + this.version;
    }

    public final String getVersion() {
        return this.version;
    }

    @Override
    public final String getDescription() {
        return this.description;
    }
    @Override
    public final int compareTo(Version that) {
        int isZero = this.version.compareTo(that.version);
        if (isZero == 0) {
            return this.description.compareTo(that.description);
        }
        return isZero;
    }

}
