package dev.inward.matrix.crud;

import dev.inward.matrix.Addressable;
import dev.inward.matrix.log.Request;
import dev.inward.matrix.log.Response;


public class ReadResponse<R extends Addressable<R>, Q extends Request<Q, ?>> extends Response<R, ReadRequest<?, Q>> {

}
