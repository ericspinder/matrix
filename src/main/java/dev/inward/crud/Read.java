package dev.inward.crud;

import dev.inward.fact.session.Request;
import dev.inward.fact.session.Response;

public abstract class Read<V extends Comparable<V>> extends CrudOperation<V> {

    abstract boolean beforeRead(Request request);

    abstract Response afterRead(Response response);



}
