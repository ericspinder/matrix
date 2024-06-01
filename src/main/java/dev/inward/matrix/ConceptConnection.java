package dev.inward.matrix;

import dev.inward.matrix.fact.Concept;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class ConceptConnection<S extends Scheme<S,L>, L extends Library<S,L>, PATH extends Comparable<PATH>, ID extends Comparable<ID>, T extends Concept.Tangible<S,L,PATH,ID,T,C>, C extends Concept<S,L,PATH,ID,T,C>> extends URLConnection {
    /**
     * Constructs a URL connection to the specified URL. A connection to
     * the object referenced by the URL is not created.
     *
     * @param url the specified URL.
     */
    protected ConceptConnection(URL url) {
        super(url);
    }

    @Override
    public void connect() throws IOException {

    }
}
