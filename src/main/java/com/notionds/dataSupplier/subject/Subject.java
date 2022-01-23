package com.notionds.dataSupplier.subject;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;

import java.io.Serializable;
import java.util.UUID;

public class Subject<D extends Datum<?,D,?,?,I>, I extends Id<?,I,?>, SUB extends Subject<D,I, SUB>> implements Comparable<SUB>, Serializable {

    private final UUID uuid;
    private final Matter<D,I, SUB> matter;
    public Subject(UUID uuid, Matter<D,I, SUB> matter) {
        this.uuid = uuid;
        this.matter = matter;
    }
    @Override
    public int compareTo(SUB that) {
        int result = this.matter.compareTo(matter);
        if (result == 0) {
            return this.uuid.compareTo(uuid);
        }
        return result;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Matter<D, I, SUB> getMatter() {
        return matter;
    }
}
