package crud.crud;

import dev.inward.matrix.Addressable;
import dev.inward.crud.Crudem;
import dev.inward.crud.morph.Morph;

public class Create_inGathering<UM extends Addressable<UM>, M extends Morph<UM>> extends Crudem<UM, M, CreateRequest_inGathering<UM>, CreateResponse_inGathering> {

    public Create_inGathering(Operation operation) {
        super(operation);
    }

    @Override
    public CreateResponse_inGathering fulfill(M morph, CreateRequest_inGathering<UM> request) {
        return null;
    }


}
