package crud;

import dev.inward.crud.morph.Morph;
import dev.inward.matrix.log.Request;
import dev.inward.matrix.log.Response;

import java.lang.reflect.ParameterizedType;

public abstract class Crudem<UM extends Comparable<UM>, M extends Morph<?>, Q extends Request<?,?>, R extends Response<?,?>> {

    public final Class<UM> valueClass;
    public final Operation operation;

    public abstract R fulfill(M morph, Q request);

    public enum Operation {
        Create,
        Read,
        Update,
        Delete;
    }

    public Crudem(Operation operation) {
        this.operation = operation;
        this.valueClass = (Class<UM>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
