package dev.inward.matrix.engine;

import dev.inward.matrix.Meta_I;

/**
 * The Purpose of the Zone,
 */
public enum Purpose implements Meta_I {
    Hoard("hoard", "historical record", 0),
    Notary("notary", "designated as system of record and a transactional participant", 1),
    InSitu("inSitu", "Represents the running system, and are part of the governance of the managing processes", 2),
    Storage("storage", "Written storage", 3),
    Batch("batch", "Used for calculations", 4),
    Cache("cache", "", 5);

    protected String label;
    protected String desc;
    protected int priority;

    Purpose(String label, String desc, int priority) {
        this.label = label;
        this.desc = desc;
        this.priority = priority;
    }


    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getDescription() {
        return desc;
    }

}
