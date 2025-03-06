/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud.morph;

import dev.inward.crud.Crudem;

import java.util.EnumMap;

public class GatheringMorph<G> extends Morph<G> {

    public GatheringMorph(EnumMap<Crudem.Operation, Crudem> crudemMap) {
        super(crudemMap);
    }
}
