package dev.inward.matrix.meta;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.house.House;

import java.io.Serializable;

public abstract class Standard<H extends House<H,?,?>,L extends Factory<L>,STAN extends Standard<H,L,STAN>> implements Comparable<STAN>, Serializable {

    private final Identity.SuperEgo<H,L> id;
    private final L library;
    private final String version;

    protected Standard(Identity.SuperEgo<H,L> id, L library, String version) {
        this.id = id;
        this.library = library;
        this.version = version;
    }
    public Identity.SuperEgo<H,L> getId() {
        return id;
    }
    public L getLibrary() {
        return library;
    }
    public String getVersion() {
        return version;
    }
}
