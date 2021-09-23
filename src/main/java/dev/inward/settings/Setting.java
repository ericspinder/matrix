package dev.inward.settings;

import java.io.Serializable;

public class Setting<S extends Comparable<S>> implements Comparable<S>, Serializable {

    @Override
    public int compareTo(S o) {
        return 0;
    }
}
