package dev.inward.matrix;

import java.nio.file.attribute.AttributeView;
import java.util.Properties;

class DatumAttributes<D extends Datum<D,E,A>,E extends Envoy<D,E,A>, A extends DatumAttributes<D,E,A>> extends Attributes<D,E,A> implements AttributeView {

    public DatumAttributes(Properties properties) {
        super(properties);
    }

    @Override
    public String name() {
        return "Attributes";
    }
}
