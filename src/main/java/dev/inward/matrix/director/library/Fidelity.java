package dev.inward.matrix.director.library;

import dev.inward.matrix.MatrixException;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.concept.matter.Indicia;

public abstract class Fidelity {

    public static final InSitu Aforementioned = new InSitu();

    public static final Default Jail = new Default(Short.MIN_VALUE);
    public static final Default Notary = new Default((short)1);
    public static final Default Hoard = new Default((short)10001);
    public static final Default Storage = new Default((short)15001);
    public static final Default Cache = new Default((short)20001);

    private static class InSitu extends Fidelity {

        public InSitu() {
            super((short)0);
        }
    }
    public static class Default extends Fidelity {

        public Default(short fidelity) {
            super(fidelity);
            if (fidelity == (short)0) {
                throw new MatrixException(MatrixException.Type.InSitu_already_init,"Fidelity.Default init",Indicia.Focus.Assembly, Indicia.Severity.Critical, new Exception("InSitu can only have one, use Aforementioned"));
            }
        }
    }

    protected Zone zone;
    protected final short fidelity;

    public Fidelity(short fidelity) {
        this.fidelity = fidelity;
        this.zone = Zone.parse(fidelity);
    }

    public short getFidelity() {
        return fidelity;
    }
}
