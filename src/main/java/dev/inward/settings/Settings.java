package dev.inward.settings;

import dev.inward.morph.Morph;

import java.util.EnumMap;

public class Settings<S extends Setting<S>> extends Morph<S>  {

    public Settings(EnumMap crudemMap) {
        super(crudemMap);
    }

}
