package crud.gathering;

import dev.inward.matrix.meta.Meta;
import dev.inward.matrix.setting.Setting;

import java.io.Serializable;

public class Synth<DATUM extends Comparable<DATUM> & Serializable, S extends Synth<DATUM,S>> extends Setting {

    private Class<DATUM> dClass;
    private String description;
    private String i18n;
    Meta

}
