/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud.backup;

import java.io.Serializable;
import java.time.Instant;

public abstract class BackupSet<BS extends BackupSet<BS>> implements Comparable<BS>, Serializable {

    protected final Instant createDate;


    protected BackupSet(Instant createDate) {
        this.createDate = createDate;
    }
}
