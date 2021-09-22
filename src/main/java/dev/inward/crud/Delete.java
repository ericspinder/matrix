package dev.inward.crud;

import dev.inward.HouseKeeping;
import dev.inward.fact.session.Response;

public abstract class Delete<V extends Comparable<V>> extends CrudOperation<V> {

    protected abstract Response beforeDelete();
    protected abstract Response afterDelete(Response response);

    public Delete(HouseKeeping houseKeeping) {
        super(houseKeeping);
    }
    protected Response doDelete() {}protected Response doDelete() {}
}
