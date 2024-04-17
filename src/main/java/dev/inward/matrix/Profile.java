package dev.inward.matrix;

public abstract class Profile<S extends Scheme<S,L>,L extends Library<S,L>,P extends Profile<S, L, P, U>,U extends Dogma<S,L,U>> implements Comparable<P> {

    //protected final Map<U, AclEntryType>
    public Profile(Dogma.Ethereal<S,L,U> identity) {
        super(identity);
    }

    @Override
    public int compareTo(P o) {
        return 0;
    }
}
