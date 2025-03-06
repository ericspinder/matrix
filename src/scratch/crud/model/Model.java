/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud.model;

import dev.inward.crud.gathering.Lexicon;
import dev.inward.crud.gathering.Synth;
import dev.inward.matrix.datum.fact.notion.Notion;

import java.util.List;

public class Model<F extends Notion<F>, L extends Lexicon<F>> {

    private L lexicon;

    private List<Synth> synths;

}