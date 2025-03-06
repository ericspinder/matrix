/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud.morph;

import dev.inward.crud.Crudem;
import dev.inward.matrix.datum.fact.notion.Notion;

import java.util.EnumMap;

public class FactMorph<F extends Notion<F>> extends Morph<F> {

    public FactMorph(EnumMap<Crudem.Operation, Crudem> crudemMap) {
        super(crudemMap);
    }
}
