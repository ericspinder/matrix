package dev.inward.matrix.crud;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;

public abstract class Indication<D extends Datum<D,O,C,I> ,O extends Operational<D,O>,C extends Container<D,O,C,I>,I extends Id<D,I,?>,I8N extends Indication<D,O,C,I,I8N>> implements Comparable<I8N>, Serializable {


}
