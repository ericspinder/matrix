/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud.crud;

import dev.inward.matrix.Addressable;
import dev.inward.crud.Crudem;
import dev.inward.crud.morph.Morph;


public abstract class Update_intoGathering<UM extends Addressable<UM>, M extends Morph<UM>> extends Crudem <UM, M, UpdateRequest_intoGathering<?>, UpdateResponse_intoGathering> {


    public Update_intoGathering(Operation operation) {
        super(operation);
    }
}
