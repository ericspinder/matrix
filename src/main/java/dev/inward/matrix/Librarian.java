package dev.inward.matrix;

import java.net.URL;

public abstract class Librarian<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R>,A extends Addressed<PATH,ID,I,A,R>,R extends Representative<PATH,ID,I,A,R>> {

    protected Addressed.Resource<PATH,ID,I,A,R> resource;

    public Librarian(Addressed.Resource<PATH,ID,I,A,R> resource) {
        this.resource = resource;
    }

    public Addressed.Resource<PATH,ID,I,A,R> getResource() {
        return this.resource;
    }

    public A getAddressedNotion(URL url) {
        Notion<PATH,ID,I,A,R,>
    }

}
