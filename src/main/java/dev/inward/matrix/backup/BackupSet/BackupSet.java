package dev.inward.matrix.backup.BackupSet;

import java.io.Serializable;
import java.time.Instant;

public abstract class BackupSet<BS extends BackupSet<BS>> implements Comparable<BS>, Serializable {

    protected final Instant createDate;


    protected BackupSet(Instant createDate) {
        this.createDate = createDate;
    }
}
