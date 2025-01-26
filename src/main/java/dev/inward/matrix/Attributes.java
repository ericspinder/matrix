package dev.inward.matrix;

import java.util.Properties;

public class Attributes<DATUM,W extends Ware<DATUM,W,A>,A extends Attributes<DATUM,W,A>> {

    protected Model<DATUM,W,A> model;
    protected final Properties properties = new Properties();

    public Attributes(Model<DATUM,W,A> model) {
        this.model = model;
    }

    public void setModel(Model<DATUM, W, A> model) {
        this.model = model;
    }

    public Model<DATUM, W, A> getModel() {
        return model;
    }


    public Properties getProperties() {
        return properties;
    }
}
