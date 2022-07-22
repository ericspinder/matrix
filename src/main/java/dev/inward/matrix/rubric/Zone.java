package dev.inward.matrix.rubric;

import dev.inward.matrix.library.Location;

public abstract class Zone {

    protected Location location;

    public Location getLocation() {
        return this.location;
    }
    public static class InSitu extends Zone {

    }
    public static class Cache extends Zone {

    }
    public static class Storage extends Zone {

    }
    public static class Hoard extends Zone {

    }
}
