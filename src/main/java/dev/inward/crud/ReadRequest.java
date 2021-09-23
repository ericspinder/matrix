package dev.inward.crud;

import dev.inward.log.Request;

import java.io.Serializable;

public class ReadRequest<R extends Comparable<R> & Serializable, V extends Comparable<V> & Serializable> extends Request<R, V> {

}
