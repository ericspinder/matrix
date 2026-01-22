/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.control.authority.Authority;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.control.administrator.UserName;

public abstract class Profile<S extends Scheme<S,L>,L extends Authority<S,L>,P extends Profile<S, L, P, U>,U extends UserName<S,L,U>> implements Comparable<P> {

    //protected final Map<U, AclEntryType>
    public Profile(UserName.Id<S,L,U> identity) {
        super(identity);
    }

    @Override
    public int compareTo(P o) {
        return 0;
    }
}
