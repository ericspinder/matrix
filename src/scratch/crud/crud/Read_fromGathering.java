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

public class Read_fromGathering<UM extends Addressable<UM>, M extends Morph<UM>> extends Crudem<UM,M, ReadRequest_ofGathering<?>, ReadResponse_ofGathering> {

    public Read_fromGathering(Operation operation) {
        super(operation);
    }

    @Override
    public ReadResponse_ofGathering fulfill(M morph, ReadRequest_ofGathering<?> request) {
        return null;
    }
}
