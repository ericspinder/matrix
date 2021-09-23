package dev.inward.crud;

import dev.inward.log.Request;

import java.io.Serializable;

public class UpdateRequest<U extends Comparable<U> & Serializable, V extends Comparable<V> & Serializable> extends Request<U, V> {
}
