/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud.morph;

import dev.inward.matrix.Addressable;
import dev.inward.crud.Crudem;

import java.io.Serializable;
import java.util.EnumMap;

public abstract class Morpheme<UM extends Addressable<UM>> implements Serializable {

    protected final EnumMap<Crudem.Operation, Crudem> crudemMap;

    protected UM datum;

    public Morpheme(EnumMap<Crudem.Operation, Crudem> crudemMap) {
        this.crudemMap = crudemMap;
    }

}
