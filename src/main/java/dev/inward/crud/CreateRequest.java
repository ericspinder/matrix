package dev.inward.crud;

import dev.inward.log.Request;

import java.io.Serializable;

public class CreateRequest<C extends Comparable<C> & Serializable, V extends Comparable<V> & Serializable> extends Request<C, V> {

}
