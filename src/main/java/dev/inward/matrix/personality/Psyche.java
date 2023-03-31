package dev.inward.matrix.personality;

import java.security.Permission;
import java.util.Arrays;
import java.util.Objects;

public class Psyche extends Personas {

    protected final String description;

    public Psyche(String name, char[] personas,String description) {
        super(name, personas);
        this.description = description;
    }

}
