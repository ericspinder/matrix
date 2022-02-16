package dev.inward.matrix.gathering;

import com.notionds.dataSupplier.meta.Meta;
import com.notionds.dataSupplier.setting.Setting;

import java.io.Serializable;

public class Synth<DATUM extends Comparable<DATUM> & Serializable, S extends Synth<DATUM,S>> extends Setting {

    private Class<DATUM> dClass;
    private String description;
    private String i18n;
    Meta

}
