package dev.inward.crud;

import dev.inward.log.Response;

import java.io.Serializable;

public class UpdateResponse<U extends Comparable<U> & Serializable> extends Response<UpdateResponse<?>, UpdateRequest<?>> {
}
