package dev.inward.matrix.engine;

import dev.inward.matrix.MatrixException;
import dev.inward.matrix.Meta_I;

/**
 * The Purpose of the Zone,
 */
public enum Zone implements Meta_I {
    Jail("","",Short.MIN_VALUE,(short)-1),
    InSitu("inSitu", "Represents the running system, and is of the governance of the processes",(short)0,(short)0),
    Notary("notary", "designated as system of record and a transactional participant, purpose can be updated but a notary fact cannot be deleted directly until expired", (short)1,(short)10000),
    Hoard("hoard", "historical record, might have been copied from another Domain, if so, there should be a record of this being created, with the originating Domain recorded there", (short)10001,(short)15000),
    Storage("storage", "Written storage", (short)15001,(short)20000),
    Cache("cache", "Planned temporary storage", (short)20001,(short)25000),
    Prompt("prompt", "Used for calculations", (short)25001,Short.MAX_VALUE),

    ;
    public final String label;
    public final String desc;
    public final Short start;
    public final Short end;

    Zone(String label, String desc, short start, short end) {
        this.label = label;
        this.desc = desc;
        this.start = start;
        this.end = end;
    }
    public boolean assignable(short intersection) {
        return start >= intersection && end <= intersection;
    }
    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getDescription() {
        return desc;
    }

    public short getStart() {
        return this.start;
    }

    public short getEnd() {
        return this.end;
    }

    public static Zone parse(short fidelity) {
        for (Zone zone: Zone.values()) {
            if (zone.assignable(fidelity)) {
                return zone;
            }
        }
        return Jail;
    }

}
