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
