package dev.inward.matrix.fact.authoritative.notion.concept;

import dev.inward.matrix.Scheme;
import dev.inward.matrix.director.library.Memory;
import dev.inward.matrix.Range;

public class Matrix<PATH extends Comparable<PATH>> extends Scheme<Matrix<PATH>,Construct<PATH>, Range<PATH>> {

    public Matrix() {
        super("matrix");
    }

    @Override
    public long initTotalSpace(Memory memory) {
        return 0;
    }
}
