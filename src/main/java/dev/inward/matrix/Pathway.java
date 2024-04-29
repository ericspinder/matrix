package dev.inward.matrix;

public abstract class Pathway<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>> implements Comparable<Pathway<S,L,PATH>> {

    public abstract L getLibrary();
    protected final PATH path;

    public Pathway(PATH path) {
        this.path = path;
    }
    public PATH getPath() {
        return path;
    }

    @Override
    public int compareTo(Pathway<S, L, PATH> that) {
        int isZero = this.getLibrary().compareTo(that.getLibrary());
        if (isZero == 0) {
            return this.path.compareTo(that.path);
        }
        return isZero;
    }
}
