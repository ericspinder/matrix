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
