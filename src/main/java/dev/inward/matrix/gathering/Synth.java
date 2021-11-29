package dev.inward.matrix.gathering;

import dev.inward.matrix.setting.Setting;

import java.io.Serializable;

public class Synth<S extends Comparable<S> & Serializable, V extends Comparable<V> & Serializable> extends Setting {

    private Class<V> valueClass;
    private String description;
    private String i18n;

}
