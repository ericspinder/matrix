package dev.inward.crud;

import dev.inward.log.Request;

import java.io.Serializable;

public class DeleteRequest<V extends Comparable<V> & Serializable> extends Request<DeleteRequest<?>, V> {

}
