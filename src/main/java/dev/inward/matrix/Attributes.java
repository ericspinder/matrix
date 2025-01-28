package dev.inward.matrix;

import java.util.Properties;

public class Attributes<DATUM,W extends Ware<DATUM,W,A>,A extends Attributes<DATUM,W,A>> {

    protected final Properties properties;

    public Attributes(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }
}
