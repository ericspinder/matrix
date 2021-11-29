package dev.inward.matrix.setting.crud;

import dev.inward.matrix.Addressable;
import dev.inward.matrix.crud.Crudem;
import dev.inward.matrix.morph.Morph;

public abstract class Delete_fromGathering<UM extends Addressable<UM>, M extends Morph<UM>> extends Crudem<UM, M, DeleteRequest_fromGathering<UM>, DeleteResponse_fromGathering> {


    public Delete_fromGathering(Operation operation) {
        super(operation);
    }
}
