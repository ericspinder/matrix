package dev.inward.matrix;

import java.util.Properties;

public class Attributes<DATUM,W extends Ware<DATUM,W,A>,A extends Attributes<DATUM,W,A>> {

    protected Model model;
    protected final Properties properties = new Properties();

    public Attributes(Resource<DATUM,W,A> resource, DATUM datum) {
        this.model = this.initProperties(resource, datum);
    }
    protected Model initProperties(Resource<DATUM,W,A> resource, DATUM datum) {
        // properties.put("initSize", Ziggurat.getInstance().getInstrumentation().getObjectSize(datum));
        resource.populate(properties,datum);
        return resource.getDefaultModel(datum);
    }

    public Properties getProperties() {
        return properties;
    }
}
