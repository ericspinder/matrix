package dev.inward.matrix;

import dev.inward.matrix.fact.Concept;

import java.lang.ref.SoftReference;
import java.nio.file.attribute.FileAttributeView;

public abstract class View<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> implements FileAttributeView, Comparable<View<S,L,PATH,ID,T,C>> {

    protected final SoftReference<C> concept;
    protected final String name;
    protected final String description;

    public View(SoftReference<C> concept, String name, String description) {
        this.concept = concept;
        this.name = name;
        this.description = description;
    }

    @Override
    public String name() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public int compareTo(View<S, L, PATH, N, F> that) {
        int isZero = fact.getUuid().compareTo(that.fact.getUuid());
        if (isZero == 0) {
            return this.name.compareTo(that.name);
        }
        return isZero;
     }
}
