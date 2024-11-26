package dev.inward.matrix;

import java.lang.ref.SoftReference;
import java.nio.file.attribute.AclFileAttributeView;

public abstract class View<PATH extends Comparable<PATH>,P extends Pathway<PATH,P>,ID extends Comparable<ID>,T extends Concept.Identity<PATH,P,ID,T,C>,C extends Concept<PATH,P,ID,T,C>> implements AclFileAttributeView, Comparable<View<PATH,P,ID,T,C>> {

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
    public int compareTo(View<PATH,P,ID,T,C> that) {
        int isZero = that.getUuid().compareTo(that.getUuid());
        if (isZero == 0) {
            return this.name.compareTo(that.name);
        }
        return isZero;
     }
}
