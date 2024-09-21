package dev.inward.matrix.fact;

import dev.inward.matrix.Library;
import dev.inward.matrix.View;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.Notion;

public class Label<S extends Scheme<S,L,PATH>,L extends Library<S,L,PATH>,PATH extends Comparable<PATH>,N extends Notion<S,L,PATH,N>> extends View<S,L,PATH> {

    final transient N notion;

    public Label(String label, String description, N notion) {
        super(label, description);
        this.notion = notion;
    }

    public boolean checkAccess(Visitor visitor) {

    }


}
