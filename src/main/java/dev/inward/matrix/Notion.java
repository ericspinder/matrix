package dev.inward.matrix;

import java.net.URL;
import java.util.List;

public class Notion<> extends Operation<PATH,ID,I,A,R,N> {

    public Notion(URL url) {
        super(url);
    }

    }

    public static class Gathering<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R>,A extends Addressed<PATH,ID,I,A,R>,R extends Representative<PATH,ID,I,A,R>,N extends Notion<PATH,ID,I,A,R,N>> extends dev.inward.matrix.Gathering<PATH,ID,I,A,R,N> {

        public Gathering(Addressed.Resource<PATH,ID,I,A,R,PR> resource, List<Notion<PATH,ID,I,A,R,PR>> containers) {
            super(resource, containers);
        }
    }

}
