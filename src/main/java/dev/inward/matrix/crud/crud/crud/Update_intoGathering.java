package dev.inward.matrix.crud.crud.crud;

import dev.inward.matrix.Addressable;
import dev.inward.matrix.crud.Crudem;
import dev.inward.matrix.morph.Morph;


public abstract class Update_intoGathering<UM extends Addressable<UM>, M extends Morph<UM>> extends Crudem <UM, M, UpdateRequest_intoGathering<?>, UpdateResponse_intoGathering> {


    public Update_intoGathering(Operation operation) {
        super(operation);
    }
}
