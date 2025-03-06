/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import java.util.Properties;

public class Branch implements Comparable<Branch> {

    protected final String name;
    protected final Properties properties;
    public Branch(String name,Properties seed) {
        this.name = name;
        this.properties = new Properties(seed);
    }

    public String getName() {
        return name;
    }

    public Properties getProperties() {
        return properties;
    }

    @Override
    public int compareTo(Branch that) {
        return this.name.compareTo(that.name);
    }
}
