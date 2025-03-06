/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud;

import dev.inward.matrix.Dogma;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.Soul;
import dev.inward.matrix.director.library.Memory;

public class Anima extends Scheme<Anima, Soul, Dogma.Id.SuperEgo> {

    public Anima() {
        super("anima");
    }

    @Override
    public long initTotalSpace(Memory memory) {
        return 0;
    }

}
