package crud;

import dev.inward.matrix.Dogma;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.Soul;
import dev.inward.matrix.director.library.Memory;

public class Anima extends Scheme<Anima, Soul, Dogma.Id.SuperEgo> {

    public Anima() {
        super("anima");
    }

    @Override
    public long initTotalSpace(Memory memory) {
        return 0;
    }

}
