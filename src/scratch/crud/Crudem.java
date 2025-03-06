/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

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
        Delete
    }

    public Crudem(Operation operation) {
        this.operation = operation;
        this.valueClass = (Class<UM>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
