package dev.inward.matrix.crud;

import dev.inward.matrix.Addressable;
import dev.inward.matrix.log.Request;
import dev.inward.matrix.log.Response;

public class DeleteResponse<R extends Addressable<R>, Q extends Request<?,?>> extends Response<R, Q> {

    @Override
    public int compareTo(R o) {
        return 0;
    }
}
