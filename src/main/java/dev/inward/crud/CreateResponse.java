package dev.inward.crud;

import dev.inward.log.Response;

import java.io.Serializable;

public class CreateResponse<C extends Comparable<C> & Serializable, Q extends CreateRequest<?,?>> extends Response<C, Q> {

}
