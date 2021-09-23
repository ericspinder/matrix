package dev.inward.crud;

import dev.inward.log.Response;

import java.io.Serializable;

public class ReadResponse<V extends Comparable<V> & Serializable> extends Response<ReadResponse<V>, ReadRequest<?>> {

}
