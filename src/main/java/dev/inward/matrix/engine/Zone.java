package dev.inward.matrix.engine;

import dev.inward.matrix.MatrixException;
import dev.inward.matrix.Meta_I;

/**
 * The Purpose of the Zone,
 */
public enum Zone implements Meta_I {
    InSitu("inSitu", "Represents the running system and is of the governance of the processes, synchronized with all remote inSitu systems"),
    Notary("notary", "designated as system of record and the transactional participant, a notary cannot be deleted in memory until expired"),
    Hoard("hoard", "historical record, perhaps expired cache, "),
    //Storage("storage", "Written storage", (short)15001,(short)20000),
    Cached("cache", "temporary storage"),
    Presentation("presentation", "used to offload read requests from InSitu servers"),
    Prompt("prompt", "Used for calculations"),
    Integration("integration","live data, but only replicated back to participant systems."),
    Test("label", "test data only")
    ;
    public final String label;
    public final String desc;

    Zone(String label, String desc) {
        this.label = label;
        this.desc = desc;
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
