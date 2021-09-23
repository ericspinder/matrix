package dev.inward.crud;

import dev.inward.log.Response;

import java.io.Serializable;

public class DeleteResponse<V extends Comparable<V> & Serializable> extends Response<DeleteResponse<?>, DeleteRequest<?>> {

    @Override
    public int compareTo(DeleteResponse<?> o) {
        return 0;
    }
}
