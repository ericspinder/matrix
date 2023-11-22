package dev.inward.matrix.route;

import dev.inward.matrix.Scheme;
import dev.inward.matrix.Library;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Context;
import dev.inward.matrix.director.library.Director;

import java.util.concurrent.*;

public class Route<S extends Scheme<S,L>,L extends Library<S,L>,D extends Director<S,L,D,R>,R extends Route<S,L,PATH,D,R>> extends Road<S,L,PATH,D,R,D,R> {

    public Route(Dispatch<S,L,PATH,D,R,D,R> dispatch) {
        super(dispatch);
    }


}
